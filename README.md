Documentation
Target assessment level
Target assessment level of this work is 3.

Specification
What does the program do?
The program

reads data about persons from a file
prints all persons in groups with namesakes (same first names) on consecutive lines.
The user supplies the name of the input file either as a program argument or, if none is given, from keyboard.

Data format
The input data text file consists of lines, each line containing

lastname firstname address

Both lastname and firstname are single words, while address is all the remaining text on the line.

Correctness and exception handling
Typical test case
File persons.txt contains data from 6 persons with 3 groups of namesakes. The number of persons in these groups is 3 (Michael), 2 (Jane) and 1. When the program (file Main.java) is run with

java Main.java persons.txt
the output is correct, with each group of namesakes printed on consecutive lines:

Cash Michael Las Vegas, US
Knight Michael Moving truck
Burnham Michael The final frontier
McGyver Agnus Phoenix, Foundation
Doe Jane Aberdeen, Scotland
Tarzan Jane Greystoke, UK
Exception handling (levels 2 and 3)
The following are all the possible exceptions / special cases and the way they are handled.

More than one program argument: only the first one is used as name of data file.
Reading user-supplied data file name fails: exception is caught and printed to user, program exits.
Opening data file for reading fails: exception is caught and printed to user, program exits.
Reading data from data file fails: exception caught and printed, program exits.
Number of persons exceeds program constant: reported to user, program exits.
Resource management (level 3)
The following resources are opened with try-with-resources -statements and are therefore closed automatically when the program no longer needs them, even in the case of an exception.

Scanner for system input when reading user-supplied file name.
Scanner when reading data file.