import java.util.*;
import java.io.*;

abstract class Question extends Quiz{

private String description;
private String answer;
 
 public Question(){
 }

  public void setDescription(String description){
	this.description = description;
  }
  
  public void setAnswer(String answer){
  	this.answer = answer;
  }

  public String getDescription(){
  	return description;
  }

  public String getAnswer(){
  	return answer;
  }
} 