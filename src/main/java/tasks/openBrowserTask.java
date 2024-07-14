package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.simuladorBancarioPage;

public class openBrowserTask implements Task {

    public static openBrowserTask openBrowser() {
        return new openBrowserTask();
    }

    @Override
    @Step("{0} navigate to the bank page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(simuladorBancarioPage.class));
    };

}
