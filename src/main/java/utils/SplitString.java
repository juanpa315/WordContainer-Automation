package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitString {

    public static List<String> splitStringBySpace(String input) {

        return Arrays.asList(input.split("\\s+"));
    }

    public static List<String> splitStringByNewline(String input) {
        return Arrays.stream(input.split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String input = "esto es un caracter \n\\";
      
        System.out.println("the count of characters is: "+ input.length());
      /*  List<String> words = splitStringByNewline(input);
        
        System.out.println("Words in the string:");
        for (int i = 0; i < words.size(); i++) {
            System.out.println("Position " + i + ": " + words.get(i));
        }*/ 
    }

}
