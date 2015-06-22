package math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 *
 *  1 -> A
 *  2 -> B
 *  3 -> C
 *  ...
 *  26 -> Z
 *  27 -> AA
 *  28 -> AB 
 * 
 * @author yunhe
 *
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if(n <= 0)  return "";  
        StringBuilder sb = new StringBuilder();
        while(n-- != 0){   // minus 1 in every level
            sb.insert(0,(char)('A'+ n%26));  
            n /= 26;
        }
        
        return sb.toString();
    }
}
