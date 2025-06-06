@EmpManagement
Feature: To validate the bookstore by adding , updating, fetching all employees and deleting them from the store with the help of user authentication

  @CRUDOperations @Sanity @SmokeTest123
  Scenario:To create,update ,fetch book by id and finally delete the employee in the list of employees of a company
    Given Adding the new employee into the store after successful login of user into the system
#    When user tries to signup the store with new credentials
#    Then validate whether a new user is created with response code 200 and response message User created successfully after signup
#    When user tries to login to the bookStore using the  new credentials
#    Then validate whether the user has logged in successfully with the response code 200 and response message success
#
#    When user tries to create a new book in the book store using the valid token of the user
#    Then verify whether the book is created and the response is success
#
#    When user tries to edit the book with the name
#    Then verifies whether the response is 200
#    And verify the edited book details values in response for editing name
#
#    When user tries to fetch the book created using the id created for that book
#    Then verify whether the response is success
#
#    When user tries to delete the book added in the bookstore using the id
#    And verify the response after deleting the book should be success
#    When user tries to delete the book added in the bookstore using the id
#    And verify the response after deleting the book should be notfound