Feature: verifying the application

  Scenario Outline:Login Feature
    Given Opening the "<browser>" browser launching the "<Url>"
    Then close the browser
    Examples:
      | browser | Url                       |
      | chrome  | https://www.saucedemo.com |
