import os
import random
import json
import time
import numpy as np
import copy
import shutil
import concurrent.futures
from distutils.dir_util import copy_tree

DUPLICATE_CORES_FOLDER_NAME = "duplicate_cores"
TROOP_SOURCE_FILE_NAME_1 = "../src/wtest_evolution_pvp_1/Troop.java"
TROOP_SOURCE_FILE_NAME_2 = "../src/wtest_evolution_pvp_2/Troop.java"
TROOP_REPLACE_FILE_NAME_1 = "src/wtest_evolution_pvp_1/Troop.java"
TROOP_REPLACE_FILE_NAME_2 = "src/wtest_evolution_pvp_2/Troop.java"
BUILD_FILE_NAME = "build.defaults"
GAMES_FOLDER_NAME = "games"
MODEL_FOLDER_NAME = "models/barbarian_duel"

WEIGHTS_START = "/*weights_start*/"
WEIGHTS_END = "/*weights_end*/"
BIASES_START = "/*biases_start*/"
BIASES_END = "/*biases_end*/"
LAYER_SIZES = [15, 16, 16, 9]
PACKAGE_1 = "wtest_evolution_pvp_1"
PACKAGE_2 = "wtest_evolution_pvp_2"
MAPS = ["Duel"]
NUM_CORES = 4
NUM_DECIMALS = 8
NUM_CREATURES_PER_GENERATION = 100
NUM_SURVIVORS_PER_GENERATION = 20
NUM_MUTATIONS_PER_SURVIVOR = 5
NUM_MATCHUPS_PER_CREATURE = 4
INITIAL_RANGE = 5
MUTATION_PERCENT_SD = 0.1

