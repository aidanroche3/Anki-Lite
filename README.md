[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/a1SE4wKh)
# 3500 PA 01 Project Repo

[PA Write Up](https://markefontenot.notion.site/PA-01-Summarize-This-c8275591b4eb43df9f56dbae881f2423) 

It includes several additional tools:
1. Gradle Build Automation
2. JaCoCo for Test Coverage
3. CheckStyle for Code Style Checks (Using the custom [cs3500 check file](./config/checkstyle/cs3500-checkstyle.xml))

## How To Run:

### Study Guide Generation
- Provide three arguments to the driver
  - Arguments passed should be a valid input directory containing .md files, an order flag, and a valid .md output path
  - Valid order flags to sort the study guide are "filename", "created", and "modified"
  - EX: "src/tests/resources/notes-root filename src/tests/resources/outputDirectory/output.md"

### Study Session
- Provide no arguments to the driver to start a study session
  - Study session is run through the console
  - The user will be prompted for a valid .sr file and the number of questions to study
    - The .sr file passed in is assumed to be properly formatted