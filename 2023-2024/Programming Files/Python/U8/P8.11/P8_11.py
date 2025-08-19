#Tyerone Chen
#10/18/2023

"FILES USED"
#words.txt

def main():
    wordSet = setMake("words.txt")
    alphaSort(wordSet)


def setMake(fileName):
    #START FUNC
    readFile = open(fileName, "r")
    wordSet = set()
    for line in readFile:
        line = line.split()
        for word in line:
            word = word.lower()
            wordSet.add(word)
    readFile.close()
    return wordSet
    #END FUNC

def alphaSort(setName):
    #START FUNC
    alphaDiction = {"a": [], "b": [], "c": [], "d": [], "e": [], "f": [],
                    "g": [], "h": [], "i": [], "j": [], "k": [], "l": [],
                    "m": [], "n": [], "o": [], "p": [], "q": [], "r": [],
                    "s": [], "t": [], "u": [], "v": [], "w": [], "x": [],
                    "y": [], "z": []}
    for word in setName:
        i = 0
        char = list(word)
        #FIX LATER OK
        while i < 26:
            if chr(97 + i) in char:
                alphaDiction[chr(97 + i)].append(word)
                i += 1
            else:
                i += 1
    print(alphaDiction)
    #END FUNC

main()