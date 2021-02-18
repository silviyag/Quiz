
package wissenstest;
 
public class main {
 

 private static QuizUi quizUi;  //UserInterface
    
    public static void main(String[] args) {
        quizUi = new QuizUi();
        quizUi.start();
    }
    
    public static QuizUi getUI(){
        return quizUi;
    }
    
    public static void setUI(QuizUi ui){
        quizUi = ui;
    }
    
}
