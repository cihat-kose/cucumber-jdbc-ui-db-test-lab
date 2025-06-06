#Website: http://zero.webappsecurity.com/login.html
#Username: username
#Password: password
#
#Test Case 1:
#➢ Navigate to ZeroBank
#➢ Log in
#➢ Click Online Banking
#➢ Click Pay Bills
#➢ Click "Add New Payee"
#➢ Fill in Name, Address, Account, and Details
#
#NOTE: Send 3 different sets of data
#NOTE: Use a Data Table
#
#➢ Click the Add button
#➢ Verify that the operation was successful

Feature: New Payee Functionality

  Background:
    Given Navigate to website
    And   Enter username that as "username" and password that as "password"
    When  Click login button
    Then  Verify that user logged in

  @Regression
  Scenario Outline: Fill in the required information completely
    When Click on the element in OnlineBanking
      | onlineBanking |
      | payBills      |
      | addNewPayee   |

    And User sending name,address,account and details in OnlineBanking
      | payeeName    | <name>    |
      | payeeAddress | <address> |
      | payeeAccount | <account> |
      | payeeDetails | <details> |

    When Click to add button
    Then Verify that the transaction was successful

    Examples:
      | name    | address | account | details          |
      | Hilde   | Oslo    | 156328  | Rent payment     |
      | Mustafa | Ankara  | 965832  | Amazon payment   |
      | Alex    | London  | 965832  | Electricity bill |
