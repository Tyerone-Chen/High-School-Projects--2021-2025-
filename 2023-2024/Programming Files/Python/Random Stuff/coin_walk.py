#Tyerone Chen
#Coin Flip Walk
import random

maxFlips = int(input("How Many Coin Flips Do You Want: ")) 

headsMove = int(input("What is the Movement for Heads: "))
tailsMove = int(input("What is the Movement for Tails: "))

rand = 0
headsCount = 0
tailsCount = 0
movement = 0
i = 0

# 0 = Heads, 1 = Tails
# Based on if its a Heads or Tails, the movement is added to a variable to
# display the displacement
while (i < maxFlips):
    rand = random.randint(0, 1)
    if (rand == 0):
        headsCount += 1
        movement = movement + headsMove
        i += 1
    else:
        tailsCount += 1
        movement = movement + tailsMove
        i += 1

print("Displacement: " + str(movement))
print("Flipped Heads: " + str(headsCount) + " Times")
print("FLipped Tails: " + str(tailsCount) + " Times")
        
        
        
    