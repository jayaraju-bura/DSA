import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

class Box{
    int length, width, height;
    private Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public static Box of(int length, int width, int height) {
        return new Box(length, width, height);
    }
    
}
class Main {
    public static List<Box> createAllRotations(List<Box> boxes) {
        
        List<Box> rotations = new ArrayList<Box>();
        for(int i=0 ; i<boxes.size(); i++) {
            rotations.add(boxes.get(i));
            rotations.add(Box.of(Math.max(boxes.get(i).length, boxes.get(i).height), Math.min(boxes.get(i).height, boxes.get(i).length), boxes.get(i).width));
            rotations.add(Box.of(Math.max(boxes.get(i).width, boxes.get(i).height), Math.min(boxes.get(i).height, boxes.get(i).width), boxes.get(i).length));
        }
        return rotations;
        
    }
    public static int findMaxHeight(List<Box> boxes) {
        if (boxes == null && boxes.size() == 0) {
            return 0;
        }
        List<Box> rotations = createAllRotations(boxes);
        Collections.sort(rotations, (x, y) -> (y.length*y.width - x.width*x.length));
        int[] max_height = new int[rotations.size()];
        for (int i=0; i<rotations.size(); i++) {
            for(int j=0; j<i; j++) {
                if (rotations.get(i).length < rotations.get(j).length && rotations.get(i).width < rotations.get(j).width) {
                    max_height[i] = Math.max(max_height[i], max_height[j]);
                }
                }
                max_height[i] += rotations.get(i).height;
                
        }
        
        return Arrays.stream(max_height).max().getAsInt();
    }
    public static void main(String[] args) {
        System.out.println("Hello world");
        List<Box> boxes  = Arrays.asList(Box.of(4, 2, 5), Box.of(3, 1, 6), Box.of(3, 2, 1), Box.of(6, 3, 8));
        System.out.println("The maximun height possible is " + findMaxHeight(boxes));
    }
}
