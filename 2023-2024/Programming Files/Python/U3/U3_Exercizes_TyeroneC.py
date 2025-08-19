# Tyerone Chen
# 9/18/2023

#P3.1
print("P3.1")
number = int(input("Enter a Number: "))

if (number > 0):
    print("The Number " + str(number) + " Is Positive")
elif(number < 0): 
    print("The Number " + str(number) + " Is Negative")
else:
    print("The Number " + str(number) + " Is Zero")

print("\n")
#P3.3
print("P3.3")

inputNum = int(input("Enter a Number: "))
digits = 0

if (inputNum < 0):
    inputNum = inputNum * -1

while (inputNum > 0):
    digits += 1
    inputNum = inputNum // 10
        
print("There are " + str(digits) + " Digits")

print("\n")
#P3.12
print("P3.12")

#Creates a Parralel List of the Letter Grades, and the corrosponding value
letterGrades = ["A+", "A", "A-", "B+", "B", "B-",
               "C+", "C", "C-", "D+", "D-", "F"]
gradeValues = ["4.3", "4.0", "3.7", "3.3", "3.0", "2.7",
               "2.3", "2.0", "1.7", "1.3", "1.0", "0.7", "0"]
i = 0

letterInput = input("Enter your Letter Grade(Add + or - if applicable): ")

while letterInput != letterGrades[i]:
    i += 1
print("Your Letter Score is: " + letterGrades[i])
print("Your Score is: " + gradeValues[i])

print("\n")
#P3.14
print("P3.14")
i = 0
j = 0
cardNum = ["A", "2", "3", "4", "5", "6", "7",
           "8", "9", "10", "J", "Q", "K"]
cardNumValue =["Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
               "Eight", "Nine", "Ten", "Jack", "Queen", "King"]


mainCard = ["D", "H", "S", "C"]
mainCardValue = ["Diamonds", "Hearts", "Spades", "Clubs"]

inputCard = input("Enter a Card: ")
outputCard = ""
outputNum = ""

while i < len(mainCard) + 1:
    if inputCard[1] == mainCard[i]:
        outputCard = mainCardValue[i]
        break
    else:
        i += 1

while j < len(cardNum) + 1:
    if inputCard[0] == cardNum[j]:
        outputNum = cardNumValue[j]
        break
    else:
        j += 1
    
print(str(outputNum) + " of " + str(outputCard))
print("\n")

#P3.15
print("P3.15")

numList = []
x = 0
m = 0

while (x < 3):
    numList.insert(x, int(input("Enter a Number: ")))
    x += 1

maxNum = numList[0]

while m < len(numList):
    if (numList[m] > maxNum):
        maxNum = numList[m]
        m += 1
    else:
        m += 1

print("The Largest Number is: " + str(round(maxNum, 2)))
print("\n")

#P3.19
print("P3.19")

letter = input("Enter a Character: ")

while ord(letter) < 64:
    letter = input("Enter a Character: ")

#Vowels are A E I O U
if letter == "a" or letter == "A" or letter == "e" or letter == "E" or letter == "i" or letter == "I" or letter == "o" or letter == "O" or letter == "u" or letter == "U":
    print("The Letter " + letter + " is a Vowel")
else:
    print("The Letter " + letter + "is a Consonant")

        


