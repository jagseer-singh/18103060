import java.util.Arrays;
/**
 *
 * @author Jagseer Singh
 */
public class Solution2 {
    
    public static void counting_sort(int[] arr){
        int[] count = new int[21];
        
        for(int i: arr)
            count[i]++;
        
        int ind = 0;
        for(int i=0; i<21; ++i){
            int temp_count=count[i];
            int j=0;
            while(j<temp_count)
            {
                j++;
                arr[ind]=i;
                ind++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,7,2,4,6,1,0};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        counting_sort(arr);
        System.out.println("After Sorting Array: " + Arrays.toString(arr));
    }
}
