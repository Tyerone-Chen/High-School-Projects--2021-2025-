#Tyerone Chen
#10/24/2023
#P9.4

def main():
    myHome = Address(1234, "123th Ave", "Dublin", "Ireland", 54321)
    otherHome = Address(6789, "789th Ave", "London", "England", 67891, 11011)
    print(myHome)
    print()
    print(otherHome)
    print()
    myHome.comesBefore(otherHome)

class Address:
    #START CLASS
    #Constructor
    def __init__(self, houseNum, street, city, 
                 state, postalCode, apartNum = "N/A",):
        self.house = houseNum
        self.street = street
        self.apartment = apartNum
        self.city = city
        self.state = state
        self.postal = postalCode
    
    #MUTATORS
    
    #ACCESORS
    def __str__(self):
        if (self.apartment == 0):
            return f"{self.house} {self.street}\n{self.city}, {self.state} {self.postal}"
        else:
            return f"{self.house} {self.street}, Apartment No. {self.apartment}\n{self.city}, {self.state} {self.postal}"
    def comesBefore(self, other):
        if (self.postal == other.postal):
            print("Both Address are the same value")
        elif(self.postal > other.postal):
            print("Your address is greater than the other address")
        else:
            print("Other address is greater than the other address")
    #END CLASS
    
    
main()