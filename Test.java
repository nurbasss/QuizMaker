import java.util.*;
import java.io.*;

class Test extends Question {
    private String[] options = new String[4];
    private final int numOfOptions = 4;
    private ArrayList<Character> labels = new ArrayList();
    
    public Test() {
       this.labels.add('A');
       this.labels.add('B');
       this.labels.add('C');
       this.labels.add('D');

    }

    public String getOptionAt(int index) {
        return this.options[index];
    }

    public void setOptions(String[] options) {
        for(int i=0;i<options.length;++i){
            this.options[i]=options[i];
        }
    }

    public String toString() {
        String description = this.getDescription() + "\n";
        List opt = Arrays.asList(this.options);
        opt.set(3, this.getAnswer());
        Collections.shuffle(opt);
        String s = description  + "\n";
        for(int i =0;i<4;i++){
            s = s + labels.get(i) + ") " + getOptionAt(i) + "\n" ; 
        }
          
         
         return s;
    }
}
















/*class Test extends Question {
    private String[] options = new String[4];
    private final int numOfOptions = 4;
    private ArrayList<Character> labels = new ArrayList();

    public Test() {
       this.labels.add('A');
       this.labels.add('B');
       this.labels.add('C');
       this.labels.add('D');

    }

    public String getOptionAt(int index) {
        return this.options[index];
    }

    public void setOptions(String[] options) {
        System.arraycopy(options, 0, this.options, 0, 3);
    }

    public String toString() {
        String description1 = this.getDescription() + "\n";
        List var2 = Arrays.asList(this.options);
        var2.set(3, this.getAnswer());
        Collections.shuffle(var2);
        int var3 = 1;

        String var5;
        for(Iterator var4 = var2.iterator(); var4.hasNext(); var1 = var1 + this.labels.get(var3 - 1) + ") " + var5 + (var3++ < 4 ? "\n" : "")) {
            var5 = (String)var4.next();
        }

        return var1;
    }
}*/




























/*public class Test extends Question{

	private String[] options;
	private int numOfOptions = 4;
	private ArrayList<Character> labels;

	public Test(){

	}

	public void setOptions(String[] options){
		this.options = options;
	}
	public String getOptionAt(int numOfOptions){
		return options[numOfOptions];
	}
	public String toString(){
		
	}
}*/