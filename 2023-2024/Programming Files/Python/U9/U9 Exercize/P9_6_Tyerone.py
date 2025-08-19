# -*- coding: utf-8 -*-
"""
Tyerone Chen

10/24/2023

P9.6
"""

def main():
    honda = Car(50)
    honda.addGas(1)
    honda.tankCheck()
    honda.drive(55)

class Car:
    #START CLASS
    #CONSTRUCTOR
    def __init__(self, fuelEff):
        self.fuelEff = fuelEff
        self.tank = 0
        self.miles = 0
        
    
    #FUNCS
    def addGas(self, amount):
        print(f"You added {amount} gallons to the tank\n")
        self.tank += amount
    
    def drive(self, distance):
        #Checks if there is any fuel in the tank
        if (self.tank == 0):
            print("The Gas Tank is Currently Empty\n")
        #Checks if the max possible distance is the more than the input
        elif (self.fuelEff * self.tank < distance):
            metDistance = self.fuelEff * self.tank   
            print(f"You drove only {metDistance} Miles out of {distance} Miles")
            print("Your Tank is empty\n")
        else:
            #Calculate fuel lost
            self.tank = self.tank - (distance / self.fuelEff)
            self.miles += distance
            print(f"You drove {distance} Miles")
            print(f"Your Tank has {self.tank} Gallons left\n")
    #ACCESORS
    def tankCheck(self):
        print(f"Your Tank has {self.tank} Gallons in it\n")
    #END CLASS

main()