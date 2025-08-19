#Tyerone Chen
#10/4/2023


"PLEASE READ OK :P"
#just uncomment in the corrosponding func for each exercize
#theres too many inputs if i did it all at the same time, ie me lazy
import random
import math

#P6.1
def P61():
    print("P6.1")
    i = 0
    numList = []
    while i < 10:
        randNum = random.randint(1, 100)
        numList.append(randNum)
        i += 1
        
    indexEv = evenIndex(numList)
    print(f"The Values on a Even Index are {indexEv}")
    print()

    evens = evenList(numList)
    print(f"All of the Even Values in the List are {evens}")
    print()

    reversal = reverse(numList)
    print(f"The Reversal order of the Values are {reversal}")
    print()

    print(f"The First Value is {numList[-1]}, and the Last Value is {numList[0]}")
    print("\n")

def evenList(list):
    i = 0
    evenVar = []
    
    while i < 10:
        if list[i] % 2 == 0:
            evenVar.append(list[i])
            i += 1
        else:
            i += 1
    return evenVar

def evenIndex(list):
    i = 0
    evenIn = []
    while i < 10:
        evenIn.append(list[i])
        i += 2
    return evenIn

def reverse(list):
    list.reverse()
    return list

"P61()"

#P6.2
def P62():
    print("P6.2")
    inputList = []
    numAdder(inputList)

def numAdder(list):
    #FUNC START
    i = 0
    
    while i < 10:
        #i is kust a counter to 10
        #j is just a counter for the length of the list
        j = 0
        inputNum = input("Enter a unique number: ")
        #Checks to make sure that the input is a num and doesn't break the code lol
        while not inputNum.isdigit():
            print()
            inputNum = input("Enter a unique NUMBER: ")
        while j < len(list):
            #Double check that input isnt already in the list
            if inputNum == list[j]:
                print()
                #makes sure their reinput isnt also a letter
                #If i didnt add this it would allow repeated values lol
                inputNum = input("Enter a UNIQUE NUMBER: ")
                while not inputNum.isdigit():
                    print()
                    inputNum = input("Enter a unique NUMBER: ")
            else:
                j += 1
        list.append(inputNum)
        print("Succesfully Added Number to List")
        print()
        #make sure to add the += 1 so no infinite loops
        i += 1
    print(list)
    #FUNC END 


"P62()"
   
#P6.4
def P64():
    #FUNC START
    print("P6.4")
    numList = listMaker()
    print("Original List for Ref")
    print(numList)
    print()
    valSwap(numList)
    print()
    elemShif(numList)
    print()
    evenZero(numList)
    print()
    increaseNeighbor(numList)
    print()
    removeMid(numList)
    print()
    evenFront(numList)
    print()
    secLarg(numList)
    print() 
    numSequent(numList)
    print()
    adjDupes(numList)
    print()
    anyDupes(numList)
    #FUNC END

def listMaker():
    #FUNC START
    i = 0
    list = []
    listLength = int(input("How Long do you want Your List: "))
    
    while i < listLength:
        inputNum = input("Please enter a number: ")
        while not inputNum.isdigit():
            print()
            inputNum = input("Please enter a NUMBER >:d : ")
        list.append(inputNum)
        print("Succesfully Added Number")
        print()
        i += 1
    return list

    #FUNC END

#P6.4.a
def valSwap(list):
    #FUNC START
    print("P6.4.a")
    listCopy = list.copy()
    
    listCopy[0] = list[-1]
    listCopy[-1] = list[0]
    
    print("Swaped the First and Last Value")
    print(listCopy)
    #FUNC END
 
#P6.4.b
def elemShif(list):
    #START FUNC
    print("P6.4.b")
    i = -1
    shiftedList = []
    while i < len(list) - 1:
        shiftedList.append(list[i])
        i += 1
    print("List Shift up 1")
    print(shiftedList)
    #END FUNC

#P6.4.c
def evenZero(list):
    #START FUNC
    print("P6.4.c")
    i = 0
    zeroList = []
    while i < len(list):
        if int(list[i]) % 2 == 0:
            zeroList.append(0)
            i += 1
        else:
            zeroList.append(list[i])
            i += 1
    print("Replace Even Values with Zero")
    print(zeroList)
    #END FUNC

#P6.4.d
def increaseNeighbor(list):
    #START FUNC
    print("P6.4.d")
    i = 0
    increList = []
    while i < len(list):
        if i == 0 or i == len(list) - 1:
            increList.append(list[i])
            i += 1
        else:
            if int(list[i - 1]) > int(list[i + 1]):
                increList.append(list[i - 1])
            else:
                increList.append(list[i + 1])
            i += 1
    print("Replaces The Value with its highest value neighbor")
    print(increList)
    #END FUNC
    
#P6.4.e
def removeMid(list):
    #START FUNC
    print("P6.4.e")
    midList = list.copy()
    listLength = len(midList)
    #This will be the position of the halfway point
    halfPoint = math.ceil(len(midList) / 2)
    
    if listLength % 2 == 0:
        midList.pop(halfPoint - 1)
        midList.pop(halfPoint - 1)
    else:
        midList.pop(halfPoint - 1)
    
    print("Removed the values at the halfway point")
    print(midList)
    #END FUNC

#P6.4.f
def evenFront(list):
    #START FUNC
    i = 0
    evenList = []
    oddList = []
    
    while i < len(list):
        if int(list[i]) % 2 == 0:
            evenList.append(list[i])
            i += 1 
        else:
            oddList.append(list[i])
            i += 1
    concateList = evenList + oddList
    print("P6.4.f")
    print("List with even elements in the front")
    print(concateList)
    #END FUNC


#P6.4.g
def secLarg(list):
    #START FUNC
    largeList = list.copy()
    i = 0
    largest = largeList[0]
    secondLarge = largeList[0]
    while i < len(largeList):
        if largeList[i] > largest:
            largest = largeList[i]
            i += 1 
        else:
            i += 1
    largeList.remove(largest)
    i = 0
    while i < len(largeList):
        if largeList[i] > secondLarge:
            secondLarge = largeList[i]
            i += 1
        else:
            i += 1 
    print("P6.4.g")
    print(f"The Second Largest Value is {secondLarge}")
    #END FUNC

#P6.4.h
def numSequent(list):
    #START FUNC
    print("P6.4.e")
    i = 0
    sequential = True
    
    while i < len(list) - 1:
        if list[i] <= list[i + 1]:
            sequential = True
            i += 1
        else:
            sequential = False
            break
    
    if sequential == True:
        print("The List is in Sequential Order")
    else:
        print("The List is NOT in Sequential Order")
    #END FUNC

#P6.4.i
def adjDupes(list):
    #START FUNC
    print("P6.4.i")
    i = 0 
    adjacent = False
    
    while i < len(list) - 1:
        if list[i] == list[i + 1]:
            adjacent = True
            break 
        else:
            adjacent = False
            i += 1
    if adjacent == True:
        print("There are Adjacent Duplicates in the List")
    else:
        print("There are NOT Adjacent Duplicates in the List")
    #END FUNC

#P6.4.j
def anyDupes(list):
    #START FUNC
    print("P6.4.j")
    i = 0
    dupes = False
    
    while i < len(list):
        x = 0
        while x < len(list) - 1:
            if list[i] == list[x + 1]:
                dupes = True
                break 
            else:
                x += 1 
        if dupes == True:
            break
        else:
            i += 1
    if dupes == True:
        print("There are Dupes in the List")
    else:
        print("There are NO Dupes in the List")
        
    #END FUNC

P64()

