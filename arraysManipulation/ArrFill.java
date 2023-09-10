import java.util.Arrays;

class ArrFill {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        System.out.println("\nFilling the array with value 25 ::");
        Arrays.fill(arr, 25);
        System.out.println(Arrays.toString(arr));
        System.out.println("\nFilling the array from index 3 to 6 with value 63 ::");
        Arrays.fill(arr, 3, 6, 63);
        System.out.println(Arrays.toString(arr));
        
        
    }
}


// [1, 2, 3, 4, 5, 6, 7, 8, 9]
// Filling the array with value 25 ::
// [25, 25, 25, 25, 25, 25, 25, 25, 25]

// Filling the array from index 3 to 6 with value 63 ::
// [25, 25, 25, 63, 63, 63, 25, 25, 25]
