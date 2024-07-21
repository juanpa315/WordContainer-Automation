package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import questions.CharacterCount;
import questions.MostRepeatedWords;
import utils.SplitString;

import java.util.Map;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static tasks.OpenBrowserTask.openBrowser;
import static tasks.InsertTextIntoBox.insertTextIntoBox;

public class wordCounterStepDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    @Given("{actor} access to wordcounter website")
    public void i_access_to_wordcounter_website(Actor actor) {
        actor.attemptsTo(openBrowser());
    }

    @When("{actor} insert a text with value {string}")
    public void i_insert_a_text_with_value(Actor actor, String txtValue) {
        actor.attemptsTo(insertTextIntoBox(txtValue));
    }

    @Then("{actor} can see the count of words and characteres for input {string}")
    public void i_can_see_the_count_of_words_and_characteres(Actor actor, String txtValue) {

        String wordsCharactersMessage = actor.recall("words_characters");
        String[] wcCounterDisplay = CharacterCount.splitStringBySpace(wordsCharactersMessage);
        String[] wordsInTxtValue = CharacterCount.splitStringBySpace(txtValue);

        actor.attemptsTo(
                Ensure.that(Integer.valueOf(wcCounterDisplay[0])).isEqualTo(wordsInTxtValue.length)
                        .withReportedError("The website don't display the number of Words correctly."),

                Ensure.that(Integer.valueOf(wcCounterDisplay[2])).isEqualTo(txtValue.length())
                        .withReportedError("The website don't display the number of characters correctly."));

    }

    @And("{actor} can see the most repeated words with the number of repetitions for input {string}")
    public void i_can_see_the_most_repeated_words_with_the_number_of_repetitions(Actor actor, String txtValue) {

        List<Map.Entry<String, Long>> topThreeWords = actor.asksFor(MostRepeatedWords.from(txtValue));
        String kwDensity = actor.recall("kwd_data");
        List<String> kdDensityWords = SplitString.splitStringByNewline(kwDensity);

        for (int i = 1; i < kdDensityWords.size(); i += 2) {
            String currentWord = kdDensityWords.get(i);
            boolean wordFound = false;

            for (Map.Entry<String, Long> entry : topThreeWords) {
                if (entry.getKey().contains(currentWord)) {
                    wordFound = true;
                    break;
                }
            }

            actor.attemptsTo(
                    Ensure.that(wordFound).isTrue()
                            .orElseThrow(
                                    new AssertionError("Word '" + currentWord + "' not found in top three words")));

        }

    }

}
