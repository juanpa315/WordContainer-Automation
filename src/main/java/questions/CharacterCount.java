package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import utils.SplitString;


public class CharacterCount implements Question<String[]>{

    private static String[] wordsAndCharacteres;


     public static String[] splitStringBySpace(String input) {
        return SplitString.splitStringBySpace(input);
        
    }

    @Override
    public String[] answeredBy(Actor actor) {
        return wordsAndCharacteres;

    
}
}