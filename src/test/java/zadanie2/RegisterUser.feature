Feature: Register user on Coders Guru

  Scenario Outline: Register valid user with no errors

    Given I am on webside "https://tester.codersguru.pl/" and click button "Załóż konto"
    And registration form opens "https://tester.codersguru.pl/register/"
    When I register user with "<Email>" "<Imie>" "<Nazwisko>" "<Haslo>" "<Powtorz haslo>" "<Miasto>" "<Kod pocztowy>" "<Ulica>" "<Numer domu/lokalu>" "<Zapoznalem sie>" and click button "Zarejestruj"
    Then User is successfully registered

    Examples:
      |Email       |Imie |Nazwisko|Haslo  |Powtorz haslo|Miasto   |Kod pocztowy|Ulica|Numer domu/lokalu|Zapoznalem sie|
      |janez@wp.pl |Janek|Kot     |testowe|testowe      |Warszawa |01-006      |Nowa  |17/52           |true          |
      |janey@wp.pl |Janek|Kot     |testowe|testowe      |Warszawa |01-006      |Nowa  |17/52           |true          |


