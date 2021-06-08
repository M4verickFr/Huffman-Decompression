# huffman-decode

 [![forthebadge](https://forthebadge.com/images/badges/built-by-developers.svg)](https://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)

This project is to produce a java program to decode a text that has been coded by the Huffman Algortitmn.
It using a frequency files to decode a binary file and write text result in new file.

I have decided to use the Google Java Style Guide to write a beautiful code and respect best practices when I write code.

To develop this project, I have decided to use [IntelliJ IDEA](https://www.jetbrains.com/idea/).

# Test-driven development
To realize this project, I decided to use the TDD (Test-driver development) method. It consists in designing a software by writing each test before writing the source code and by refactoring the code continuously.

## Milestones
1. Learn about the **Huffman Algorithm**
2. Think about **structure**
3. Think about **unit-tests**
3. Define **structure** and **unit-tests**
4. Read frequencies file
5. Generate Huffman Tree (based on frequencies of each character)
6. Read binary file
5. Decode binary
8. Write decoded text in a file 

## Installation

Clone the repo:

```sh
git clone git@github.com:M4verickFr/huffman-decode.git
```

## Usage with command line

Move to executable and execute it.

```sh
cd out/artifacts/HuffmanDecode/
java -jar huffman-decode.jar <freq_file> <comp_file>
```

## Unit-tests

I wrote about twenty tests before coding my project to check the functioning of my project, these are located in the folder src/test/java/. Configuration files for intellijIdea are present on the github to be able to execute them easily.

All tests must be passed

## Project structure

For the structure of my project, I decided to respect the Maven Directory Layout

```sh
src
├── main
│   └── java
│       └── Main.java
└── test
    └── java
        └── MainTest.java
```
![UML Diagram](https://media.discordapp.net/attachments/846636477479780352/851816365379420190/unknown.png)


## How it works ?

The program retrieves the frequencies dictionnary.

```bin
6
b 1
n 1
j 1
u 1
r 1
o 2
```

The program generates the Huffman tree

![image](https://media.discordapp.net/attachments/846636477479780352/851794692802084874/unknown.png)

The program retrieves the binary string.

```bin
010111000111100101
```

The program writes the result in file and display it

```java
010111000111100101 -> bonjour
```

# Organisation

To organize my work, I have created a [Trello](https://trello.com/invite/b/5b2RxAt2/6dda1a1e5ca6df7e4ce8cc09877299b8/proj631-huffman-decode) that shows the different work sessions and the state of the tasks of the project.

![image](https://cdn.discordapp.com/attachments/846636477479780352/851827262579540028/trello-board-invite-qr-code.png)

## What difficulties I have encountered?

During the realisation of my project, I didn't have many difficulties.

The first difficulty I encountered was that when I generated the Huffman tree, I generate the wrong Huffman tree because I didn't alphabetically sort when nodes are same weight.

And the second difficulty comes when I wanted to create executable file (jar) because I didn't make it before, and the I encountered multiple problem with the manifest. After some research on Google, I found the solutions.

# UML Diagram
![UML Diagram](https://github.com/M4verickFr/huffman-decode/blob/main/out/diagram/HuffmanDecode.png?raw=true)

## License

This project is under the Apache 2.0 License.

**Free Software, Hell Yeah!**
