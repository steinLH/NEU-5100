package application;

//Person Class
public class Person implements LivingBeing {
	public String name;
	public String nickName;
	public String ethnicity;
	public String nativeLanguage;
	public String secondLanguage;
	public String color;
	public double weight;
	public double height;
	private int age; 
	
	public String Profession;
	public String PetNum;
	public enum PetType {DOG,CAT,ALL,NO,UNKNOWN};



	
	public enum shape {BIG,MEDIUM,SMALL,UNKNOWN};
	public enum gender {MALE,FEMALE,OTHER,UNKNOWN};
	public enum PetHealthStatus {EXCELLENT, GOOD, FAIR, POOR, CRITICAL,UNKNOWN };
	 
	public  void sound() {
		
	}
	
	 @Override
	 public void breathe() {
	     // 
	 }
	
	 @Override 
	 public void eat() {
	     //  
	 }
	
	 @Override
	 public void reproduce() {
	     //  
	 }

}

