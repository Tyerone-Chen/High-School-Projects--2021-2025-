#Tyerone Chen
#9/29/2023

import random
import math

"To Do List"
#Create Character Stat Creator
"Done"
#Create Special Stat sonverter that determines stuff like health
#Create Level Up System
"WHen doing level up ask what skills to add points, then show the skill pts list"
"And ask if this is correct, if not restart lol"
#Skill pts added should be 10pts plus int/2, round up or down idk

#After doing the stats converter, such as hp and phys atk make battle menu and stuff
"mostly done, edits to print format and determining stats need to be done"
#When doing battle stuff create a tep list, battleStats, so stats can be modified during battle
#Then create inputs for each actions
#Create a Test Dummy and make a test battle 
#For the test dummy create the stats and the the battle ai for 
#four different dummy sets
"Unfinished"

#After this start to create each unique enemy and their ai
"Def not done"

#Then create each unique floor and their gimmick
"no"


def main():
    charCreate()

     
#clear console command

#Create Character Stat Variables
def charCreate():
    specList = specialCreate()
    print(specList)
    skillList = skillDeter(specList)
    print("\n")
    skillPrint(skillList)
    print("\n")
    skillList = tagSkills(skillList)
    print("\n")
    statsList = statsConvert(specList, skillList, 1)
    statsPrint(statsList)
    charInfo(specList, skillList, statsList)
    

#When leveling up, allow the user to boost one of their currents stats
#by a randint from 1 - 5? do later :D
#Stats should also effect out of combat scenarios
#Initial Stats should be determined by chosen stats the user chooses
#Like fallout it starts from a scale of 1-10, might use the special format
# In fnv you get 40 total special points at start
#Affects certain attacks as well as out of combat situations

"Short list of what spec affects"
#Strength - PHYS ATK, ITEM SPACE?, CHARGE TIME FOR CERTAIN WEAPONS, CRIT MULTI
#Perception - RANGE ATK, HIT RATE, DETECTION OF ENEMIES
#Endurance - ENV RESIS, HP, HEAL CONSERV,
#Charisma - COMPANION AMOUNT, SPEECH AND STUFF
#Intellegence - MAGIC ATK, EXP GAIN, USING BETTER MOVES
#Agiity - TURN ORDER, EVASIVENESS, ATTACK TIMES
#Luck - CRIT CHANCE

"List of Skills"
"Base skill stat is spec * 2"\
#Skills are out of a 100 pts
#MELEE - STR
#UNARMED - STR
#RANGED - PER
#SURVIVAL - END
#SPEECH - CHAR
#MAGIC - INTEL
#ALCHEMY - INTEL
#SNEAK - AGIL
"LUCK is seperate as it helps determine good or bad luck scenarios"
"It is a out of 50 idk"
#LUCK

#TAGGING A SKILL ADDS AN EXTRA 15 pts
#You can Tag 3 skills, which will boost the base skill pts by 15

def skillDeter(specList):
    #START FUNC
    skillNames = ["Melee", "Unarmed", "Ranged", "Survival", "Speech", "Magic", 
                  "Alchemy", "Sneak" ,"Luck"]
    skillValues = [0, 0, 0, 0, 0, 0, 0, 0, 0,]
    
    skillValues[0] = specList[0] * 2 
    skillValues[1] = specList[0] * 2 
    skillValues[2] = specList[1] * 2 
    skillValues[3] = specList[2] * 2 
    skillValues[4] = specList[3] * 2 
    skillValues[5] = specList[4] * 2 
    skillValues[6] = specList[4] * 2 
    skillValues[7] = specList[5] * 2 
    skillValues[8] = specList[6] * 2 
    return skillValues
    #END FUNC

#Might remove unarmed since its a pain to determine accuracy
def skillPrint(skillList):
    #START FUNC
    print("Current SKILL Point Allocation:")
    print('-' * 20)
    print(f"[1]Melee:    {skillList[0]}/100")
    print(f"[2]Unarmed:  {skillList[1]}/100")
    print(f"[3]Ranged:   {skillList[2]}/100")
    print(f"[4]Survival: {skillList[3]}/100")
    print(f"[5]Speech:   {skillList[4]}/100")
    print(f"[6]Magic:    {skillList[5]}/100")
    print(f"[7]Alchemy:  {skillList[6]}/100")
    print(f"[8]Sneak:    {skillList[7]}/100")
    print('-' * 20)
    #END FUNC

