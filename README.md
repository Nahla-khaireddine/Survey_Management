# Questions_Management

## Statement
Write a java command line program that gives you two options. One to ask a specific question and the other option is to add questions and their answers

## Restrictions

-A Question is a String with max 255 chars

-An Answer is a String with max 255 chars

-A Question can have multiple answers (like bullet points)

-If the user asks a question it has to be exactly the same as entered – no “best match”.

-If the user asks a question which is not stored yet the program should print “the answer to life, universe and everything is 42” according to “The hitchhikers guide to the Galaxy”

-If the user asks a question whish is  stored the program should print all answers to that question. Every Answer in a separate line
Adding a question looks like: < question >? “< answer1 >” “< answer2 >” “< answerX >”

Char “?” is the separator between question and answers

-Every Question needs to have at least one answer but can have unlimited answers all inside of char “

## Implementation
As technologies we will use:
```
- Java 8: As a development platform
- Git: As version management tool
- Maven: As a building Tool
```

## Run

To run the project you need to open the command line. Navigate to the specified directory in which you want to download the project.

Download the project using the following command:
```
git clone https://github.com/Nahla-khaireddine/Survey_Management.git
```

To test the application run the following command 
```
mvn test
```

To build the application run the following command
```
mvn install
```
To execute the application run the following command
```
mvn compile  exec:java -Dexec.mainClass=com.cgm.QuestionCgmApp.SurveyManagement
```
