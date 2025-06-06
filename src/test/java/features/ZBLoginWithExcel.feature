#Website: http://zero.webappsecurity.com/login.html
#Username: username
#Password: password

#Test Case 1: Login Functionality
#➢ Navigate to ZeroBank site
#➢ Enter username and password
#➢ Verify that you are logged in

Feature: Login Functionality

  @Smoke
  Scenario: Login with valid username and password
    Given Navigate to website
    And   Enter username and password from ZeroBankData
    When  Click login button
    Then  Verify that user logged in
