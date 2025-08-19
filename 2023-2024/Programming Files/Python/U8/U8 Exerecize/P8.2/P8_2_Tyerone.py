#Tyerone Chen
#10/17/2023

#P8.2

"FILES USED"
#words.txt

def main():
    #START FUNC
    wordCounter("words.txt")
    #END FUNC

def wordCounter(fileName):
    #START FUNC
    readFile = open(fileName, "r")
    wordCount = {}
    #Reads off and adds each inque word to a set
    for line in readFile:
        line = line.split() 
        for word in line:
            if word in wordCount:
                wordCount[word] += 1
            else:
                wordCount[word] = 1
    print(wordCount)
    #END FUNC

main()  