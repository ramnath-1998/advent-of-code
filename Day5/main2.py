with open("./Day5/input.txt") as file:
    input_data = file.read().split('\n\n')
row_data = input_data[0].split('\n')
number_of_stacks = len(row_data[len(row_data)-1].strip().split("   "))
def getRowAfterdeletingSpacesBetweenElements(row):
    result = []
    count_of_space = 0
    for each_element in row:
        if each_element != "":
            for i in range(count_of_space//4):
                result.append(" ")
            count_of_space = 0
            result.append(each_element)
        else :
            count_of_space = count_of_space + 1
    for i in range(count_of_space//4):
        result.append(" ")
    return result
stack_dictionary = {}
for i in range(number_of_stacks):
    stack_dictionary[i] = []
for index_of_each_row in range(len(row_data)):
    if index_of_each_row == (len(row_data) -1 ):
        break
    each_row_splited = row_data[index_of_each_row].split(" ")
    actual_row = getRowAfterdeletingSpacesBetweenElements(each_row_splited)
    for i in range (len(actual_row)):
        if actual_row[i] != " ":
            stack_dictionary[i].append(actual_row[i])
moves = input_data[1].split('\n')
for each_move in moves:
    move_array = each_move.split(" ")
    move_array.remove("move")
    move_array.remove("from")
    move_array.remove("to")
    how_many = int(move_array[0])
    from_location = (int(move_array[1]) -1)
    to_location = (int(move_array[2]) -1)
    crane_move = []
    for each in range(how_many):
        removed = stack_dictionary[from_location].pop(0)
        crane_move.append(removed)
    for each in range(len(crane_move)):
        removed = crane_move.pop()
        stack_dictionary[to_location].insert(0,removed)
print("Part Two : ")
for each_element in stack_dictionary:
    print(stack_dictionary[each_element][0])
