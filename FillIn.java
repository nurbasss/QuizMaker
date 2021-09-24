import java.util.*;
import java.io.*;

public class FillIn extends Question{

  public String toString(){
     return getDescription().replace("{blank}", "_____________");
  }
}