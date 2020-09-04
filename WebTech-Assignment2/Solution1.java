
import java.util.Scanner;

/**
 *
 * @author Jagseer Singh
 */
public class Solution1 {
    
    public static int compare(String a, String b){
        if(a.isEmpty() && b.isEmpty())
            return 0;
        else if(b.isEmpty())
            return +1;
        else if(a.isEmpty())
            return -1;
        
        
        int shortLength = Math.min(a.length(), b.length());
        
        for(int i=0; i<shortLength; i++)
            if(a.charAt(i) != b.charAt(i))
                return a.charAt(i) - b.charAt(i);
        
        return a.length() - b.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Compare two String Lexicographically");
        System.out.print("Enter String 1: ");
        String x = sc.nextLine();
        System.out.print("Enter String 2: ");
        String y = sc.nextLine();
        int res = compare(x, y);
        System.out.println("String 1 is " + 
                ((res > 0)? "Greater than ": (res < 0)? "Smaller than ": "Equal to ") + 
                "String 2 Lexicographically");
    }
    
}
