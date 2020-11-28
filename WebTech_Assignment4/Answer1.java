import java.util.*;

public class Answer1 {
    static int findChanges(char[][] cropField,int n,int m)
    {
        char [][]tempField=new char[n][m];
        int changes=0;
        tempField[0][0]=cropField[0][0];
        for(int j=1;j<m;j++)
        {
            if(cropField[0][j]==tempField[0][j-1])
            {
                for(int k=0;k<26;k++)
                {
                    if((char)(97+k)!=tempField[0][j-1] && (j==m-1 || (char)(97+k)!=cropField[0][j+1]) && (char)(97+k)!=cropField[1][j])
                    {
                        tempField[0][j]=(char)(97+k);
                        k=26;
                    }
                }
                changes++;
            }
            else
            {
                tempField[0][j]=cropField[0][j];
            }
        }
        for(int i=1;i<n;i++)
        {
            if(cropField[i][0]==tempField[i-1][0])
            {
                for(int k=0;k<26;k++)
                {
                    if((char)(97+k)!=tempField[i-1][0] && (i==n-1 || (char)(97+k)!=cropField[i+1][0]) && (char)(97+k)!=cropField[i][1])
                    {
                        tempField[i][0]=(char)(97+k);
                        k=26;
                    }
                }
                changes++;
            }
            else
            {
                tempField[i][0]=cropField[i][0];
            }   
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(cropField[i][j]==tempField[i-1][j] || cropField[i][j]==tempField[i][j-1])
                {
                    for(int k=0;k<26;k++)
                    {
                        if((char)(97+k)!=tempField[i-1][j] && (char)(97+k)!=tempField[i][j-1] && (i==n-1 || (char)(97+k)!=cropField[i+1][j]) && (j==m-1 || (char)(97+k)!=cropField[i][j+1]))
                        {
                            tempField[i][j]=(char)(97+k);
                            k=26;
                        }
                    }
                    changes++;
                }
                else
                {
                    tempField[i][j]=cropField[i][j];
                }
            }
        }

        /*for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(tempField[i][j]);
            }
        }*/
        return changes;
    }
   public static void main(String[] args)
   {
       Scanner sc=new Scanner(System.in);
       System.out.print("Enter rows:");
       int n=sc.nextInt();
       System.out.print("Enter columns:");
       int m=sc.nextInt();
       char [][]cropField=new char[n][m];
       for(int i=0;i<n;i++)
       {
           System.out.print("Enter row "+i+"(size "+m+"):");
           String rowI=sc.next();
           //System.out.println(rowI);
           for(int j=0;j<m;j++)
           {
                cropField[i][j]=rowI.charAt(j);
           }
       }
       int result=findChanges(cropField,n,m);
       System.out.println("TOTAL CHANGES REQUIRED:"+result);
   } 
}
