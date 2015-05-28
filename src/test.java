interface TestA { String toString(); }



public class test {
	public static void main(String[] args) {
		Abstest ins = new Abstest();
		ins.kidding();
		
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		if(){
			System.out.println("true");
		}
			System.out.println("false");
	}
	

	
	void overload(String s, int a){
		int b = 1+1;
	}
	
	void overload(int a, String s){
		int b = 1+1;
	}
}


class Abstest{
	public void fun1(){
		int a = 1+2;
	}
	
	public static void kidding(){
		
	}
	
	public String overridefun(){ 
		return "original";
	}
}
