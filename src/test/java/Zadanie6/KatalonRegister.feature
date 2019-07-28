Feature: Register user on katalon Form Webside

  Scenario Outline: Register valid user with no errors
    Given I am on webside "https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html"
    When I register user with "<name>" "<surname>" "<gender>" "<date of birth>" "<address>" "<email>" "<password>" "<company>" "<role>" "<job expectation>" "<ways of development>" "<comment>"
    Then User is successfully registered

 Examples:
   |name    | surname|gender |date of birth |address    |email        |password| company|role|job expectation|ways of development|comment|
   |Jan     | Kot    |male   |07/01/1980    |Nowa 10    |jan@wp.pl    |ghghghg |test    |QA  |Challenging    |Read books         |zzzzz  |
