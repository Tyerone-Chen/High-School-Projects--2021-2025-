#Tyerone Chen

#Opens File
infile = open("input.txt", "r")
outfile = open("output.txt", "w")


#Do Data stuff here
line1 = infile.readline()
line2 = infile.readline()
print(line1)
print(line2)


count = 100
total = 2
outfile.write("Hello World\n")
outfile.write("Number of entries: %d\nTotal: %8.2f\n" % (count, total))

#Close File
infile.close()
outfile.close()