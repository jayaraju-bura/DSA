// Maximum difference between two elements in an array
class Solution {
    
    public static int getMaxDiff(int[] arr) {
        
        int length = arr.length;
        int max_diff = Integer.MIN_VALUE;
        int max_so_far = arr[length-1];
        for(int i=length-2; i>=0 ; i--) {
            
            if (arr[i] > max_so_far) {
                max_so_far = arr[i];
                
            }
            else {
                max_diff = Math.max(max_diff, max_so_far - arr[i]);
            }
            
        }
        return max_diff;
        
    }
    public static void main(String args[]) {
        int[] arr = { 6, 7, 9, 12, 1, 8, 5 };
        int max_diff = getMaxDiff(arr);
        System.out.println("The maximum diffrence between two elements is " + max_diff);
    }
}


// The maximum diffrence between two elements is 7
