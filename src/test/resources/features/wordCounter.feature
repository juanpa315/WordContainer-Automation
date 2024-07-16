Feature: Validate character and word counter functionality on the Word Counter website

  Background: The user access to wordcounter website
    Given I access to wordcounter website

  @Test1
  Scenario: As a tester I want to insert a text and verify that the system performs the corresponding count of words and characters
    When I insert a text with value "<txtValue>"
    Then I can see the count of words and characteres

    Examples:
      | txtValue             |
      | Apart from counting words and characters, our online editor can help you to improve word choice and writing style, and, optionally, help you to detect grammar mistakes and plagiarism. To check word count, simply place your cursor into the text box above and start typing. You'll see the number of characters and words increase or decrease as you type, delete, and edit them. You can also copy and paste text from another program over into the online editor above. The Auto-Save feature will make sure you won't lose any changes while editing, even if you leave the site and come back later. Tip: Bookmark this page now.       |
      #| This is another test |
      #| pr3.eb4              |
      #| d                    |
