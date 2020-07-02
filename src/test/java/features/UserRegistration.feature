Feature: User Registration
  I want to check that the user can register in our website.

  Scenario Outline: User Registration
    Given the user in the home page
    When I click on register link
    And I entered "<firstName>", "<lastName>", "<email>", "<password>"
    Then The registration page displayed successfully

    Examples:
      | firstName | lastName | email | password |
      | ahmed | rami | ahmedrami@gmail.com | arami123456|
      | Mohamed | Mazen | mmazen@gmail.com | mmazen123456|

