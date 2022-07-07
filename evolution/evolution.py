import random

# https://stackoverflow.com/a/17548459/3696113
def inplace_change(filename, old_string, new_string):
    # Safely read the input filename using 'with'
    with open(filename) as f:
        s = f.read()
        if old_string not in s:
            print('"{old_string}" not found in {filename}.'.format(**locals()))
            return

    # Safely write the changed content, if found in the file
    with open(filename, 'w') as f:
        print('Changing "{old_string}" to "{new_string}" in {filename}'.format(**locals()))
        s = s.replace(old_string, new_string)
        f.write(s)

LAYER_SIZES = [7, 16, 16, 9]

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

weights = generate_random_weights()
bias = generate_random_biases()
print("weights")
print(str(weights).replace("[", "{").replace("]", "}"))
print("bias")
print(str(bias).replace("[", "{").replace("]", "}"))