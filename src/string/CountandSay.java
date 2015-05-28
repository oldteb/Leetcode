package string;

public class CountandSay {
    public String countAndSay(int n) {
        if(n == 0){
            return "";
        }
        String s = "1";
        return help(s,n,1);
    }
    
    String help(String str, int n, int level){
        if(n == level){
            return str;
        }
        else{
            String rst = "";
            while(str.length() != 0){
                char head = str.charAt(0);
                int count = 1;
                while(str.length() >= count+1 && str.charAt(count) == head){
                    count++;
                }
                //System.out.println(count + "," + head);
                rst += Integer.toString(count);
                rst += String.valueOf(head);
                str = str.substring(count);
            }
            return help(rst,n,level+1);
        }
    }
    
    public static void main(String[] argv){
    	CountandSay cs = new CountandSay();
    	System.out.println(cs.countAndSay(15));
    }
}
