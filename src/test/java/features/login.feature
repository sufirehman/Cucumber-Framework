Feature: Test suite for login functionality

  @TC01 @login_01 @login @all
  @parallelrun
  Scenario: Verify user is able to access Swag Labs login page
    Given user opens sauce labs website
    Then user should be able to access login screen
    Then user close Browser


  @TC02 @login_02 @login @all
  @parallelrun
  Scenario: Verify user is able to perform login with valid credentials
    Given user opens sauce labs website
    Then user successfully login to the website
    Then user clicks on menu button
    Then user perform logout
    Then user close Browser

  @TC03 @login_03 @login @all
  @parallelrun
  Scenario: Verify user should not able to perform login with a locked account
    Given user opens sauce labs website
    Then user enter incorrect details to the website
    Then user should observe an error Epic sadface: Sorry, this user has been locked out.
    Then user close Browser