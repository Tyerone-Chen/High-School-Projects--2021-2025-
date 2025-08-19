# -*- coding: utf-8 -*-
"""
Problem 1 Set D

The largest single publication in the world is the 1112-volume set of
British Parliamentary Papers for 1968 through 1972. The complete set has
a mass of 3.3 × 10^3 kg. Suppose the entire publication is placed on a cart

that can move without friction. The cart is at rest, and a librarian is sit-
ting on top of it, just having loaded the last volume. The librarian jumps

off the cart with a horizontal velocity relative to the floor of 2.5 m/s to

the right. The cart begins to roll to the left at a speed of 0.05 m/s. Assum-
ing the cart’s mass is negligible, what is the librarian’s mass?
"""

massBook = 3.3 * (10 ** 3)
velocInit = 0
librarVeloc = 2.5
bookVeloc = -0.05

librarMass = (-massBook * bookVeloc) / librarVeloc
print(librarMass)


"""
Problem 7 Set D

In 1994, a pumpkin with a mass of 449 kg was grown in Canada. Sup-
pose you want to push a pumpkin with this mass along a smooth, hori-
zontal ramp. You give the pumpkin a good push, only to find yourself
sliding backwards at a speed of 4.0 m/s. How far will the pumpkin slide
3.0 s after the push? Assume your mass to be 60.0 kg.
"""


massPumpkin = 449
personMass = 60.0
personVeloc = - 4.0
pumpkinVeloc = 0
time = 3.0
pumpkinDistance = 0

pumpkinVeloc = (personMass * personVeloc) / (-1 * massPumpkin)
print(f"The Pumpkin's Velocity is: {pumpkinVeloc} m/s")

pumpkinDistance = round(pumpkinVeloc * time, 2)
print(f"The Pumpkin Moves: {pumpkinDistance} m")



"""
Problem 1 Set E

Zorba, an English mastiff with a mass of 155 kg, jumps forward horizon-
tally at a speed of 6.0 m/s into a boat that is floating at rest. After the
jump, the boat and Zorba move with a velocity of 2.2 m/s forward. Cal-
culate the boat’s mass.
"""


boatMass = 0
zorbaMass = 155 

boatVelocity = 0
zorbaVelocity = 6.0
finalVelocity = 2.2

boatMass = ((zorbaMass * zorbaVelocity) / finalVelocity) - zorbaMass
print(boatMass)



"""
Problem 2 Set E

Yvonne van Gennip of the Netherlands ice skated 10.0 km with an aver-
age speed of 10.8 m/s. Suppose van Gennip crosses the finish line at her

average speed and takes a huge bouquet of flowers handed to her by a
fan. As a result, her speed drops to 10.01 m/s. If van Gennip’s mass is
63.0 kg, what is the mass of the bouquet?
"""

skaterVelocInit = 10.8
skaterVelocFinal = 10.1
skaterMass = 63

flowerVelocInit = 0
flowerMass = 0

flowerMass = ((skaterMass * skaterVelocInit) / skaterVelocFinal) - skaterMass
print(f"The Mass of the Flower is {flowerMass} kg") 


"""
Problem 3 Set E

The world’s largest guitar was built by a group of high school students in
Indiana. Suppose that this guitar is placed on a light cart. The cart and
guitar are then pushed with a velocity of 4.48 m/s to the right. One of the
students tries to slow the cart by stepping on it as it passes by her. The
new velocity of the cart, guitar, and student is 4.00 m/s to the right. If the
student’s mass is 54 kg, what is the mass of the guitar? Assume the mass
of the cart is negligible.
"""

initVeloc = 4.48
finalVeloc = 4

studentMass = 54
gutairMass = 0

gutairMass = ((studentMass * finalVeloc) / (initVeloc - finalVeloc))
print(gutairMass)