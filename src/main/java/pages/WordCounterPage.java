package pages;

import org.openqa.selenium.By;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://wordcounter.net/")
public class WordCounterPage extends PageObject{

    private WordCounterPage(){}
    
    public static final Target TEXT_BOX = Target.the("Box in order to inser text").located(By.id("box"));
    public static final Target COUNTER_DISPLY = Target.the("Disply with counter of words and characteres").located(By.xpath("//*[@class='panel-footer']"));
    public static final Target KW_DATA_PANEL = Target.the("Keyword density data secction").located(By.id("kwd-accordion-data"));
    public static final Target KWD_PANEL_EMPTY = Target.the("message when kwd pannel is empty").located(By.xpath("//*[@class='message_for_empty_panel' and contains(text(), 'Start ')]"));

    
}
