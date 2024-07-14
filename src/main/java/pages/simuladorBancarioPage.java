package pages;

import org.openqa.selenium.By;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.bancolombia.com/personas/creditos/consumo/simulador-credito-consumo##sim-results")
public class simuladorBancarioPage extends PageObject {

    public static final Target TEXT = Target.the("TEXT OF THE BANK PAGE")
            .located(By.xpath("//*[@id=\"for-detail\"]/div[1]/h1"));

}
