package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class CharacterCount implements Question<String[]>{

    private static String[] wordsAndCharacteres;


     public static String[] splitStringBySpace(String input) {
        wordsAndCharacteres = (input.split("\\s+"));
        return wordsAndCharacteres;
        
    }

    @Override
    public String[] answeredBy(Actor actor) {
        return wordsAndCharacteres;

    
}
}