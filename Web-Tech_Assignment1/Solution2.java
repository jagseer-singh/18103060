
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jagseer Singh
 */
public class Solution2 {
    
    static public String replaceWords(String paragraph, String[] words){
        if(paragraph == null || paragraph.length() < 1)
            return null;
        if(words == null || words.length < 1)
            return paragraph;
        
        StringBuilder substitute;
        for(String word: words){
            substitute = new StringBuilder();
            substitute.append(word.charAt(0));
            for(int i=0; i<word.length()-1; ++i)
                substitute.append('*');
            word="\\b"+word+"\\b"; // To change those specific words.. For eg. if "abc" has to be replace and our string 
                                  // contains "abcd abc", it should only replace "abc" not "abcd";
            paragraph = paragraph.replaceAll(word, substitute.toString());
        }
        
        return paragraph;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Replace Word");
        System.out.println("Enter paragraph(Single Line):");
        String paragraph = sc.nextLine();
        System.out.print("Enter no. of words:");
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        System.out.println("Enter words: ");
        for(int i=0; i<n; ++i){
            words[i] = sc.nextLine();
        }

        System.out.println(replaceWords(paragraph, words));
    }
    
}
