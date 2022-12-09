with open("./Day6/input.txt") as file:
    input_data = file.read()
splitted_input_data = [*input_data]
for i in range(13,len(splitted_input_data)):
    first_list = []
    for j in range (13,-1,-1):
        first_list.append(splitted_input_data[i-j])
    second_list = []
    for each_char in first_list:
        if each_char not in second_list:
            second_list.append(each_char)
    if first_list == second_list:
        print(i+1)
        break    


    

            




