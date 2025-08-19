# -*- coding: utf-8 -*-
"""
Created on Thu Nov  9 11:03:42 2023

@author: 20132977
"""

"""
Problem 1 Set B

In 1991, a Swedish company, Kalmar LMV, constructed a forklift truck
capable of raising 9.0 × 10^4 kg to a height of about 2 m. Suppose a mass

this size is lifted with an upward velocity of 12 cm/s. The mass is ini-
tially at rest and reaches its upward speed because of a net force of 6.0 ×

103 N exerted upward. For how long is this force applied?
"""
"""
mass = 9 * (10 ** 4)
initVeloc = 0
finalVeloc = 0.12
force = 6 * (10 ** 3)

time = mass * (finalVeloc - initVeloc) / force

print(time)
"""

"""
Problem 2 Set B

A bronze statue of Buddha was completed in Tokyo in 1993. The statue
is 35 m tall and has a mass of 1.00 × 106 kg. Suppose this statue were to
be moved to a different location. What is the magnitude of the impulse
that must act on the statue in order for the speed to increase from 0 m/s
to 0.20 m/s? If the magnitude of the net force acting on the statue is
12.5 kN, how long will it take for the final speed to be reached?
"""

"""
mass = 1 * (10 ** 6)
initVeloc = 0
finalVeloc = 0.20
force = 12.5 * (10 ** 3)

time = mass * (finalVeloc - initVeloc) / force
impulse = mass * (finalVeloc - initVeloc)

print(time)
print(impulse)
"""

"""
Problem 4 Set B

The specially designed armored car that was built for Leonid Brezhnev
when he was head of the Soviet Union had a mass of about 6.0 × 103 kg.
Suppose this car is accelerated from rest by a force of 8.0 kN to the east.
What is the car’s velocity after 8.0 s?
"""

"""
mass = 6 * (10 ** 3)
force = 8 * (10 ** 3)
time = 8

velocity = (force * time) / mass

print(velocity)
"""


"""
Problem 9 Set B

Certain earthworms living in South Africa have lengths as great as 6.0 m
and masses as great as 12.0 kg. Suppose an eagle picks up an earthworm
of this size, only to drop it after both have reached a height of 40.0 m

above the ground. By skillfully using its muscles, the earthworm man-
ages to extend the time during which it collides with the ground to

0.250 s. What is the net force that acts on the earthworm during its col-
lision with the ground? Assume the earthworm’s vertical speed when it

is initially dropped to be 0 m/s.
"""

"""
from math import sqrt

initVelocity = 0
wormMass = 12 * (10 ** 3)
time = 0.25
distance = 40

gravity = 9.81

finalVelocity = sqrt((initVelocity ** 2) + (2 * gravity * distance))
print(finalVelocity)

initVelocity = finalVelocity
finalVelocity = 0

force = wormMass * (finalVelocity - initVelocity) / time
print(force)
"""


"""
Problem 1 Set C

The most powerful tugboats in the world are built in Finland. These
boats exert a force with a magnitude of 2.85 × 106 N. Suppose one of
these tugboats is trying to slow a huge barge that has a mass of 2.0 ×
107 kg and is moving with a speed of 3.0 m/s. If the tugboat exerts its
maximum force for 21 s in the direction opposite to that in which the
barge is moving, what will be the change in the barge’s momentum? How
far will the barge travel before it is brought to a stop?
"""

"""
force = -2.85 * (10 ** 6)
mass = 2.0 * (10 ** 7)
initVelocity = 3
finalVelocity = 0
time = 21


changeP = force * time

print(changeP)

changeX = (1/2) * (initVelocity - finalVelocity) * time

print(changeX)
"""

"""
Problem 2 Set C

In 1920, a 6.5 × 104 kg meteorite was found in Africa. Suppose a me-
teorite with this mass enters Earth’s atmosphere with a speed of 1.0 km/s.

What is the change in the meteorite’s momentum if an average constant
force of –1.7 × 106 N acts on the meteorite for 30.0 s? How far does the
meteorite travel during this time?
"""

"""
mass = 6.5 * (10 ** 4)
force = 1.7 * (10 ** 6)
time = 30
initVeloc = 1 * (10 ** 3)

finalVeloc = ((force * time) / mass) + initVeloc
print(finalVeloc)

changeP = force * time
print(changeP)

changeX = (1/2) * (initVeloc - finalVeloc) * time
print(changeX)
"""

"""
Problem 3 Set C

The longest canoe in the world was constructed in New Zealand. The
combined mass of the canoe and its crew of more than 70 people was
2.03 × 104 kg. Suppose the canoe is rowed from rest to a velocity of
5.00 m/s to the east, at which point the crew takes a break for 20.3 s. If a
constant average retarding force of 1.20 × 103 N to the west acts on the
canoe, what is the change in the momentum of the canoe and crew? How
far does the canoe travel during the time the crew is not rowing?
"""

initVelocity = 5
mass = 2.03 * (10 ** 4)
changeTime = 20.3
force = 1.2 * (10 ** 3)

changeP = force * changeTime
print(changeP)

finalVelocity = ((-1 * changeP) + (initVelocity * mass)) / mass
print(finalVelocity)

changeX = (1/2) * (initVelocity + finalVelocity) * changeTime
print(round(changeX))