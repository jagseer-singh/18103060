
import java.util.HashSet;
import java.util.Scanner;
/**
 *
 * @author Jagseer Singh
 */

class ArraySet {
    public static ArraySet UNIVERSAL_SET = new ArraySet(new int[]{0,1,2,3,4,5,6,7,8,9,10});
    boolean[] set;
    
    public ArraySet() {
        this.set = new boolean[11];
    }
    
    public ArraySet(int[] set) {
        this.set = new boolean[11];
        for(int i: set)
        {
            if(i>10)
            {
                System.out.println(i+" is out of universal set, ignoring this");
            }
            else
            {
                if(this.set[i]==false)
                    this.set[i] = true;
            }
        }
    }
    

    public void union(ArraySet bSet){
        ArraySet C=new ArraySet();
        for(int i=0; i<11; ++i){
            if(this.set[i])
                C.set[i] = true;
        }
        for(int i=0;i<11;i++)
        {
            if(bSet.set[i])
            {
                C.set[i]=true;
            }
        }
        System.out.println("UNION:"+C.toString());
    }
    
    
    
    public void intersetion(ArraySet bSet){
        ArraySet C=new ArraySet();
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<11;j++)
            {
                if(this.set[i] && bSet.set[j] && i==j)
                {
                    C.set[i]=true;
                }
            }
        }
        System.out.println("INTERSECTION:"+C.toString());
    }
    
    public void complement(){
        for(int i=0; i<11; ++i){
            if(this.set[i])
            {
                this.set[i]=false;
            }
            else
            {
                this.set[i]=true;
            }
        }
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append("{ ");
        
        for(int i=0; i<11; ++i)
            if(this.set[i]){
                s.append(i);
                s.append(", ");
            }
        
        if(s.length() > 3 && s.substring(s.length()-2).equals(", "))
            s.delete(s.length()-2, s.length());
        
        s.append(" }");
        
        String ans=s.toString();
        return ans;
    }
    
}

class librarySet{
    public static librarySet UNIVERSAL_SET =  new librarySet(new int[]{0,1,2,3,4,5,6,7,8,9,10});
    HashSet<Integer> set;

    public librarySet() {
        set = new HashSet<>(11);
    }

    public librarySet(int[] set) {
        if(set == null || set.length < 1)
            throw new IllegalArgumentException("Set can't be null or of zero length");
        
        this.set = new HashSet<>(11);
        for(int i: set)
        {
            if(i>10)
            {
                System.out.println(i+" is out of Universal Set,IGNORING THIS");
            }
            else
            {
                this.set.add(i);
            }
        }
    }
    
    public void union(librarySet bSet){
        System.out.print("UNION: { ");
        for(int i=0;i<11;i++)
        {
            if(this.set.contains(i) || bSet.set.contains(i))
            {
                System.out.print(i+" ");
            }
        }
        System.out.print("}\n");
    }
    
    public void intersetion(librarySet bSet){
        System.out.print("INTERSECTION: { ");
        for(int i=0;i<11;i++)
        {
            if(this.set.contains(i) && bSet.set.contains(i))
            {
                System.out.print(i+" ");
            }
        }
        System.out.print("}\n");
    }
    
    public void complement(){
        System.out.print("{ ");
        for(int i=0; i<11; ++i){
            if(!this.set.contains(i))
            {
                System.out.print(i+" ");
            }
        }
        System.out.println("}");
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append("{ ");
        
        for(int i=0; i<11; ++i)
            if(this.set.contains(i)){
                s.append(i); s.append(" ");
            }
        
        
        s.append("}");
        
        return s.toString();
    }    
}

public class Solution5 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of elements in SET A:");
        int sizeA = sc.nextInt();
        int[] arr= new int[sizeA];
        System.out.print("Enter the Elements:");
        for(int i=0;i<sizeA;i++)
        {
            arr[i]=sc.nextInt();
        }
        

        System.out.print("Enter number of elements in SET B:");
        int sizeB = sc.nextInt();
        int[] arr_2= new int[sizeB];
        System.out.print("Enter the Elements:");
        for(int i=0;i<sizeB;i++)
        {
            arr_2[i]=sc.nextInt();
        }

        
        long startTime=System.nanoTime();
        System.out.println("Using only Array");
        
        ArraySet A=new ArraySet(arr);
        System.out.println("Set A: " + A.toString());
        ArraySet B=new ArraySet(arr_2);
        System.out.println("Set B: " + B.toString());
        
        A.union(B);
        A.intersetion(B);
        A.complement();
        System.out.println("Set A after complementing: "+A.toString());
        B.complement();
        System.out.println("Set B after complementing: "+B.toString());

        

        System.out.println("\nUsing HashSet");
        librarySet setA=new librarySet(arr);
        System.out.println("Set A: "+setA.toString());
        librarySet setB=new librarySet(arr_2);
        System.out.println("Set B: "+setB.toString());

        long midTime=System.nanoTime();
        
        setA.union(setB);
        setA.intersetion(setB);
        System.out.print("Set A after complementing:");
        setA.complement();
        System.out.print("Set B after complementing:");
        setB.complement();
        
        long endTime=System.nanoTime();
        System.out.println("Execution Time using Arrays in NanoSeconds: " + (midTime-startTime));
        System.out.println("Execution Time using Hashset in NanoSeconds:"+(endTime-midTime));
        System.out.println("Space complexity of Array solution is O(size of universal set)");
        System.out.println("Space complexity of Hashset solution is O(size of given set)\nIf universal set is too large, Array solution will use much more space.");
        
    }
    
}
