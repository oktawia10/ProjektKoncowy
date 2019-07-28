Feature: Register user on katalon Form Webside

  Scenario Outline: Register valid user with no errors
    Given I am on webside "https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html"
    When I register user with "<name>" "<surname>" "<date of birth>" "<adress>" "<email>" "<password>" "<company>" "<comment>"
    Then User is successfully registered

 Examples:
    |name    | surname|date of birth | adress    |email        |password|company|comment|
    |Jan     | Kot    |07/01/1980    |Nowa 10    |jan@wp.pl    |ghghghg |test    |zzzzz  |
    |Alicja  | Pies   |0510/1960     |Zielona 11 |ala@gmail.com|hkhhkhh |Firma   |gjgjgj |
