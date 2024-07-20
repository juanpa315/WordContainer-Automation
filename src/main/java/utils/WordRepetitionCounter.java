package utils;

import java.util.*;
import java.util.stream.Collectors;

public class WordRepetitionCounter {

    public static List<Map.Entry<String, Long>> getTopThreeRepeatedWords(String input) {

        String cleanedInput = input.replaceAll("[^\\p{L}\\p{N}-\\s]", "").toLowerCase();
        
        String[] words = cleanedInput.toLowerCase().split("\\s+");

        Map<String, Long> wordCounts = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));

        return wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())  
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String input = "Prueba Prueba Prueba espejo";
        List<Map.Entry<String, Long>> topThree = getTopThreeRepeatedWords(input);

        System.out.println("Top three repeated words:");
        for (Map.Entry<String, Long> entry : topThree) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}