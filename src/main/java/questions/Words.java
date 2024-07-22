package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import utils.WordRepetitionCounter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Words implements Question<List<Map.Entry<String, Long>>> {

    private final String txtValue;

    public Words(String txtValue) {
        this.txtValue = txtValue;
    }

    @Override
    public List<Map.Entry<String, Long>> answeredBy(Actor actor) {
        
        return WordRepetitionCounter.getWordsFromInput(txtValue).stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3)  
                .collect(Collectors.toList());

    }

    public static Words from(String txtValue) {
        return new Words(txtValue);
    }
}