
import java.util.Scanner;

public class Solution4 {
    
    public boolean areAnagrams(Integer a, Integer b){
        if(a == null || b == null)
            return false;
        
        return areAnagrams(String.valueOf(a), String.valueOf(b));
    }
    
    public boolean areAnagrams(String a, String b){
        if(a == null || b == null || a.length() < 1 || b.length() < 1)
            return false;
        
        int[] hash = new int[26];
        
        for(char c: a.toCharArray())
            hash[c - 'a']++;
        
        for(char c: b.toCharArray())
            hash[c - 'a']--;
        
        for(int c: hash)
            if(c != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Check Anagrams \n");
        System.out.println("Enter First String(lowercase alphabets):");
        String a = sc.nextLine();
        System.out.println("Enter Second String(lowercase alphabets):");
        String b = sc.nextLine();
        if((new Solution4()).areAnagrams(a.toLowerCase(), b.toLowerCase()))
        {
            System.out.println("Strings are anagram");
        }
        else
        {
            System.out.println("Strings are NOT anagrams");
        }
    }
}
