package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static pages.WordCounterPage.COUNTER_DISPLY;
import static tasks.OpenBrowserTask.openBrowser;
import static tasks.InsertTextIntoBox.insertTextIntoBox;
import static utils.SplitString.*;
import java.util.List;

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

    @Then("{actor} can see the count of words and characteres")
    public void i_can_see_the_count_of_words_and_characteres(Actor actor) {
        
        String wordsCharacters = actor.recall("words_characters");
        String kwdData = actor.recall("kwd_data");

        List<String> countWordsCharacters = splitStringBySpace(wordsCharacters);
        List<String> keywordDensity = splitStringByNewline(kwdData);

        System.out.println(countWordsCharacters.get(0));
        System.out.println(keywordDensity.get(0));
    }

}
