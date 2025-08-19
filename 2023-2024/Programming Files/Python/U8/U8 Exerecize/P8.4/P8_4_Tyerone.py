#Tyerone CHen
#10/17/2023

#P8.4

def main():
    numInput  = inputMake()
    primeNum(numInput)
    
def inputMake():
    numInput = input("Where do you want to find all the prime numbers to: ")
    return numInput

def primeNum(numInput):
    #START FUNC
    numTo = int(numInput)
    primeNumbers = set()
    #Checks the multiplier to start at 2
    multiOf = 2
    multiplier = 2
    
    for num in range(numTo):
        num += 1
        primeNumbers.add(num)
    #Discards all of the multipules of 2+ between the numbers 2 - numTo
    while multiOf < numTo:
        while multiplier < numTo:
            primeNumbers.discard(multiOf * multiplier)
            multiplier += 1
        multiOf += 1
    print(primeNumbers)      
    #END FUNC


main()