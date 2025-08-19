# -*- coding: utf-8 -*-
"""
Created on Tue Nov 14 10:49:32 2023

@author: 20132977
"""

from math import sqrt

"""
Problem 1 Set A

Lake Point Tower in Chicago is the tallest apartment building in the
United States (although not the tallest building in which there are
apartments). Suppose you take the elevator from street level to the roof

of the building. The elevator moves almost the entire distance at con-
stant speed, so that it does 1.15 × 105 J of work on you as it lifts the
entire distance. If your mass is 60.0 kg, how tall is the building?
Ignore the effects of friction.
"""
"""
mass = 60
work = 1.15 * (10 ** 5)
gravity = 9.81
height = 0

# w = f * deltaX
# w = m * g * h
# h = w / (m * g)

height = work / (mass * gravity)
height = round(height)
print(height)
"""


"""
Problem 2 Set A

In 1985 in San Antonio, Texas, an entire hotel building was moved several
blocks on 36 dollies. The mass of the building was about 1.45 × 106 kg. If
1.00 × 102 MJ of work was done to overcome the force of resistance that
was just 2.00 percent of the building’s weight, how far was the building
moved?
"""
"""
mass = 1.45 * (10 ** 6)
work = 1 * (10 ** 8)
gravity = 9.81

force = .02  * mass * gravity
deltaX = work/force

deltaX = round(deltaX)
print(deltaX)
"""

"""
Problem 3 Set A

A hummingbird has a mass of about 1.7 g. Suppose a hummingbird
does 0.15 J of work against gravity, so that it ascends straight up with a
net acceleration of 1.2 m/s2

. How far up does it move?
"""
"""
mass = 1.7 / 1000
accel = 1.2 
work= 0.15
gravity = 9.81

appliedForce = (mass * accel) + (mass * gravity)
deltaX = work / appliedForce

deltaX = round(deltaX, 1)
print(deltaX)
"""

"""
Problem 1 Set B

In 1994, Leroy Burrell of the United States set what was then a new world
record for the men’s 100 m run. He ran the 1.00 × 102 m distance in 9.85 s.
Assuming that he ran with a constant speed equal to his average speed, and
his kinetic energy was 3.40 × 103 J, what was Burrell’s mass?
"""
"""
deltaX = 100
time = 9.85
work = 3.40 * (10 ** 3)
veloc = deltaX / time

mass = (2 * work) / (veloc ** 2)
mass = round(mass, 1)
print(mass)
"""

"""
Problem 2 Set B

The fastest helicopter, the Westland Lynx, has a top speed of 4.00 ×
102 km/h. If its kinetic energy at this speed is 2.10 × 107 J, what is the
helicopter’s mass?
"""

"""
veloc = 4 * (10 ** 2)
veloc *= 1000/3600
work = 2.10 * (10 ** 7)
    
mass = (2 * work) / (veloc ** 2)

print(mass)
"""

"""
Problem 5 Set B

In 1995, Karine Dubouchet of France reached a record speed in downhill
skiing. If Dubouchet’s mass was 51.0 kg, her kinetic energy would have
been 9.96 × 104 J. What was her speed?
"""
"""
speed = 0
work = 9.96 * (10 ** 4)
mass = 51

speed = sqrt((2 * work) / mass)
speed = round(speed, 1)
print(speed)
"""

"""
Problem 1 Set C

The tops of the towers of the Golden Gate Bridge, in San Francisco, are
227 m above the water. Suppose a worker drops a 655 g wrench from the
top of a tower. If the average force of air resistance is 2.20 percent of the
force of free fall, what will the kinetic energy of the wrench be when it
hits the water?
"""
"""
deltaX = 227
mass = 0.655
g = 9.81
forceFric = 0.022 * mass * g
forceGravity = mass * g

work = forceFric * deltaX

workNet = forceGravity - forceFric

finalKinetic = workNet
finalKinetic = round(finalKinetic, 2)
print(finalKinetic)
"""

"""
Problem 4 Set C

In 1979, Dr. Hans Liebold of Germany drove a race car 12.6 km with an
average speed of 404 km/h. Suppose Liebold applied the brakes to reduce
his speed. What was the car’s final speed if −3.00 MJ of work was done by
the brakes? Assume the combined mass of the car and driver to be 1.00 ×
103 kg.
"""

deltaX = 12.6 * 1000
innitVeloc = 404 * (1000/3600)
finalVeloc = 0
combinedMass = 1 * (10 ** 3)
work = -3 * (10 ** 6)


finalVeloc = sqrt((innitVeloc ** 2) + ( (2 * work) / combinedMass))
print(finalVeloc)