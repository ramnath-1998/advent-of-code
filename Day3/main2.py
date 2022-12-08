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
rucksackgroupwisearray = []
grouparray = []
for eachsack in rucksacks:
    grouparray.append(eachsack)
    if len(grouparray) == 3 :
        rucksackgroupwisearray.append(grouparray) 
        grouparray = []
commonarray=[]
for eachgroup in rucksackgroupwisearray:
    common = []
    firstrucksack = eachgroup[0]
    secondrucksack = eachgroup[1]
    thirdrucksack = eachgroup[2]
    for eachchar in firstrucksack:
        if eachchar in secondrucksack and eachchar in thirdrucksack and eachchar not in common:
            common.append(eachchar)
    commonarray.append(common)
totalscore=0
for eachitem in commonarray:
    if len(eachitem) !=0:
        for eachelement in eachitem:
            totalscore = totalscore + alphabetscoremap.get(eachelement)
print(totalscore)