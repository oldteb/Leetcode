package string;


/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 
 * @author yunhe
 *
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0)  return "";
        StringBuilder sb = new StringBuilder();
        int circle = numRows > 1 ? 2 * numRows - 2 : 1;
        for(int i = 0; i < numRows; i++){
            for(int cur = i; cur < s.length(); cur += circle){
                sb.append(s.charAt(cur));
                if(i != 0 && i != numRows-1 && cur+(numRows-1-i)*2 < s.length()){
                    sb.append(s.charAt(cur+(numRows-1-i)*2));
                }
            }
        }

        return sb.toString();
    }
}
