# QuizMaker
Question class
Abstract class;
Any type of question will have a description (question text) and its answer (correct only);
Getter and setter methods.

Test class
Extends the Question class;
Creates a multiple-choice test question;
Several possible options (only 4 for now), including single correct answer;
Labels are set automatically, starting from A, B, C, ….

FillIn class (Fill + In)
Extends the Question class;
Fill in the blanks question type;
Only one blank (at least for now), that is indicated by “{blank}” string in a text file;
The answer must be case-insensitive (shall be checked by the Quiz class).
Quiz class
Consists of list of questions;
Has a special method (static) that loads questions from a text file, and creates a quiz;
Throws InvalidQuizFormatException if the file format is not correct; 
The start method is responsible for the whole test process and its results. Note that it shuffles the order of questions and test question answers (options) each time the quiz is started. It also checks that the user input for Test questions is a valid one, i.e. one of A, B, ...

InvalidQuizFormatException class
A special exception type thrown if the input file format is not correct;
Prints an appropriate error message.

QuizMaker class
Has the main method where a quiz is created and started;
The whole quiz starts as follows:
> java QuizMaker JavaQuiz.txt
Sample run of the program is attached at the end of this document.

Quiz text file
The file name becomes the quiz name;
Each question separated by exactly one empty line;
Two types of questions: Test or FillIn;
First line: question description; Second line: answer;
If only one answer line, then it is a FillIn type question;
In case there are multiple answer lines following the question description, this is a Test type question, the first answer being the correct one;
Sample text file provided. Try creating your own quizzes and share with others.
