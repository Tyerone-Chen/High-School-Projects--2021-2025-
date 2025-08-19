#Tyerone Chen
#10/24/2023
#Objects and Classes

def main():
    counterTally = Counter()
    
    counterTally.tick()
    
    value = counterTally.getTotal()
    
    print(value)


class Counter:
    #_ used to identify as private
    
    #Constructor
    def __init__(self): #self is passed in, other parameters can be added in
        self._total = 0
    
    #Function/Methods
    def getTotal(self):
        return self._total
    
    def tick(self):
        self._total += 1
        
    def reset(self):
        self._total = 0

main()