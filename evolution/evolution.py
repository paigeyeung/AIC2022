# import re
import random

SOURCE_FILENAME = "Troop.java"
COPY_FILENAME = "../src/wtest_evolution/Troop.java"
WEIGHTS_START = "/*weights_start*/"
WEIGHTS_END = "/*weights_end*/"
BIASES_START = "/*biases_start*/"
BIASES_END = "/*biases_end*/"
LAYER_SIZES = [7, 16, 16, 9]

# https://stackoverflow.com/a/17548459/3696113
# https://stackoverflow.com/a/24558626/3696113
def copy_file(weights_string, biases_string):
    with open(SOURCE_FILENAME, "rt") as fin:
        with open(COPY_FILENAME, "wt") as fout:
            for line in fin:
                if WEIGHTS_START in line and WEIGHTS_END in line:
                    fout.write(WEIGHTS_START + weights_string + WEIGHTS_END + "\n")
                elif BIASES_START in line and BIASES_END in line:
                    fout.write(BIASES_START + biases_string + BIASES_END + "\n")
                else:
                    fout.write(line)

def generate_random_weights():
    weights = []
    for layer_index in range(len(LAYER_SIZES)):
        layer = []
        for neuron_index in range(LAYER_SIZES[layer_index]):
            next_layer = []
            if layer_index != len(LAYER_SIZES) - 1:
                for next_neuron_index in range(LAYER_SIZES[layer_index + 1]):
                    weight = random.uniform(-2, 2)
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
                bias = random.uniform(-2, 2)
            layer.append(bias)
        biases.append(layer)
    return biases

def array_to_string(array):
    return str(array).replace("[", "{").replace("]", "}")

print("making troop copy")
weights = generate_random_weights()
biases = generate_random_biases()
copy_file("double[][][] weights = " + array_to_string(weights) + ";", "double[][] biases = " + array_to_string(biases) + ";")