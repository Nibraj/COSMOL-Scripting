import mph

# Step 1: Initialize COMSOL client
client = mph.start()

# Step 2: Load COMSOL model
model = client.load('SlidingMode_2D.mph')

# Step 3: Define parameter sweep range
'''
parameter_values = [1, 11, 21, 31, 41, 51, 61]  # Define your desired parameter values
'''

parameter_values = [1, 100, 1000, 10000]  # Define your desired parameter values

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
    # Step 4d: Export or collect results
    model.export('Image 1', f'SlidingMode_2D_param{x}mm.png')  # Export images or data
    print("Image created:", x, " m.m")

print("Complete simulation")

'''
- get a range of x1 values as the parameter and export the result output as an image
- write code to do a parametric sweep and save the global evaluation table to an excel spreadsheet
- delete the derived values from the comsol file and see if code still works
'''