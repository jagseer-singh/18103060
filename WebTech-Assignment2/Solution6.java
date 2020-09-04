import java.util.Scanner;
public class Solution6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.print("Hailstone sequence: " + num);
        int steps = 0;
        while(num!=1 && steps<Integer.MAX_VALUE && num<Integer.MAX_VALUE && num>0){
            if(num%2==0){
                num=num/2;
            }
            else{
                num=num*3;
                num++;
            }
            System.out.print(" "+num);
            steps++;
        }
        if(num==1){
            System.out.println("\nNo of steps: "+steps);
        }
        else if(num==Integer.MAX_VALUE || num<0){
            System.out.println("\nOverflow");
        }
        else{
            System.out.println("\nReached Max Steps");
        }
    }
}