import java.io.*;
import java.util.*;

class Quiz {
    private String name;
    private ArrayList<Question> questions = new ArrayList();

    public Quiz() {
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public static Quiz loadFromFile(String filename) throws InvalidQuizFormatException, Exception {
        Scanner input;
        try {
          input = new Scanner(new File(filename)); 
            
            
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
            return null;
           
        }
            Quiz quizz = new Quiz();
            quizz.setName(filename.substring(0, filename.length()-4));
           
        try {
            while(input.hasNext()) {
                String description = input.nextLine();
                String answer = input.nextLine();
                FillIn fillinQuestion;
                Test testQuestion;
                if (input.hasNext()) {
                    String opt = input.nextLine();
                    if (opt.equals("")) {
                        fillinQuestion = new FillIn();
                        fillinQuestion.setDescription(description);
                        fillinQuestion.setAnswer(answer);
                        quizz.addQuestion(fillinQuestion);
                    } else {
                        testQuestion = new Test();
                        testQuestion.setDescription(description);
                        testQuestion.setAnswer(answer);
                        String[] variants = new String[]{opt, input.nextLine(), input.nextLine()};
                        testQuestion.setOptions(variants);
                        quizz.addQuestion(testQuestion);
                        if (input.hasNext()) {
                            input.nextLine();
                        }
                    }
                } else {
                    fillinQuestion = new FillIn();
                    fillinQuestion.setDescription(description);
                    fillinQuestion.setAnswer(answer);
                    quizz.addQuestion(fillinQuestion);
                }
            }

            return quizz;
        } catch (Exception e) {
            throw new InvalidQuizFormatException(e.getMessage());
        }    
    }

    public String toString() {
        String s = "";
        s = s + "----------------------\n";
        for(int i =0;i<questions.size();i++){
           s = s + (i+1) + ". " + questions.get(i).toString() + "\n\n";

        }
        return s;
    }


    public void start(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("WELCOME TO " + "\"" + this.getName() + "\"" + " QUIZ!!");
        System.out.println("----------------------------------------------------------------");

        int total = this.questions.size();
        int score = 0;
        
        Collections.shuffle(this.questions);
        Scanner in = new Scanner(System.in);

      
         for(int i =0; i<this.questions.size();i++){
           
            Question quest = (Question)this.questions.get(i);
            System.out.println((i+1) + ". " + quest);
            System.out.println("------------------------------------");
            if (quest instanceof FillIn) {
                System.out.print("Type your answer: ");
                if (in.nextLine().toLowerCase().equals(quest.getAnswer().toLowerCase())) {
                    System.out.println("Correct!");
                    System.out.println("_______________________________________________________________\n");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                    System.out.println("_______________________________________________________________\n");
                }
            } else if (quest instanceof Test) {

                System.out.print("Enter the correct choice: ");
                int ans;
                for(ans = in.nextLine().charAt(0) - 65; ans < 0 || ans >=4; ans = in.nextLine().charAt(0) - 65) {
                    
                    System.out.print("Invalid choice! Try again(Ex: A, B, ...): ");
                }
    
                if (((Test)quest).getOptionAt(ans).equals(quest.getAnswer())) {
                    
                    System.out.println("Correct!");
                    System.out.println("_______________________________________________________________\n");
                    score++;

                } else {

                    System.out.println("Incorrect!");
                    System.out.println("_______________________________________________________________\n");
                }
            }
        }

        System.out.printf("Correct Answers: %d/%d (%.1f%%)\n", score, total, (float)score / (float)total * 100.0);
        


    }

    
}
















