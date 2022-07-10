import os
import random
import json
import time
import numpy as np
import copy
import shutil

SOURCE_FILENAME = "Troop_pve.java"
COPY_FILENAME = "../src/wtest_evolution_pve/Troop.java"
WEIGHTS_START = "/*weights_start*/"
WEIGHTS_END = "/*weights_end*/"
BIASES_START = "/*biases_start*/"
BIASES_END = "/*biases_end*/"
LAYER_SIZES = [25, 14, 14, 9]
MODEL_FOLDER_NAME = "models/barbarian_duel"
GAMES_FOLDER_NAME = "../games"
PACKAGE_1 = "wtest_evolution_pvp_1"
PACKAGE_2 = "wtest_evolution_pvp_2"
MAPS = ["Duel"]
BUILD_FILENAME = "../build.defaults"
NUM_DECIMALS = 6
NUM_GAMES_PER_MATCHUP = 3
NUM_CREATURES_PER_GENERATION = 100
NUM_SURVIVORS_PER_GENERATION = 20
NUM_MUTATIONS_PER_SURVIVOR = 5
MUTATION_STANDARD_DEVIATION = 0.02

def copy_file(weights_string, biases_string):
    with open(SOURCE_FILENAME, "r") as fin:
        with open(COPY_FILENAME, "w") as fout:
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
                    weight = round(random.uniform(-2, 2), NUM_DECIMALS)
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
                bias = round(random.uniform(-2, 2), NUM_DECIMALS)
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

def randomize_seed():
    with open(BUILD_FILENAME, "r") as fin:
        lines = fin.readlines()
    if bool(random.getrandbits(1)):
        lines[0] = "package1=" + PACKAGE_1 + "\n"
        lines[1] = "package2=" + PACKAGE_2 + "\n"
    else:
        lines[0] = "package1=" + PACKAGE_2 + "\n"
        lines[1] = "package2=" + PACKAGE_1 + "\n"
    lines[2] = "map=" + random.choice(MAPS) + "\n"
    lines[3] = "seed=" + str(random.randint(0, 1000000)) + "\n"
    with open(BUILD_FILENAME, "w") as fout:
        fout.writelines(lines)

def get_game_score(generation, save_if_score_greater):
    files = [f for f in os.listdir(GAMES_FOLDER_NAME) if os.path.isfile(os.path.join(GAMES_FOLDER_NAME, f))]
    for file in files:
        if ".txt" in file:
            with open(f"{GAMES_FOLDER_NAME}/{file}") as f:
                score = 0
                for line in f:
                    if "SCORE" in line:
                        score = int(line.split("[SCORE]")[1])
                if score > save_if_score_greater:
                    shutil.copyfile(f"{GAMES_FOLDER_NAME}/{file}", f"{MODEL_FOLDER_NAME}/random_replay_{generation}.txt")
                return score
    return 0

def simulate_creatures(generation, creatures):
    highest_score = -10000000000
    for creature_index in range(len(creatures)):
        start_time = time.time()
        copy_file("final float[][][] weights = " + array_to_string(creatures[creature_index]["weights"]) + ";", "final float[][] biases = " + array_to_string(creatures[creature_index]["biases"]) + ";")
        total_score = 0
        scores = []
        for game_index in range(NUM_GAMES_PER_MATCHUP):
            randomize_seed()
            stream = os.popen("cd ..; rm -rf games; ant run")
            stream.read()
            score = get_game_score(generation, highest_score)
            total_score += score
            scores.append(score)
            if score > highest_score:
                highest_score = score
        average_score = round(total_score / NUM_GAMES_PER_MATCHUP)
        creatures[creature_index]["score"] = average_score
        end_time = time.time()
        time_elapsed = end_time - start_time
        print("creature " + str(creatures[creature_index]["index"]) + " scores " + str(scores) + " average " + str(average_score) + " (" + str(round(time_elapsed, 2)) + "s)")
    return creatures

def mutate_creature(creature):
    for layer_index in range(len(LAYER_SIZES)):
        for neuron_index in range(LAYER_SIZES[layer_index]):
            if layer_index != len(LAYER_SIZES) - 1:
                for next_neuron_index in range(LAYER_SIZES[layer_index + 1]):
                    creature["weights"][layer_index][neuron_index][next_neuron_index] = round(np.random.normal(loc=creature["weights"][layer_index][neuron_index][next_neuron_index], scale=MUTATION_STANDARD_DEVIATION), NUM_DECIMALS)
    for layer_index in range(len(LAYER_SIZES)):
        for neuron_index in range(LAYER_SIZES[layer_index]):
            if layer_index != 0:
                creature["biases"][layer_index][neuron_index] = round(np.random.normal(loc=creature["biases"][layer_index][neuron_index], scale=MUTATION_STANDARD_DEVIATION), NUM_DECIMALS)
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

run()