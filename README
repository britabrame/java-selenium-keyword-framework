## About
This **keyword-driven** framework takes common test step actions (goTo, click, input, etc) and implements reusable code to execute those actions using Selenium WebDriver. Test scripts are created in an Excel sheet where each test step is represented by a keyword and its relevant parameters (selector, selector type, test data). 

Benefits of this framework are:
* It keeps coding and test scripting separate, so anyone can contribute to writing tests, regardless of technical skills
* Reduces duplication of code by implementing more generic methods for interacting with web elements

### Built with
* Java
* Selenium WebDriver
* TestNG
* Maven

## Writing test scripts
Each test must be entered into the excel in the expected format:
![Screenshot](https://github.com/britabrame/java-selenium-keyword-framework/blob/master/testScriptImage.png?raw=true)
 
### Columns:
* **Title**: Test case title - marks the beginning of a new test
* **Step ID:** Step number
* **Keyword:** Any of the supported keywords (see Support Keywords section)
* **Object:** An id, class, or xpath of a web element to take action on, if required
* **Object Type:** Selector type (currently support id, class, and xpath - should be improved to support more flexible CSS selector strategy)
* **Data:** Any data needed to perform the action (ex: text to input)
* **Description:** Description of the test step, for logging

### Supported Keywords
* **openBrowser**: Begin each test case by opening the browser (this could be later built into the code instead of being explicitly called)
* **goTo**: Navigate to the specified URL in the Data column
* **input**: Type the value from the Data column into the element specified in the Object column
* **click**: Click the element specified in the Object column
* **expectVisible:** Assert that the specified element is visible
* **closeBrowser:** End the test by closing the browser

## Setup
1. Clone the project:
	```
	git clone https://github.com/britabrame/java-selenium-keyword-framework.git
	```
1. Install maven if it is not already installed locally

## Running tests
2. Run tests:
	```
	mvn test
	```

