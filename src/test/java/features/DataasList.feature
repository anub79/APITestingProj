Feature: Registration feature
  Scenario:user Registration with different data
    Given User is on Registration page
    When User enters following user details
      |Sunita|automation|s@gmail.com|99999|London|
      | Syam |  sauto   |syam@gmail.com |89876|Alabama|
      | Rohan | Rohauto|Rohauto@gmail.com |89876|California|
      | Kiya |  kiyaauto|kiyaauto@gmail.com |8767776|Chicago|
    Then user registration should be success
