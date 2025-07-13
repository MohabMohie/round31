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
```html
<tagName attribute="value">TEXT</tagName>
```

## xpath formula:
```xpath
//tagName[@attribute='value']

//*[@attribute='value']

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

//tagName[text()='value']
//tagName[contains(text(),'partialValue')]

//tagName[@attribute='value']/axis::relatedTagName[@attribute='value']

```
## xpath axis:
- parent
- following-sibling
- preceding-sibling
- ancestor
- following
- preceding

## Golden rules:
- use as few nodes as possible
- use as few attributes as possible
- use only reliable values for your attributes
- a locator must have only one match
- never use an index UNLESS explicitly stated in the requirements of your test
- always try to optimize (reduce the number of nodes, reduce the number of attributes, increase the quality of values)

## Design Patterns:
- Bot pattern `src/main/java/engine/Bot.java` -> Moves all selenium-actions to a single class, allowing for easy reuse and maintenance of common actions.
- Test Abstraction `src/test/java/modularTests/TestCase.java` -> Provides a base class for all test cases, allowing for shared setup and teardown logic.
- Fluent design - action chaining `src/main/java/engine/FluentBot.java` -> Makes writing tests more readable and maintainable, lower learning curve.
- Page Object Model `src/main/java/pages/` -> Need to contain all locators and business-level actions for the page.

## Mixed design strategies:
- Bot + Abstract Test Case + Fluent Bot + Fluent Page Object Model