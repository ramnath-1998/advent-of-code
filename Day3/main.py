with open("/home/ramnath/advent-of-code/Day3/input.txt") as file:
    rucksacks = file.read().split('\n')

commonarray = []
alphabetarray = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
alphabetvalue = 1
alphabetscoremap = {}
for eachalphabet in alphabetarray:
    alphabetscoremap[eachalphabet] = alphabetvalue
    alphabetscoremap[eachalphabet.capitalize()]= alphabetvalue + 26
    alphabetvalue = alphabetvalue + 1
for eachrucksack in rucksacks:
    common = []
    firstcomponent = eachrucksack[:len(eachrucksack)//2]
    secondcomponent = eachrucksack[len(eachrucksack)//2:]
    for eachchar in firstcomponent :
        if eachchar in secondcomponent and eachchar not in common:
            common.append(eachchar)
    commonarray.append(common)

totalscore = 0
for eachelement in commonarray :
    if len(eachelement) != 0:
        totalscore = totalscore + alphabetscoremap.get(eachelement[0])
print(totalscore)
