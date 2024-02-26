import mph

client = mph.start()
model = client.load('SlidingMode_2D.mph')

x_min = 1
x_max = 70


def range_with_floats(start, stop, step):
    while stop > start:
        yield start
        start += step


model.parameter('x1', str(x_max))
model.build()
print("finish building")
model.solve('Study 1')
print("finish solving")
model.export('Image 2', 'SlidingMode_2D_param_10mm.png')


'''
for x in range_with_floats(x_min, x_max, 10):
    print("Current parameter: ", model.parameters())
    model.parameter('x1', str(x))
    model.build()
    print("finish building")
    model.solve('Study 1')
    print("finish solving")
    print('value of x is ', x)
    model.export('Image 2', f'SlidingMode_2D_param{x}mm.png')
'''

print("Complete simulation")