def tagSkills(skillList):
    #START FUNC
    skills = skillList.copy()
    i = 0
    tagLeft = 3
    print()
    while i < 3:
        skillPrint(skills)
        print(f"You have {tagLeft} Skills you can Tag")
        tagChoice = input("Which Skill do you want to Tag(Select by entering its number): ")
        while not tagChoice.isdigit():
            print("\n")
            print("Please Select a Number from 1-8")
            tagChoice = input("Which Skill do you want to Tag(Select by entering its number): ")
        #FIX THIS
        #Supposed to prevent users from tagging the same skill
        tagChoice = int(tagChoice)
        if tagChoice < 9 and tagChoice > 0:
            skills[tagChoice - 1] = skills[tagChoice - 1] + 15
            i += 1
            tagLeft = tagLeft - 1
        else:
            print("\n")
    skillPrint(skills)
    return skills
    #END FUNC


#Stats are determined by special stats and skill stats
#Max HP - Is 25 + (End * 2)
#Phys Def - 5 + Armor Stats
#Mag Def - 5 + Armor Stats
#Phys Atk - Str + WepDmg(Wep Skill/Req Skill)
#Mag Atk - Int + WepDmg(Magic Skill/Req Skill)
#Resistances Stat - Survival ???
#Speed - 5 + (Agi/2 round down)
#Evasiveness - Depends of enemy hit rate but also with agil and sneak
#Accuracy - Depends on wep, but is a percent out of 100, with perception helping increase the chances
#Crit Rate - Luck lol

def statsConvert(specList, skillList, userLevel):
    #START FUNC
    statsList = [
        ["HP", (25 + (specList[2]/2))],
        ["Physical Defense", 5],
        ["Magic Defense", 5],
        ["Physical Attack", skillList[0]],
        ["Magic Attack", skillList[6]],
        ["Resistance", (3/4) * skillList[3]],
        ["Speed", 5 + (specList[5] / 2)],
        ["Evasive", 5],
        ["Phys Accuracy", skillList[0]],
        ["Magic Accuracy", skillList[6]],
        ["Crit Rate", skillList[8]]
        ]
    
    return statsList
    #END FUNC

def statsPrint(statsList):
    #START FUNC
    i = 0 
    while i < len(statsList):
          print(f"{statsList[i][0]}:", end = " ")
          print(f"{statsList[i][1]}")
          i += 1
    #END FUNC


#Physical Attack List, light, medium, heavy, charged. multihit
#This is a calculation before var such as enemyDef and luck

def physicalAttack(attackType, level, strength):
    #START FUNC
    returnAttack = 0
    hitAmount = 1
    if attackType == "light":
        returnAttack = (strength * level) * 0.75
        return returnAttack
        return hitAmount
    elif attackType == "medium":
        returnAttack = (strength * level) * 1.25
        return returnAttack
        return hitAmount
    elif attackType == "heavy":
        returnAttack = (strength * level) * 1.75
        return returnAttack
        return hitAmount
    elif attackType == "charge":
        returnAttack = (strength * level) * 2.25
        return returnAttack
        return hitAmount
    elif attackType == "multhit":
        hitAmount = random.randint(1,5)
        returnAttack = ((strength * level) * 0.5) * hitAmount
        return returnAttack
        return hitAmount
    else:
        return returnAttack
    #END FUNC
    

#Turn determiner comparing the spd of the character and enemy
def turnDeterminer(charSpd, enemySpd, luck):
    #START FUNC
    print("spd")
    #END FUNC
  
#Asks for the input for each special point
#Uses a parallel list for storing each point allocation
#The func should return the parallel list of all the stat num

