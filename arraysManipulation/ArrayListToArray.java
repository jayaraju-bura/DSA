import java.util.*;

class ArrayListToArray {
    public static void main(String[] args) {
        ArrayList <Integer> arr_lis = new ArrayList<Integer>();
        Random rand_gen = new Random();
        for(int i=0; i<10;i++){
            arr_lis.add(rand_gen.nextInt(100));
        }
        Integer arr[] = new Integer[arr_lis.size()];
        arr = arr_lis.toArray(arr);
        System.out.println("\n Printing the ArrayList filled with Random numbers from 1 to 100 :: " + Arrays.toString(arr));
        
        
    }
}

//  Printing the ArrayList filled with Random numbers from 1 to 100 :: [80, 95, 44, 72, 76, 36, 7, 30, 39, 50]
