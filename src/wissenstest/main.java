
package wissenstest;
 
public class main {
 

 private static UI quizUI;  //UserInterface
    
    public static void main(String[] args) {
        quizUI = new UI();
        quizUI.start();
    }
    
    public static UI getUI(){
        return quizUI;
    }
    
    public static void setUI(UI UI){
        quizUI = UI;
    }
    
}
