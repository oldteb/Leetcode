
public class GrayCheck {
	
	public static void main(String[] argv){
		byte b1 = (byte)0xff;
		byte b2 = (byte)0xff;
		System.out.println(check(b1,b2));
		//System.out.println((int)(b2 & 0xffffffff));
	}
	
	static Boolean check(byte b1, byte b2){
		int temp = (b1 ^ b2) & 0xff;
		System.out.println(temp);
		float r1 = (float) (Math.log(temp) / Math.log(2));
		float r2 = (float)((int)r1);
		float r3 = r1-r2; 
		if(r3 == 0){
			return true;
		}
		return false;
	}
	
	static Boolean check2(byte b1, byte b2){
		int x = (b1 ^ b2) & 0xff;
		return (x & (x - 1)) == 0 ? true : false;
	}
	
}
