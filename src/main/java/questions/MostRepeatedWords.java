package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import utils.WordRepetitionCounter;

import java.util.List;
import java.util.Map;


public class MostRepeatedWords implements Question<List<Map.Entry<String, Long>>> {

    private final String txtValue;

    public MostRepeatedWords(String txtValue) {
        this.txtValue = txtValue;
    }

    @Override
    public List<Map.Entry<String, Long>> answeredBy(Actor actor) {
        
        return WordRepetitionCounter.getTopThreeRepeatedWords(txtValue);
    }

    public static MostRepeatedWords from(String txtValue) {
        return new MostRepeatedWords(txtValue);
    }
}