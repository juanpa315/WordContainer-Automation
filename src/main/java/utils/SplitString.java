package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitString {

    public static String[] splitStringBySpace(String input) {

        return (input.split("\\s+"));
    }

    public static List<String> splitStringByNewline(String input) {
        return Arrays.stream(input.split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
