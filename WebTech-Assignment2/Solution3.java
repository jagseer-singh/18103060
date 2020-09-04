import java.util.Arrays;

/**
 *
 * @author Jagseer Singh
 */
public class Solution3 {
    
    private static void mergeTwo(String[] arr, int left, int mid, int right){  
        int l = mid - left + 1;  
        int r = right - mid;  

        String[] LeftArray = new String[l];  
        String[] RightArray = new String[r];  

        for (int i=0; i<l; ++i)  
            LeftArray[i] = arr[left + i];  

        for (int j=0; j<r; ++j)  
            RightArray[j] = arr[mid + 1+ j];  

        int i = 0, j = 0;  
        int k = left;  
        
        while (i<l&&j<r)  {  
            if (LeftArray[i].compareTo(RightArray[j]) <= 0){  
                arr[k] = LeftArray[i];  
                i++;
                k++;  
            }else{  
                arr[k] = RightArray[j];  
                j++; 
                k++; 
            }  
        }
        
        while (i<l){  
            arr[k] = LeftArray[i];  
            i++;  
            k++;  
        }  

        while (j<r){  
            arr[k] = RightArray[j];  
            j++;  
            k++;  
        }  
    }  

    public static void sort(String arr[], int left, int right)  
    {  
        if (left<right)  
        {  
            int mid = (left+right)/2;  
            sort(arr, left, mid);  
            sort(arr , mid+1, right);  
            mergeTwo(arr, left, mid, right);  
        }  
    } 
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] arr = {"x", "b", "a", "y","c","z"};
        System.out.println("Unsorted: "+Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println("Sorted: "+Arrays.toString(arr));
    }
    
}
