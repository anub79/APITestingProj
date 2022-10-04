Feature: Validating Place APIs

  @AddPlace @Regression
  Scenario Outline:Verify if place is being successfully added using AddPlaceAPI
    Given AddPlace payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" using "POST" http request
    Then the API call got success with status code "200"
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"
    Examples:
    |name       |language       |address                  |
    |  AAhouse  |   English     |   World Cross Centre    |
   # |  BBhouse  |   French      |   BB French Centre    |

  @DeletePlace @Smoke
  Scenario:Verify if place is being successfully deleted using AddPlaceAPI

    Given DeletePlace payload
    When User calls "deletePlaceAPI" using "POST" http request
    Then the API call got success with status code "200"
    And "status" in response body is "OK"
