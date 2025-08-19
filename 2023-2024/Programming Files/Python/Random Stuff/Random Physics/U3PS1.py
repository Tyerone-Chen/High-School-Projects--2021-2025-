# -*- coding: utf-8 -*-
"""
Created on Tue Nov 28 11:47:05 2023

@author: 20132977
"""
from math import sqrt


#PS C

"""
Deimos, a satellite of Mars, has an average radius of 6.3 km. If the gravi-
tational force between Deimos and a 3.0 kg rock at its surface is 2.5 ×

10^–2 N, what is the mass of Deimos?
"""

"""
#1
forceG = 2.5 * (10 ** -2)
diameter = 6.3 #km
diameter = 6.3 * 1000
bigG = 6.67 * (10 ** -11)
massRock = 3
massDeimos = 0

massDeimos = (forceG * (diameter ** 2)) / (bigG * massRock)

print(massDeimos)
"""

"""
#2
A 3.08 × 10^4 kg meteorite is on exhibit in New York City. Suppose this

meteorite and another meteorite are separated by 1.27 × 107 m (a dis-
tance equal to Earth’s average diameter). If the gravitational force be-
tween them is 2.88 × 10−16 N, what is the mass of the second meteorite?
""" 
"""
bigG = 6.67 * (10 ** -11)
massMeteor1 = 3.08 * (10 ** 4)
massMeteor2 = 0
distance = 1.27 * (10 ** 7)
forceG = 2.88 * (10 ** -16)

massMeteor2 = (forceG * (distance ** 2)) / (bigG * massMeteor1)
print(massMeteor2)
"""

"""
#4
The largest diamond ever found has a mass of 621 g. If the force of
gravitational attraction between this diamond and a person with a
mass of 65.0 kg is 1.0 × 10–12 N, what is the distance between them?
"""
"""
bigG = 6.67 * (10 ** -11)
massDiamond = 621 / 1000
massPerson = 65
forceG = 1.0 * (10 ** -12)
distance = 0

distance = sqrt((bigG * massDiamond * massPerson) / forceG)
print(distance)
"""

"""
#5
The passenger liners Carnival Destiny and Grand Princess, built re-
cently, have a mass of about 1.0 × 108 kg each. How far apart must

these two ships be to exert a gravitational attraction of 1.0 × 10−3 N on
each other?
"""
"""
bigG = 6.67 * (10 ** -11)
forceG = 1.0 * (10 ** -3)
massLiners = 1.0 * (10 ** 8)
distance = 0

distance = sqrt((bigG * massLiners * massLiners) / forceG)
print(distance)
"""