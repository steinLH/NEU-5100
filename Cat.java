package application;

public class Cat extends Pet{
	
    public void setCat(Cat cat) {
        this.name = cat.name;
    }
    
    public void setCatBase(String name,String nicknname,String species,String color,
    		double weight,double height,int age,int age_month,
    		String city,String zipcode,String defaultPlace) {
        this.name = name;
    }
    
	public int getAge() {
		return age;
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("cat sound Meow!!!");
		
	}

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reproduce() {
		// TODO Auto-generated method stub
		
	} 

}
