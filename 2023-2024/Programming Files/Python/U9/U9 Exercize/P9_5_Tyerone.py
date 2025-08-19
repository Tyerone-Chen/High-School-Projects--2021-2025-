# -*- coding: utf-8 -*-
"""
Tyerone Chen

10/24/2023

P9.5
"""

def main():
    can = SodaCan(25, 10)
    surfaceArea = can.getSA()
    print(f"Surface Area: {surfaceArea}π")
    volume = can.getVol()
    print(f"Volume: {volume}π")

class SodaCan:
    #START CLASS
    #Constructor
    def __init__(self, height, radius):
        self.height = height
        self.radius = radius
    
    #FUNCS
    def getSA(self):
        result = (2 *(self.radius ** 2)) + (2 * (self.radius * self.height))
        return result
        
    def getVol(self):
        result = ((self.radius ** 2) * self.height)
        return result
    #END CLASS

main()