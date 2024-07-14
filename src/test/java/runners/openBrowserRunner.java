package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.screenplay.targets.Target;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", // Ruta a las características
        glue = "stepdefinitions", // Ruta a los pasos (step definitions)
        tags = "@openBrowser", // Etiqueta que coincide con la feature
        plugin = { "pretty", "html:target/cucumber-reports" } // Formato de informes de ejecución
)
public class openBrowserRunner {
    // Esta clase actúa como marcador para la ejecución de la feature "openBrowser".

}
