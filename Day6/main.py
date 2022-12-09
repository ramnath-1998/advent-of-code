with open("./Day6/input.txt") as file:
    input_data = file.read()
splitted_input_data = [*input_data]
for i in range(3,len(splitted_input_data)):
    first_char = splitted_input_data[i-3]
    second_char = splitted_input_data[i -2]
    third_char = splitted_input_data[i -1]
    fourth_char = splitted_input_data[i]
    first_list = []
    first_list.append(first_char)
    first_list.append(second_char)
    first_list.append(third_char)
    first_list.append(fourth_char)
    second_list = []
    for each_char in first_list:
        if each_char not in second_list:
            second_list.append(each_char)
    if first_list == second_list:
        print(i+1)
        break

            




