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

# Element Identification:

## WebElement
<tagName attribute="value">TEXT</tagName>

## xpath formula:
//tagName[@attribute='value']

//tagName
//tagName[@attribute]
//tagName[@attribute1][@attribute2]
//tagName[@attribute1='value1'][@attribute2='value2']

(//tagName[@attribute='value'])[index]

//tagName/childTagName
//tagName//grandChildTagName

//tagName[contains(@attribute,'partialValue')]

//tagName[not(@attribute='value')]
//tagName[not(contains(@attribute,'partialValue'))]


//TODO: xpath axis

## Golden rules:
- use as few nodes as possible
- use as few attributes as possible
- use only reliable values for your attributes
- a locator must have only one match
- never use an index UNLESS explicitly stated in the requirements of your test
- always try to optimize (reduce the number of nodes, reduce the number of attributes, increase the quality of values)

