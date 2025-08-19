#Tyerone Chen
#10/10/2023

"FILES USED"
# words.txt

def main():
    #START FUNC
    fileName = fileFind()
    charCount(fileName)
    wordCount(fileName)
    lineCount(fileName)
    #END FUNC
    
    
def fileFind():
    #START FUNC
    inputFile = input("Please Enter your file name(including .txt): ")
    return inputFile
    #END FUNC
    
def charCount(fileName):
    #START FUN
    readFile = open(fileName, "r")
    charList = []
    charCounter = 0
    fileData = readFile.read().replace(" ", "")
    for line in fileData:
        charList = line.strip()
        charCounter += len(charList)
    print(f"There are {charCounter} Characters in the .txt file")
    readFile.close()
    #END FUNC
    
def wordCount(fileName):
    #START FUNC
    readFile = open(fileName, "r")
    wordList = []
    wordCounter = 0
    for line in readFile:
        line = line.split()
        wordList = line
        wordCounter += len(wordList)
    print(f"There are {wordCounter} words in this .txt file")
    readFile.close()
    #END FUNC
    
def lineCount(fileName):
    #START FUNC
    readFile = open(fileName, "r")
    lineCounter = 0
    for line in readFile:
        lineCounter += 1
    print(f"There are {lineCounter} lines in the .txt file")
    readFile.close()
    #END FUNC
    
main()

