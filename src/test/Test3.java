package test;

public class Test3{
	public static void main(String[] args) {
		BindingTest_Sub sub1 = new BindingTest_Sub();
		BindingTest_Base sub2 = new BindingTest_Sub();
		
		sub1.ovrLd(new Integer(1));       //  statement 1
		sub2.ovrLd(new Integer(2));       //  statement 2
	}

}

class BindingTest_Base {
	void ovrLd(Object obj){
		System.out.println("BindingTest_Base ovrLd(obj)");
	}
	void ovrLd(Integer i){
		System.out.println("BindingTest_Base ovrLd(int)");
	}
}

class BindingTest_Sub extends BindingTest_Base{
	void ovrLd(Integer i){
		System.out.println("BindingTest_Sub ovrLd(int)");
	}
//	void ovrLd(Object obj){
//		System.out.println("BindingTest_Sub ovrLd(obj)");
//	}
}






