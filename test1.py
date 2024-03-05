import mph
import numpy as np
import pandas as pd

client = mph.start()
model = client.load('SlidingMode_2D.mph')

x_min = 1
x_max = 70
simul_result = np.array([])
E = 'es.intWe'
parametric_sweep = 'Study 1//Parametric Solutions 1'

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

(indices, values) = model.outer('Study 1//Parametric Solutions 1')

for i in range (len(indices)):
    simul_result = np.append(simul_result,model.evaluate(E, 'J', parametric_sweep, 'first', i+1))

print(simul_result)

data = {
    'x1 [mm]': indices,
    'total electric energy (J)': simul_result
}

df = pd.DataFrame(data)
print('tabulated data retrieved from COMSOL: ', df)

excel_file_path = "output.xlsx"
df.to_excel(excel_file_path, index=False)

print(f"Values exported to {excel_file_path}")


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