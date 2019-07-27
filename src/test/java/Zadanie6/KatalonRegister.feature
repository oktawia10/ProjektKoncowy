Feature: Register user on katalon Form Webside

  Scenario Outline: Register valid user with no errors
    Given I am on webside "https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html"
    When I register user with "<name>" "<surname>"
    Then User is successfully registered

 Examples:
    |name    | surname|
    |Jan     | Kot    |
    |Alicja  | Pies   |
