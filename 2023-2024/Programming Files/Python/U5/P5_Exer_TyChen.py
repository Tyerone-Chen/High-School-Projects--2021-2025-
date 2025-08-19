#Tyerone Chen
#10/2/2023

#P5.1
print("P5.1")

#Determines the Smallest Number of a list
#@smallest is the smallest number
#@list is the inputted List
#Returns the smallest num
def smallestNum(list):
    i = 0
    smallest = list[0]
    while i < len(list):
        if numList[i] < smallest:
            smallest = list[i]
            i += 1
        else:
            i += 1
    return smallest

#Determines the average Num in a list
#@List is the input list
#@average is  the average number and the return value
def avgNum(list):
    
    i = 0
    average = 0
    while i < len(list):
        average = average + list[i]
        i += 1
    average = average / len(list)
    return average


#P5.2

def allTheSame(list):
    sameNum = list[0]
    sameAmount = 0
    i = 0
    while i < len(list):
        if list[i] == sameNum:
            sameAmount += 1
            i += 1
        else:
            i += 1
    if sameAmount == 3:
        return ""
    else:
        return "NOT"
            

def allDiff(list):
    diffCheck = True
    i = 0
    while i <len(list) - 1:
        if list[i] == list[i + 1]:
            diffCheck = False
            i += 1
        else:
            diffCheck = True
            i += 1
    if diffCheck == True:
        return ""
    else:
        return "NOT"

def sorted(list):
    sortedCheck = True
    i = 0
    while i < len(list) - 1:
        if list[0] <= list[i + 1]:
            sortedCheck = True
            i += 1
        else:
            sortedCheck = False
            break
    if sortedCheck == True:
        return ""
    else:
        return "NOT"
    
numList = []
for x in range(0,3):
    numList.append(int(input("Enter a Number: ")))


smallOut = smallestNum(numList)
print(f"The Smallest Number is {smallOut}")

avgOut = avgNum(numList)
print(f"The Average of all the Numbers is {avgOut}")
print("\n")

print("P5.2")
sameNum = allTheSame(numList)
print(f"In the List, all of are {sameNum} the Same")

diffNum = allDiff(numList)
print(f"In the List, all of the number are {diffNum} Different")

sortedNum = sorted(numList)
print(f"In the list, all of the numbers are {sortedNum} Sorted")
print("\n")

#P5.3
print("P5.3")

def firstDigit(numberDig):
    firstDig = numberDig[0]
    return firstDig

def lastDigit(numberDig):
    lastDig = numberDig[-1]
    return lastDig

def digitLen(numberDig):
    digLen = len(numberDig)    
    return digLen

inputDigit = (input("Enter a Number: "))

firstDig = firstDigit(inputDigit)
print(f"The First Digit in the Number is {firstDig}")

lastDig = lastDigit(inputDigit)
print(f"The Last Digit in the Number is {lastDig}")

digLength = digitLen(inputDigit)
print(f"There are {digLength} Digits in the number")
print("\n")

#P5.5
print("P5.5")

def repeat(word, amount):
    i = 0
    while i <= amount - 1:
        i += 1
        print(f"{word}, ", end = "")

wordRepeat = input("What Word do You Want to Repeat: ")
amount = int(input("How Many Times: "))

print(repeat(wordRepeat, amount))
print("\n")

#P5.7
print("P5.7")

def wordCount(string): 
    wordLen = len(string.split())
    return wordLen

word = input("Enter a Sentance: ")
wordLen = wordCount(word)

print(f"There are {wordLen} Words in your Sentance")