#Ill have to put the function within a list to ensure its is safe then asign individual
#vars the corresponding value
def specialCreate():
    #START FUNC
    i = 0
    pointLeft = 40
    speciList = ["Strength", "Perception", "Endurance", "Charisma",
                 "Intellegenece", "Agility", "Luck"]
    pointPlace = []
    
    while i < 7:
        print(f"Current Points Left: {pointLeft}")
        pointInput = input(f"How Many Points to put in {speciList[i]}(1 - 10): ")
        #While the input is not a digit, itll reprompt the user
        while not pointInput.isdigit():
            print("\n")
            print("Enter a NUMBER between 1-10")
            print(f"Current Points Left: {pointLeft}")
            pointInput = input(f"How Many Points to put in {speciList[i]}(1 - 10): ")
        #Asks that the input is <= 10, > 0
        #And that the input is less than the pointsLeft - stats left
        #Example, if points left is 10 and we're on charisma, the point use has to be 5 or less
        pointInput = int(pointInput)
        if pointInput <= 10 and pointInput > 0 and pointInput <= pointLeft - (6 - i):
            print("\n")
            pointPlace.append(int(pointInput))
            i += 1
            pointLeft = pointLeft - pointInput
        #Asks again if the input doesn't meet the if requirements
        else:
            print("\n")
            
    printSpec(pointPlace)
    
    #If there are any points left, it will ask if they want to put in any extra points
    #If the stat has 10 points in it, itll skip over it
    #If the input makes the stat go over 10, itll reask for the input
    if pointLeft > 0:
        while pointLeft > 0:
            i = 0
            addedAmount = 0
            print(f"You Have {pointLeft} Point/s Left")
            answer = input("Would you like to add any extra points to a stat?(y/n): ") 
            print("\n")
            if answer == "y" or answer == "Y":
                while i < 7:
                    if pointLeft > 0 and pointPlace[i] < 10:
                        print(f"{pointLeft} Extra Points")
                        addedAmount = input(f"How many points to put in {speciList[i]}: ")
                        #While the input is not a digit, itll reprompt the user
                        while not addedAmount.isdigit():
                            print("\n")
                            print(f"{pointLeft} Extra Points")
                            print("Enter a NUMBER between 1-10")
                            addedAmount = input(f"How many points to put in {speciList[i]}: ")
                        addedAmount = int(addedAmount)
                        if pointPlace[i] + addedAmount <= 10:
                            print("\n")
                            pointPlace[i] = int(pointPlace[i]) + addedAmount
                            pointLeft = pointLeft - addedAmount
                            i += 1
                        else:
                            #repromt until it gets a num that doesnt add over 10
                            print(f"{pointLeft} Extra Points")
                            addedAmount = int(input(f"How many points to put in {speciList[i]}: "))
                            print("\n")
                    else:
                        i += 1
                        
        printSpec(pointPlace)
        return pointPlace
    else:
        return pointPlace
    #END OF FUNC

def printSpec(specList):
    #FUNC Start
    print("Current SPECIAL Point Allocation:")
    print('-' * 20)
    print(f"[1]Strength:      {specList[0]}/10")
    print(f"[2]Perception:    {specList[1]}/10")
    print(f"[3]Endurance:     {specList[2]}/10")
    print(f"[4]Charisma:      {specList[3]}/10")
    print(f"[5]Intellegence:  {specList[4]}/10")
    print(f"[6]Agility:       {specList[5]}/10")
    print(f"[7]Luck:          {specList[6]}/10")
    print('-' * 20)
    #FUNC END

def charInfo(specList, skillList, statList):
    #START FUNC
    #line one should be the user special values
    #line two should be the user skill values
    #line three should be the user stat values
    charInfos = [
        [],
        [],
        []
        ]
    i = 0
    for x in specList:
        charInfos[0].append(x)
    for x in skillList:
        charInfos[1].append(x)
    while i < len(statList):
        charInfos[2].append(statList[i][1])
        i += 1
    print(charInfos)
    return charInfos
    #END FUNC
   
#start off with creating a temporary stat list to be affected during battle
#prompt the user with a list of options to do
#Phys Attack, Magic Attack, Items, Check user stats, defend, or 
#Each option should lead to a sub menu of what to de specifically 
#and their stat cost etc.
"red below pls"
#Should create seperate function for each of thesh nvje sub menus
def battleStart(charInfo, enemyInfo):
    #START FUNC
    print("You have Initialized a Battle!")
    battleStats = charInfo[2]
    
    #END FUNC
    
#Test Dummy
#Stats should be able to be customized
#It should not attack or do any action
#It should be able to avoid or defend attacks if it is set up to do so
#Make three test dummys, one just something that attacks
#One that constantly tries to avoid attacks
#One that does a constant amout of phys or magic damage
#Finally one that constantly defends

def dummySpecial():
    #START FUNC
    dummySpec = [
        ["Strength", 5],
        [ "Perception", 5],
        ["Endurance", 5],
        ["Charisma", 5],
        ["Intellegence", 5],
        ["Agility", 5],
        ["Luck", 5]
        ]
    return dummySpec
    #END FUNC

def dummyStats(specList):
    #START FUNC
    print()
    #END FUNC

main()



    