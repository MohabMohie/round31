# Automatest: Leveling up (Round 31)

This is a sample project, created to practice and learn how to use Selenium WebDriver with Java/Maven and TestNG.

# Conventions:

- lowerCamelCase
- UpperCamelCase
- lower_snake_case
- UPPER_SNAKE_CASE

# Project Structure:

-src
    - main //this is where my application code goes
        - java //this is for .java files
        - resources //this is for non-java resources like properties files, xml files, etc.
    - test //this is where my test code goes
        - java //this is for .java files
        - resources //this is for non-java resources like properties files, xml files, etc.

# Test Data discussion:

3 users == userToBeRead, userToBeUpdated, userToBeDeleted
make sure that 1 user doesn't exist == userToBeCreated

Test Data Creation
- create new empty database
- prepare test data manually
- take a database snapshot/backup

Test Execution -> manually or automatically (nightly) or automatically (with every PR)
- create new environment (infrastructure as code)
- Restore latest database snapshot from artifactory
- run the tests
- destroy environment

To Manage Test Data -> manually triggered
1- datasource snapshot/backup
2- upload backup to artifactory

