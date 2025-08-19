#Tyerone Chen
#10/9/2023

"FILES USED"
#numbers.txt

#P7.4

def main():
   fileName = fileFind()
   numList = numSort(fileName, 1)
   average(numList)
   numList = numSort(fileName, 2)
   average(numList)

    
def fileFind():
    #START FUNC
    inputFile = input("What is the name of your file: ")
    return inputFile
    #END FUNC

def numSort(file, column):
    #START FUNC
    readFile = open(file, "r")
    numList = []
    
    for line in readFile:
        #Removes the \n, and then adds each value into a 2d list
        line = line.strip("\n")
        line = line.rsplit(",")
        numList.append(line[column - 1])
        
    return numList
    readFile.close()
    #END FUNC

def average(numList):
    #START FUNC
    average = 0
    for i in numList:
        average = average + float(i)
    average = average / len(numList)
    average = round(average, 1)
    print(f"The Average of the Column is {average}")
    #END FUNC

main()