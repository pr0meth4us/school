while True:
    try:
        numInput = int(input("Enter the number between 1 and 10: "))
        if 1 <= numInput <= 10:
            break
        else:
            print("Invalid number. Please enter a number between 1 and 10.")
    except ValueError:
        print("Invalid input. Please enter a valid integer.")