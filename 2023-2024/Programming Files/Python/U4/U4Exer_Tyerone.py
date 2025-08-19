# Tyerone Chen
# 9/25/2023

#P4.1.a
print("P4.1.a")
evenOut = 0
i = 0

#Adds up slowly each number from 1-100
while i <= 100:
    evenOut = evenOut + i 
    i +=  2

print(f"The Sum of all Even Number is {evenOut}")
print("\n")

#P4.1.b
print("P4.1.b")

#Adds up slowly each number of 1^2-100^2
i = 0
squaredOutput = 0

while i <= 100:
    squaredOutput = squaredOutput + (i ** 2)
    i += 1

print(f"The sum of all squared Numbers is {squaredOutput}")
print("\n")

#P4.1.c
print("P4.1.c")
twoPowers = 0
i = 0

while i <= 20:
    twoPowers = twoPowers + (2 ** i)
    i += 1

print(f"The Sum of the powers of 2 is {twoPowers}")
print("\n")

#P4.1.d
print("P4.1.d")

lowNum = int(input("Enter the lowesst Number: "))
maxNum = int(input("Enter the Largest Number: "))
oddSum = 0
i = 0
j = 0
oddList = []

#Incrementally checks each value between the two inputs too find a odd num
while i <= maxNum - 1:
    if (lowNum + i) % 2 != 0:
        oddList.append(lowNum + i)
        i += 1
    else:
        i += 1

while j < len(oddList):
    oddSum = oddSum + oddList[j]
    j += 1

print(f"The Sum of all Odd Number between {lowNum} and {maxNum} is {oddSum}")
print("\n")

#P4.1.e
print("P4.1.e")
largeNum = input("Enter a Number: ")
largeNumList = []
i = 0
largeNumOutput = 0

#Puts each individual digit in a list
for num in largeNum:
    largeNumList.append(int(num))

#Reads each digit to see if it is a odd number
while i < len(largeNumList):
    if largeNumList[i] % 2 != 0:
        largeNumOutput = largeNumOutput + largeNumList[i]
        i += 1
    else:
        i += 1

print(f"The Sum of all Odd Numbers in {largeNum} is {largeNumOutput}")
print("\n")

#P4.2.a
print("P4.2.a")
#Prompts the user for how many numbers they want to put in
digitsLen = int(input("How Many Numbers do you want to input: "))
digitsList = []
i = 0

while i < digitsLen:
    digitsList.append(int(input("Enter a Number: ")))
    i +=  1

i = 0
maxNum = digitsList[0]
smallNum = digitsList[0]
while i < digitsLen:
    if digitsList[i] > maxNum:
        maxNum = digitsList[i]
        i += 1
    else:
        i += 1

i = 0
smallNum = digitsList[0]
while i < digitsLen:
    if digitsList[i] < smallNum:
        smallNum = digitsList[i]
        i += 1
    else:
        i += 1
        
print(f"The Largest Number in the group is {maxNum}")
print(f"The Smallest Number in the group is {smallNum}")
print("\n")

#P4.2.b
print("P4.2.b")
evenTotal = 0
oddTotal = 0
i = 0

while i < digitsLen:
    if digitsList[i] % 2 == 0:
        evenTotal += 1
        i += 1
    else:
        oddTotal += 1
        i += 1

print(f"There are {evenTotal} even Numbers")
print(f"There are {oddTotal} odd Numbers")
print("\n")

#P4.2.c
print("P4.2.c")

cumilitive = 0
i = 0

while i < digitsLen:
    cumilitive = cumilitive + digitsList[i]
    print(f"The Current Cumilitive is {cumilitive}")
    i += 1

print("\n")

#P4.2.d
print("P4.2.d")

adjDupes = []

for x in range(len(digitsList) - 1):
  if digitsList[x] == digitsList[x + 1]:
      adjDupes.append(digitsList[x])

print(f"The Adjacent Duplicates are {adjDupes}")
print("\n")

#P4.3.a
print("P4.3.a")

word = input("Enter a Word: ")

upperList = []
i = 0

while i < len(word):
    if word[i].isupper():
        upperList.append(word[i])
        i += 1
    else:
        i += 1

print(f"All of the Capatalized Letters are {upperList}")
print("\n")

#P4.3.b
print("P4.3.b")

i = 0
secondLetter = []

for x in range(len(word) - 1):
    if x % 2 != 0:
        secondLetter.append(word[x])

print(f"Every Second Letter in the word {word} are {secondLetter}")
print("\n")

#P4.3.c
print("P4.3.c")

i = 0
vowels = "aeiouAEIOU"
replacedVowel = "" 

for char in word:
    if char in vowels:
        replacedVowel += "_"
    else:
        replacedVowel += char

print(f"{replacedVowel}")
print("\n")

#P4.3.d
print("P4.3.d")

wordLen = len(word)

print(f"The Number of Digits is {wordLen}")
print("\n")

#P4.3.e
print("P4.3.e")

i = 0
vowelPosition = []

while i < wordLen:
    if replacedVowel[i] == "_":
        vowelPosition.append(i)
        i += 1
    else:
        i += 1

print(f"The Position of All Vowels are {vowelPosition}")
print("\n")

#P4.15
print("P4.15")
foldNum = int(input("Enter how Many Folds you want: "))
outputFold = 0
fold1 = 1
fold2 = 1
i = 0

while i < foldNum:
    outputFold = fold1 + fold2
    fold1 = outputFold
    fold2 = fold1
    i += 1

print(f"The Output for {foldNum} Folds is {outputFold}")
print("\n")

#P4.18
print("P4.18")

for x in range(1, 11):
    for j in range(1, 11):
        print(x * j, end = "\t")
    print()