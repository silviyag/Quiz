package wissenstest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class QuizUi {

    private Database database;
    boolean gameActive = true;

    private Player player = new Player();
    Category category = new Category();
    Question question = new Question();
    Analyse analyse = new Analyse();
    CSVReader csv = new CSVReader();
    List<String> ids = new ArrayList<String>();
    List<String> indexOfAnswers = new ArrayList<String>();
    Scanner select = null;

    public void start() {
        printMenue();
        select = new Scanner(System.in);
        
        while (gameActive) {//@toDo localize text "\n Starting Match..."
            int choice = select.nextInt();
            switch (choice) {
                case 1:
                    readCsv();
                    startMatch(gameActive);
                    printMenue();

                    break;
                case 2:
                    System.out.println("\n Starting Match...");
                    startMatch(gameActive);
                    printMenue();

                    break;
                case 3:
                    System.out.println("\n Starting Analyse...");
                    analyseStart();
                    break;
                case 4:
                    System.out.println("\n Exit");
                    gameActive = false;
                    break;
                default:  //no choice jet
                    break;
            }
        }
    }

    private void printMenue() {//@toDo localize text
        System.out.println("---MAIN-MENUE---");
        System.out.println("1: Read CSV File to Database");
        System.out.println("2: Start Match");
        System.out.println("3: Start Analyse");
        System.out.println("4: Exit");
        System.out.print("Enter your choice: ");
    }

    public void startMatch(boolean startmatch) {
    select = new Scanner(System.in);
    
        if (startmatch == true) {//@toDo localize text
            System.out.println("Geben Sie bitte eine ID ein!");
            int id = select.nextInt();
            player.setPlayerId(id);

            System.out.println("Geben Sie bitte Ihr Name ein!");
            String name = select.next();
            player.setPlayerName(name);

            System.out.println("Geben Sie bitte eine Kategorieanzahl ein!");
            int numberOfCategory = select.nextInt();
            category.setNumberOfCategories(numberOfCategory);

            System.out.println("Geben Sie bitte eine Fragenanzahl ein!");
            int numberOfQuestions = select.nextInt();
            question.setNumberOfQuestions(numberOfQuestions);

            chooseCategory(numberOfCategory, numberOfQuestions);
            //Analyse kann man in dem Menue als Option reinmachen
            //analyseStart();
        } else {
            gameActive = false;
        }
    }

    public Database getDataBase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void readCsv() {
        System.out.println("\n Reading CSV File...");
        List<Question> questions = CSVReader.readCSV();
        System.out.println("Done reading CSV File" + "\n" + "Connecting to database...");
        try {
            database = new Database();
        } catch (Exception ex) {
            System.err.println("Can not connect to Database.");
        }
        try {
            if (database != null) {
                for (int i = 0; i < questions.size(); i++) {
                    database.registerObject(questions.get(i).getCategory());
                    database.registerQuestionAndAnswer(questions.get(i), questions.get(i).getAnswers());
                }
            }
        } catch (Exception ex) {
            System.err.println("Database can not be updated.");
        }
        System.out.println();
    }

    void chooseCategory(int numberOfCategories, int numberOfQuestions) {
        int index = 0;
        String choose;
        List<String> choosenCategory = new ArrayList<String>();
        //zufaellige Zahl, um eine Kategorien auszuwaehlen
        Random random = new Random();
        while (index != numberOfCategories) {
            choose = csv.getAllCategories(random.nextInt(numberOfCategories + 1));//in den Klammern steht die Anzahl der Zahlen aus denen eine Zuf�llige ermittelt werden soll.
            choosenCategory.add(choose);
            index++;
        }
        game(choosenCategory, numberOfQuestions);
        //Optional: analyse Ergebnisse ausgeben
    }

    public void game(List<String> choosenCategory, int numberOfQuestions) {

        for (int i = 0; i < choosenCategory.size(); i++) {
            for (Map.Entry<Integer, String> entry : csv.getHmText().entrySet()) {
                if (numberOfQuestions == 0) {
                    break;
                }
                if (entry.getValue().equals(choosenCategory.get(i))) {
                    int key = entry.getKey();
                    for (int j = 0; j < csv.getQuesstion().size(); j++) {
                        if (csv.getQuesstion().get(j).contains(String.valueOf(key))) {
                            System.out.println(csv.getQuesstion().get(j));
                            String answers = csv.getAnswers().get(j).substring(5, csv.getAnswers().get(j).length()).trim();
                            System.out.println(answers);
                            Scanner select = new Scanner(System.in);
                            int answer = select.nextInt();                          
                            answerTest(answer, key);//ob die Antwort richtig war
                            numberOfQuestions--;
                            break;
                        }
                    }
                }
            }
        }
    }

    private void answerTest(int answer, int key) {
        int index = 1;
        for (int i = 0; i < csv.getCorrectAnswers().size(); i++) {
            String temp = csv.getCorrectAnswers().get(i).substring(csv.getCorrectAnswers().get(i).length() - 2, csv.getCorrectAnswers().get(i).length()).trim();//right answer
            String temp2 = csv.getCorrectAnswers().get(i).substring(0, csv.getCorrectAnswers().get(i).length() - 1).trim();// id of the question
            if (temp2.equals(String.valueOf(key))) {
                if (temp.equals(String.valueOf(answer))) {
                    System.out.println("Richtig");
                    index++;
                    break;
                } else {
                    System.out.println("Falsch");
                    index--;
                    break;
                }
            }
        }
        String playerIdData = String.valueOf(getPlayer().getPlayerId());
        indexOfAnswers.add(String.valueOf(index) + " " + playerIdData);
        analyse.setIndexOfAnswers(indexOfAnswers);
        //new Analyse(index, player.getPlayer_id());
    }

    private void analyseStart() {
        System.out.println("Möchten Sie eine Analyse durchführen?");
        boolean analyseIndex = false;
        Scanner select = new Scanner(System.in);
        if (select.next().equals("y")) {
            analyseIndex = true;
        } else {
            analyseIndex = false;
        }

        if (analyseIndex == true) {
            System.out.println("Geben Sie bitte die erste IDs ein!");
            String data1 = select.next();
            System.out.println("Geben Sie bitte die zweite IDs ein!");
            String data2 = select.next();
            String data = data1 + " " + data2;
            ids.add(data);
        }
        analyse.setAnalyseData(ids);

        compareRightAnswer();
    }

    private void compareRightAnswer() {
        for (int i = 0; i < ids.size(); i++) {
            String id2 = ids.get(i).substring(1, ids.get(i).length());
            String id1 = ids.get(i).substring(0, 1);
            searchId(id1, id2);
        }
    }

    private void searchId(String id1, String id2) {
        int rightAnswersId1 = 0;
        int rightAnswersId2 = 0;
        for (int i = 0; i < indexOfAnswers.size(); i++) {
           // System.out.println(indexOfAnswers.get(i));
            String playerId = indexOfAnswers.get(i).substring(2, 3);
            //int plId=Integer.valueOf(playerId);
            if (playerId.equals(id1)) {
                String results = indexOfAnswers.get(i).substring(0, 1);
                rightAnswersId1 = Integer.valueOf(results);
            } else if (playerId.equals(id2)) {
                String results = indexOfAnswers.get(i).substring(0, 1);
                rightAnswersId2 = Integer.valueOf(results);
            }
            /*
              } else if (plId==Integer.valueOf(id2)) {
                String results = indexOfAnswers.get(i).substring(0, 1);
                rightAnswersId2 = Integer.valueOf(results);
            }
            */
        }
        rightWrongAnswers(rightAnswersId1, rightAnswersId2);
    }

    private void rightWrongAnswers(int rightAnswersId1, int rightAnswersId2) {
        if (rightAnswersId1 > rightAnswersId2) {
            System.out.println("Analyse\n" + "Der Spieler mit ID 1 hat"
                    + " mehrmals eine richtige Antwort gegeben");
        } else if (rightAnswersId1 == rightAnswersId2) {
            System.out.println("Analyse\n" + "Die Spieler haben"
                    + " gleiche Anzahl an richt beantworteten Fragen gegeben");
        } else {
            System.out.println("Analyse\n" + "Der Spieler mit ID 2 hat"
                    + " mehrmals eine richtige Antwort gegeben");
        }
    }
}
