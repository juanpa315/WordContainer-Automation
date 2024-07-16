package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.WordCounterPage;

public class OpenBrowserTask implements Task {

    public static OpenBrowserTask openBrowser() {
        return new OpenBrowserTask();
    }

    @Override
    @Step("{0} navigate to the word counter website")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(WordCounterPage.class));
    };

}
