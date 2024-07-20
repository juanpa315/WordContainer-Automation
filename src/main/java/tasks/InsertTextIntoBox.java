package tasks;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static pages.WordCounterPage.COUNTER_DISPLY;
import static pages.WordCounterPage.KWD_PANEL_EMPTY;
import static pages.WordCounterPage.KW_DATA_PANEL;
import static pages.WordCounterPage.TEXT_BOX;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InsertTextIntoBox implements Task{

    private final String txtValue;

    public InsertTextIntoBox(String txtValue) {
        this.txtValue = txtValue;
    }

    public static InsertTextIntoBox insertTextIntoBox(String txtValue){
        return new InsertTextIntoBox(txtValue);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
            WaitUntil.the(KW_DATA_PANEL, isVisible()).forNoMoreThan(10).seconds(),
            Click.on(TEXT_BOX),
            Enter.theValue(txtValue).into(TEXT_BOX),
            WaitUntil.the(KWD_PANEL_EMPTY, isNotVisible()).forNoMoreThan(10).seconds()
        );

        String kwdData = KW_DATA_PANEL.resolveFor(actor).getText();
        String wordsCharacters = COUNTER_DISPLY.resolveFor(actor).getText();
        
        actor.remember("words_characters", wordsCharacters);
        actor.remember("kwd_data", kwdData);
        actor.remember("txtValue", txtValue);
    }
    

}
