package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static tasks.OpenBrowserTask.openBrowser;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static pages.simuladorBancarioPage.*;

public class openBrowserStepDefinition {

   // @ParameterType(".*")
   // public Actor actor(String actorName) {
   //     return OnStage.theActorCalled(actorName);
   // }
   // @Before
   // public void setUp() {
   //     setTheStage(new OnlineCast());
   // }

    @Given("{actor} opens the browser and navigates to page")
    public void user_opens_the_browser_and_navigates_to_page(Actor actor) {
        actor.attemptsTo(openBrowser());
    }

    @Then("{actor} should see the page homepage")
    public void user_should_see_the_google_page(Actor actor) {

        actor.attemptsTo(
                Ensure.that(TEXT).isDisplayed());

    }

}
