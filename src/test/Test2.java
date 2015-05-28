package test;

public class Test2 {
	public static void main(String[] args) {
		Grandpa g = new Grandpa();
		Father f = new Father();
		if(Grandpa.d == Father.d)  System.out.println(1);
		Father.printClass();
		
	}
}

class Grandpa{
	static int d;
	protected static void printClass(){
		System.out.println("this is a grandpa.");
	}
}


class Father extends Grandpa{
	
	
	protected static void printClass(){
		System.out.println("this is a Father.");
	}
}


