with open("/home/ramnath/advent-of-code/Day4/input.txt") as file:
    all_pairs = file.read().split('\n')
pairs_with_common_lessons = []
for each_pair in all_pairs:
    if len(each_pair) != 0:
        first_elf = each_pair.split(',')[0]
        second_elf = each_pair.split(',')[1]
        first_lesson_for_first = int(first_elf.split('-')[0])
        last_lesson_for_first = int(first_elf.split('-')[1])
        first_lesson_for_second = int(second_elf.split('-')[0])
        last_lesson_for_second = int(second_elf.split('-')[1])
        range_of_first = range(first_lesson_for_first,last_lesson_for_first+1)
        range_of_second = range(first_lesson_for_second,last_lesson_for_second+1)
        set_of_range_of_first = set(range_of_first)
        set_of_range_of_second = set(range_of_second)
        common_element = set_of_range_of_first.intersection(set_of_range_of_second)
        if len(list(common_element)) != 0 :
            pairs_with_common_lessons.append(each_pair)
print(pairs_with_common_lessons)
print(len(pairs_with_common_lessons))


