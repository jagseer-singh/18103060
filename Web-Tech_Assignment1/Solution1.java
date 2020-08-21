
import java.util.Scanner;

/** @author Jagseer Singh
 */

public class Solution1 {
    
    static public boolean checkZero(int[] arr){
        for(int i: arr)
            if(i != 0)
                return false;
        return true;
    }
    
    static public int countOcc(String str, String subStr){
        if(str == null || subStr == null || str.length() < 1 || subStr.length() < 1)
            return 0;

        if(subStr.length() > str.length())
            return 0;
        
        int[] hash = new int[26];
        int length = subStr.length(), occ = 0;
   
        for(char c: subStr.toCharArray())
            hash[c - 'a']++;
        for(char c: str.substring(0, length).toCharArray())
            hash[c - 'a']--;
        
        occ += (checkZero(hash))? 1: 0;
        
        for(int i=length; i<str.length(); ++i){
            
            hash[str.charAt(i) - 'a']--;
            
            hash[str.charAt(i-length) - 'a']++;
            
            occ += (checkZero(hash))? 1: 0;
        }
        
        return occ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Count the sub-string in a string");
        System.out.print("Enter String Lower-Case Alphabets:");
        String str = sc.nextLine();
        System.out.println("Enter sub-string:");
        String substr = sc.nextLine();
        System.out.print("Occurences: ");
        System.out.println(countOcc(str.toLowerCase(), substr.toLowerCase()));   
    } 
}
