
# FEadidasExercise
Front-end automated testing repo by Ricardo Villanueva Ojosnegros for Adidas' recruiting challenge

## Requirements

 - Java 11.0.13
 - Maven 3.8.4
 - Windows 10
 - Git
 - Chrome 96.0.4664.45 or firefox 78 and superior versions
 
## Download
Execute this command to download the repo

    git clone https://github.com/rikrdo95/FEadidasExercise.git
    
## Execute
Run this command in project directory

`mvn clean verify`

You can choose the browser adding this to the previous comand

    -Dbrowser=BROWSER
>By default the browser is set to chrome.

Browser options:
- chrome
- firefox

## Check results
In the folder BEadidasExercise/target/site/serenity open the file index.html after the execution finish to open the report. 
