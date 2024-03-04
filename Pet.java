package application;

//Pet Class
public abstract class Pet implements LivingBeing {
	public String name;
	public String nickName;
	public String species;
	public String color;
	public double weight;
	public double height;
	public int age_month; // <24month
	public int age; //》24month
	public String city;
	public String zipcode;
	public String defaultPlace;


	public String father;
	public String mother;
	public String daughter;
	public String sun;
	
	public enum hairy  {LONG,MEDIUM,SHORT,UNKNOWN};
	public enum hairLoss {NOLOSS,MILD,MOERRATE,SEVERE,UNKNOWN};
	public enum shape {BIG,MEDIUM,SMALL,UNKNOWN};
	public enum gender {MALE,FEMALE,UNKNOWN};
	public enum PetHealthStatus {EXCELLENT, GOOD, FAIR, POOR, CRITICAL,UNKNOWN };
	 
	public abstract void sound();
	public abstract void breathe();
	public abstract void eat();
	public abstract void reproduce();
}

