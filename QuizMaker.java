import java.util.*;
import java.io.*;

public class QuizMaker {
    public static void main(String[] args)throws Exception{
       Quiz newQuiz = new Quiz();
  

      try{
      	newQuiz = newQuiz.loadFromFile(args[0]);
      	newQuiz.start();   
      }
       catch(Exception e){
       	System.out.println("Some problems(((");
       }
      
    }
}