def create_duplicate_cores():
    stream = os.popen(f"rm -rf {DUPLICATE_CORES_FOLDER_NAME}")
    stream.read()
    for core in range(NUM_CORES):
        os.makedirs(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}")
        copy_tree(f"../jars", f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/jars")
        os.makedirs(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/maps")
        for map in MAPS:
            shutil.copyfile(f"../maps/{map}.txt", f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/maps/{map}.txt")
        os.makedirs(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/src")
        copy_tree(f"../src/{PACKAGE_1}", f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/src/{PACKAGE_1}")
        copy_tree(f"../src/{PACKAGE_2}", f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/src/{PACKAGE_2}")
        shutil.copyfile(f"../AIC2022.iml", f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/AIC2022.iml")
        shutil.copyfile(f"../build.defaults", f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/build.defaults")
        shutil.copyfile(f"../build.xml", f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/build.xml")

def copy_file(weights_string, biases_string, source_file_name, copy_file_name):
    with open(source_file_name, "r") as fin:
        with open(copy_file_name, "w") as fout:
            for line in fin:
                if WEIGHTS_START in line and WEIGHTS_END in line:
                    fout.write(WEIGHTS_START + weights_string + WEIGHTS_END + "\n")
                elif BIASES_START in line and BIASES_END in line:
                    fout.write(BIASES_START + biases_string + BIASES_END + "\n")
                else:
                    fout.write(line)

def array_to_string(array):
    string = str(array).replace("[", "{").replace("]", "}")
    for digit in ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]:
        string = string.replace(digit + ",", digit + "f,")
        string = string.replace(digit + "}", digit + "f}")
    return string

def get_next_generation():
    files = [f for f in os.listdir(MODEL_FOLDER_NAME) if os.path.isfile(os.path.join(MODEL_FOLDER_NAME, f))]
    next_generation = 0
    for file in files:
        if ".json" in file:
            generation = int(file.replace(".json", "").replace("generation_", "")) + 1
            if generation > next_generation:
                next_generation = generation
    return next_generation

def generate_random_weights():
    weights = []
    for layer_index in range(len(LAYER_SIZES)):
        layer = []
        for neuron_index in range(LAYER_SIZES[layer_index]):
            next_layer = []
            if layer_index != len(LAYER_SIZES) - 1:
                for next_neuron_index in range(LAYER_SIZES[layer_index + 1]):
                    weight = round(random.uniform(-INITIAL_RANGE, INITIAL_RANGE), NUM_DECIMALS)
                    next_layer.append(weight)
            layer.append(next_layer)
        weights.append(layer)
    return weights

def generate_random_biases():
    biases = []
    for layer_index in range(len(LAYER_SIZES)):
        layer = []
        for neuron_index in range(LAYER_SIZES[layer_index]):
            bias = 0
            if layer_index != 0:
                bias = round(random.uniform(-INITIAL_RANGE, INITIAL_RANGE), NUM_DECIMALS)
            layer.append(bias)
        biases.append(layer)
    return biases

def generate_initial_creatures():
    creatures = []
    for creature_index in range(NUM_CREATURES_PER_GENERATION):
        creatures.append({
            "index": creature_index,
            "weights": generate_random_weights(),
            "biases": generate_random_biases()
        })
    return creatures

def read_generation_creatures(generation):
    with open(f"{MODEL_FOLDER_NAME}/generation_{generation}.json", "r") as f:
        creatures = json.loads(f.read())
        return creatures

def write_generation(generation, creatures):
    with open(f"{MODEL_FOLDER_NAME}/generation_{generation}.json", "w") as f:
        json.dump(creatures, f)

def randomize_seed(core):
    with open(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{BUILD_FILE_NAME}", "r") as fin:
        lines = fin.readlines()
    lines[0] = "package1=" + PACKAGE_1 + "\n"
    lines[1] = "package2=" + PACKAGE_2 + "\n"
    lines[2] = "map=" + random.choice(MAPS) + "\n"
    lines[3] = "seed=" + str(random.randint(0, 1000000)) + "\n"
    with open(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{BUILD_FILE_NAME}", "w") as fout:
        fout.writelines(lines)

def get_game_outcome(core):
    files = [f for f in os.listdir(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{GAMES_FOLDER_NAME}") if os.path.isfile(os.path.join(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{GAMES_FOLDER_NAME}", f))]
    for file in files:
        if ".txt" in file:
            with open(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{GAMES_FOLDER_NAME}/{file}") as f:
                winner = ""
                win_method = ""
                line_num = 0
                for line in f:
                    line_num += 1
                    if line_num == 6:
                        winner = line.strip()
                    elif line_num == 7:
                        win_method = line.strip()
                        return winner, win_method, file
    return "A", "", ""

def simulate_game(generation, game_number, core, creature_1, creature_2):
    start_time = time.time()

    copy_file("final float[][][] weights = " + array_to_string(creature_1["weights"]) + ";", "final float[][] biases = " + array_to_string(creature_1["biases"]) + ";", TROOP_SOURCE_FILE_NAME_1, f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{TROOP_REPLACE_FILE_NAME_1}")
    copy_file("final float[][][] weights = " + array_to_string(creature_2["weights"]) + ";", "final float[][] biases = " + array_to_string(creature_2["biases"]) + ";", TROOP_SOURCE_FILE_NAME_2, f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{TROOP_REPLACE_FILE_NAME_2}")

    randomize_seed(core)
    stream = os.popen(f"cd {DUPLICATE_CORES_FOLDER_NAME}/core_{core}; rm -rf games; ant run")
    stream.read()
    winner, win_method, file = get_game_outcome(core)

    creature_1_score_change = 0
    creature_2_score_change = 0

    if win_method != "Random":
        if winner == "A":
            creature_1["score"] += 1
            creature_1_score_change += 1
            if creature_1["score"] == NUM_MATCHUPS_PER_CREATURE:
                shutil.copyfile(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{GAMES_FOLDER_NAME}/{file}", MODEL_FOLDER_NAME + "/replay_" + str(generation) + "_" + str(creature_1["index"]) + ".txt")
        else:
            creature_2["score"] += 1
            creature_2_score_change += 1
            if creature_2["score"] == NUM_MATCHUPS_PER_CREATURE:
                shutil.copyfile(f"{DUPLICATE_CORES_FOLDER_NAME}/core_{core}/{GAMES_FOLDER_NAME}/{file}", MODEL_FOLDER_NAME + "/replay_" + str(generation) + "_" + str(creature_2["index"]) + ".txt")

    end_time = time.time()
    time_elapsed = end_time - start_time
    print("game " + str(game_number) + ", creature " + str(creature_1["index"]) + " (" + str(creature_1["score"]) + "), creature " + str(creature_2["index"]) + " (" + str(creature_2["score"]) + "), (" + str(round(time_elapsed, 2)) + "s)")

    return creature_1["index"], creature_1_score_change, creature_2["index"], creature_2_score_change

def simulate_creatures(generation, creatures):
    creatures_num_games = {}
    for creature_index in range(len(creatures)):
        creatures_num_games[creature_index] = 0
        creatures[creature_index]["score"] = 0

    games = []
    game_number = 0
    while len(creatures_num_games) >= 2:
        core = game_number % NUM_CORES
        creature_1_index, _ = random.choice(list(creatures_num_games.items()))
        creature_2_index, _ = random.choice(list(creatures_num_games.items()))
        while creature_2_index == creature_1_index:
            creature_2_index, _ = random.choice(list(creatures_num_games.items()))

        games.append((game_number, core, creature_1_index, creature_2_index))

        creatures_num_games[creature_1_index] += 1
        creatures_num_games[creature_2_index] += 1

        if creatures_num_games[creature_1_index] >= NUM_MATCHUPS_PER_CREATURE:
            del creatures_num_games[creature_1_index]
        if creatures_num_games[creature_2_index] >= NUM_MATCHUPS_PER_CREATURE:
            del creatures_num_games[creature_2_index]

        game_number += 1

    while len(games) > 0:
        run_games = []
        for core in range(NUM_CORES):
            if len(games) == 0:
                break
            run_games.append(games.pop(0))
        print("running games " + str(run_games))

        with concurrent.futures.ProcessPoolExecutor() as executor:
            processes = []
            for game in run_games:
                process = executor.submit(simulate_game, generation, game[0], game[1], creatures[game[2]], creatures[game[3]])
                processes.append(process)
            for results in concurrent.futures.as_completed(processes):
                result = results.result()
                creatures[result[0]]["score"] += result[1]
                creatures[result[2]]["score"] += result[3]

    return creatures

def mutate_creature(creature):
    for layer_index in range(len(LAYER_SIZES)):
        for neuron_index in range(LAYER_SIZES[layer_index]):
            if layer_index != len(LAYER_SIZES) - 1:
                for next_neuron_index in range(LAYER_SIZES[layer_index + 1]):
                    creature["weights"][layer_index][neuron_index][next_neuron_index] = round(np.random.normal(loc=creature["weights"][layer_index][neuron_index][next_neuron_index], scale=abs(creature["weights"][layer_index][neuron_index][next_neuron_index] * MUTATION_PERCENT_SD)), NUM_DECIMALS)
    for layer_index in range(len(LAYER_SIZES)):
        for neuron_index in range(LAYER_SIZES[layer_index]):
            if layer_index != 0:
                creature["biases"][layer_index][neuron_index] = round(np.random.normal(loc=creature["biases"][layer_index][neuron_index], scale=abs(creature["biases"][layer_index][neuron_index] * MUTATION_PERCENT_SD)), NUM_DECIMALS)
    return creature

def mutate_creatures(creatures):
    creatures.sort(key=lambda creature: creature["score"], reverse=True)
    new_creatures = []
    i = 0
    creature_index = 0
    for creature in creatures:
        new_creatures_indexes = []
        for _ in range(NUM_MUTATIONS_PER_SURVIVOR):
            new_creature = copy.deepcopy(creature)
            new_creature = mutate_creature(new_creature)
            new_creature["index"] = creature_index
            new_creatures.append(new_creature)
            new_creatures_indexes.append(creature_index)
            creature_index += 1
        new_creatures_indexes = ",".join(str(index) for index in new_creatures_indexes)
        print("new creatures " + new_creatures_indexes + " from creature " + str(creature["index"]) + " score " + str(creature["score"]))
        i += 1
        if i >= NUM_SURVIVORS_PER_GENERATION:
            break
    return new_creatures

def run():
    print("making duplicate cores")
    create_duplicate_cores()

    print("running " + MODEL_FOLDER_NAME)
    generation = get_next_generation()
    print("next generation " + str(generation))
    creatures = []

    if generation == 0:
        print("generating initial creatures")
        creatures = generate_initial_creatures()
        print("simulating creatures")
        creatures = simulate_creatures(generation, creatures)
        print("writing generation " + str(generation))
        write_generation(generation, creatures)
        generation += 1
    else:
        print("reading creatures from previous generation")
        creatures = read_generation_creatures(generation - 1)

    while True:
        print("generation " + str(generation))
        print("mutating new creatures")
        creatures = mutate_creatures(creatures)
        print("simulating creatures")
        creatures = simulate_creatures(generation, creatures)
        print("writing generation " + str(generation))
        write_generation(generation, creatures)
        generation += 1

if __name__ == "__main__":
    run()