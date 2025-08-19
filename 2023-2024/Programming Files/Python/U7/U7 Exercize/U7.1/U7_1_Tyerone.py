#Tyerone Chen
#10/9/2023

#open da file
inputFile = open("hello.txt", "w") 
inputFile.write("Hello World!\n")

inputFile.close()

inputFile = open("hello.txt", "r")

#Reopens and then reads the line in .txt
inputLine = inputFile.readline()
print(inputLine)

inputFile.close()

