import mph
import numpy as np
import pandas as pd

# Step 1: Initialize COMSOL client
client = mph.start()

# Step 2: Load COMSOL model
model = client.load('SlidingMode_2D.mph')

# Step 3: Define parameter sweep range
parameter_values = list(range(50, 151, 2))  # Generate values from 50 to 150 with a step of 2

# Step 4: Perform parametric sweep
for x in parameter_values:
    # Step 4a: Set parameter value
    model.parameter('x1', str(x))
    print('value of x is ', x)
    # Step 4b: Rebuild model (if necessary)
    model.build()
    print("finish building")
    # Step 4c: Solve study
    model.solve('Study 1')  
    print("finish solving")
    # Step 4d: Export images for specified values
    if x in [50, 75, 100, 125, 150]:
        model.export('Image 1', f'SlidingMode_2D_param{x}mm.png')  # Export images
        print("Image created:", x, " mm")

print("Complete simulation")

# Step 5: Extract results and save to Excel
simul_result = np.array([])
E = 'es.intWe'
parametric_sweep = 'Study 1//Parametric Solutions 1'

(indices, values) = model.outer('Study 1//Parametric Solutions 1')

for i in range(len(indices)):
    simul_result = np.append(simul_result,model.evaluate(E, 'J', parametric_sweep, 'first', i+1))

data = {
    'x1 [mm]': indices,
    'total electric energy (J)': simul_result
}

df = pd.DataFrame(data)
print('tabulated data retrieved from COMSOL: ', df)

excel_file_path = "output.xlsx"
df.to_excel(excel_file_path, index=False)

print(f"Values exported to {excel_file_path}")

