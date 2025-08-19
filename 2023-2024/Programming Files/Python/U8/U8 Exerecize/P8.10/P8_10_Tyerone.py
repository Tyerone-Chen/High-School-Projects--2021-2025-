#Tyerone Chen
#10/16/2023

#P8.10

"FILES USED"
#read.txt
#check.txt

def main():
    #START FUNC
    readWords = wordAdd("read.txt")
    checkWords = wordAdd("check.txt")
    setChecker(readWords, checkWords)
    #END FUNC

#Reads off each line in a .txt and adds it to a set that it will return
def wordAdd(file):
    #START FUNC
    readFile = open(file, "r")
    wordSet = set()
    
    for line in readFile:
        line = line.split()
        for word in line:
            wordSet.add(word)
    readFile.close()
    return wordSet
    #END FUNC

#Checks for each word in a set, if theres a similar word, adds it to a list
def setChecker(fileIni, fileComp):
    #START FUNC
    commonWords = []
    
    for word in fileIni:
        if word in fileComp:
            commonWords.append(word)
    print("All common words in both .txt files are:")
    print(commonWords) 
    #END FUNC
    
    
main()
        