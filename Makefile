# Makefile for Chess Project

# Unix tools
FIND := find
JAVA := java
RM := rm
RMFLAGS = -rf

# Define compiler and compiler flags
JFLAGS = -g
JC = javac

# Define source and target directories
SRC_DIR = src/java
TARGET_DIR = target/classes

# Define the classpath, including the algs4.jar library
CP = $(TARGET_DIR):lib/algs4.jar

# Define the list of Java source files
CLASSES := $(shell find $(SRC_DIR) -name "*.java")

# Default target to compile all classes
default: classes

# Target to compile .java files to .class files
classes:
	$(JC) $(JFLAGS) -cp $(CP) -d $(TARGET_DIR) $(CLASSES)

# Target to clean compiled .class files
clean:
	$(RM) $(RMFLAGS) $(TARGET_DIR)/*

# Default value for FILENAME
FILENAME ?= Testing

# Target to run a specific file in target/classes
run:
	
	$(JAVA) -cp $(CP) fi.syk.chess.$(FILENAME)
#	(cd $(TARGET_DIR) && $(JAVA) -cp $(CP) $(basename $(shell find . -name "$(FILENAME)")))
#	$(JAVA) -cp $(CP) $(basename $(shell find $(TARGET_DIR) -name "$(FILENAME)"))
