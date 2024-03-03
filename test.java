import java.util.ArrayList;

public class test {
	  public static void main(String[] args) {
	    m(new GraduateStudent());
	    m(new Student());
	    m(new Person());
	    m(new Object());
	    Object o = new Student(); //隐式向上兼容
	    m(o);
	    //Student b = (Student)(new Object()); // 强制向下转换，除非确认还原否则不可行
	    //m(b);
	    Student g = (Student)(new GraduateStudent()); // 强制向上转换
	    m(g);
		

	    System.out .println(Integer.parseInt ("33",10));
	    System.out .println(Integer.parseInt ("33",16)); //16进制的33 = 51

	    System.out .println(""+(new Student()).name.toString());

	 
	    Book hobbit = new Book("The Hobbit", 310, 1937);
	    Book iRobot = new Book("I, Robot", 272, 1950);
	    System.out.println(hobbit);
	    System.out.println(iRobot);
	    Planet planet = new Planet(100000.0,300000000.0);
	   

	    System.out .println("Android version:  "+(new Android()).name.toString());
	    System.out .println("Android version:  "+(new Android()).name.toString());
	    System.out .println("Android version:  "+(new Android()).name.toString());
	    System.out .println("Android version:  "+(new Android()).name.toString());
	    System.out .println("Android version:  "+(new Android()).name.toString());
	    System.out .println("Android version:  "+(new Android()).name.toString());
	    System.out .println("Android version:  "+(new Android()).name.toString());
	    System.out .println("Android version:  "+(new Android()).name.toString());

	    System.out .println("" + String.format("%.0f ", 12345.6666));
	    System.out .println("" + String.format("%.1f ", 12345.6666));
	    System.out .println("" + String.format("%.2f ", 12345.6666));

	    
	    ArrayList<String> greetings = new ArrayList<String>();
	    greetings.add("Hello! How are you?");
	    greetings.add("Hi man, what's up!");
	    greetings.add("Yo! How's going?");
	    greetings.add("Hey! How are you doing?");
	    System.out.println("All greetings");
	    System.out.println("");
	    for(String s: greetings){
	    System.out.println(s);	    
	    }
	    System.out.println("Integer ："+ Integer.parseInt("1234456445"));
	    
	    new Faculty2();

	  }
	 
	  public static void m(Object x) {
	    System.out.println(x.toString());
	  }
	}
	 
	class GraduateStudent extends Student {
	}
	 
	class Student extends Person {
	  private String SchoolName;
	  public String toString() {
	    return "Student";
	  }
	  public Student(){
		  super();
		  }
	}
	 
	class Person extends Object {
	  private String Pname;	  
	  public String name = "father";
	  public String toString() {
	    return "Person";
	  }
	}