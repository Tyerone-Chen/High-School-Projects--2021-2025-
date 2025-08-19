#Tyerone Chen
#10/9/2023

#U7.2

"FILE NAMES"
#mary.txt
#outputMary.txt

#prompts the user for the file names
inputFile = input("Please enter the Input File Name: ") 
outputFile = input("Please enter the Output File Name: ") 
print("\n")

#opens the files

fileRead = open(inputFile, "r")
fileWrite = open(outputFile, "w")

i = 1
for readLine in fileRead:
    readLine = readLine.rstrip("\n")
    print(readLine)
    fileWrite.write(f"/* {i} */ {readLine}\n")
    i += 1

fileRead.close()
fileWrite.close()