Feature: Validate character and word counter functionality on the Word Counter website

  Background: The user access to wordcounter website
    Given I access to wordcounter website

  @Test1
  Scenario: As a tester I want to insert a text and verify that the system performs the corresponding count of words and characters
    When I insert a text with value "<txtValue>"
    Then I can see the count of words and characteres for input "<txtValue>"

    Examples:
      | txtValue                                                             |
      | This is another test                                                 |
      | pr3.eb4                                                              |
      | de                                                                   |


  @Test2
  Scenario: As a tester I want to insert a text and verify that the system register the most repeated words in a file
    When I insert a text with value "<txtValue>"
    Then I can see the most repeated words with the number of repetitions for input "<txtValue>"

    Examples:
      | txtValue                                                             |
      | Texto1 Texto1 Texto1 Texto1 texto2 texto2 texto3 texto3 texto3 texto |