package wissenstest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVReader {

    private static final List<String> allCategories = new ArrayList<String>();
    private static final HashMap<Integer, String> hm = new HashMap<>();
    private static final List<String> questionsIds = new ArrayList<String>();
    private static final List<String> answers = new ArrayList<String>();
    private static final List<String> correctAnswers = new ArrayList<String>();

    public static List<Question> readCSV() {

        final String path = "Wissenstest_sample200.csv";//@toDo localize strings
        final String splitCharacter = ";";
        List<Question> questions = new ArrayList<Question>();
        Category c = new Category();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); // Read first line

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] character = line.split(splitCharacter);    // Seperate by splitCharacter                

                allCategories.add(character[7]);
                hm.put(Integer.valueOf(character[0]), character[7]);
                answers.add(character[0] + " " + "1." + character[4] + " 2." + character[2] + " 3." + character[3] + " 4." + character[5]);
                questionsIds.add(character[0] + " " + (String) character[1]);
                correctAnswers.add(character[0] + " " + Integer.valueOf(character[6]));

                Question question = new Question(Integer.valueOf(character[0]), new Category(character[7]), (String) character[1],
                        new Answer(character[2]), new Answer(character[3]), new Answer(character[4]), new Answer(character[5]),
                        Integer.valueOf(character[6]));

                questions.add(question);

            }
        } catch (Exception ex) {
            System.err.println("Error reading CSV-File.");//@toDo localize strings
        }
        return questions;
    }

    String getAllCategories(int i) {
        return allCategories.get(i);

    }

    String getHmText(int i) {
        return hm.get(i);
    }

    HashMap<Integer, String> getHmText() {
        return hm;
    }

    List<String> getAnswers() {
        return answers;
    }

    List<String> getQuesstion() {
        return questionsIds;
    }

    List<String> getCorrectAnswers() {
        return correctAnswers;
    }
}
