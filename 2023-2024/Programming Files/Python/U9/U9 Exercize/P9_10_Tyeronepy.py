# -*- coding: utf-8 -*-
"""
Tyerone Chen

10/25/2023

P9.10
"""

def main():
    voter = VotingMachine()
    voter.clearMachine()
    
    voter.voteRepub()
    voter.voteRepub()
    voter.voteRepub()
    
    voter.voteDemo()
    voter.voteDemo()
    voter.voteDemo()
        
    voter.getTotal()

class VotingMachine():
    #START CLASS
    #Constructor
    def __init__(self):
        self.repubTally = 0
        self.demoTally = 0
    #MUTATORS
    def voteDemo(self):
        self.demoTally += 1
        
    def voteRepub(self):
        self.repubTally += 1
        
    def clearMachine(self):
        self.repubTally = 0
        self.demoTally = 0
    #ACCESORS
    def getTotal(self):
        print(f"Republican Votes: {self.repubTally}")
        print(f"Democrat Votes:   {self.demoTally}")
    #END CLASS
    


main()