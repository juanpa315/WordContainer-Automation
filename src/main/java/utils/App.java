package utils;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;


public class App{

    public static List<Map.Entry<String, Long>> counterWodsInAFile(String filePath){

        return WordRepetitionCounter.getWordsFromInput(filePath);
    }

    public static int splitInput(String filePath){

        String[] wordWithSplit = SplitString.splitStringBySpace(filePath);
        return wordWithSplit.length;
    }

    private static String readFileContent(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }


    public static void main(String[] args) throws IOException {
    String filePath = "./src/main/java/utils/testfile/inputFile.txt";
    String fileContent = readFileContent(filePath);


    List<Map.Entry<String, Long>> words = counterWodsInAFile(fileContent);
    int counterOfWords = splitInput(fileContent);
    int counterCharacters = fileContent.length();

    System.out.println("The file has: "+ counterOfWords+ " Words");
    System.out.println("The file has: "+ counterCharacters+ " Characters"+"\n");
    
    for (Map.Entry<String, Long> entry : words) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
}


