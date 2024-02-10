import java.util.Arrays; 
class BreakStringIntoLines {
    
    public static boolean canBeBroken(int maxCharPerLine, String text) {
        //int len = splitText(text).length;
        StringBuffer out = new StringBuffer();
        int remainingCharPerLine = maxCharPerLine;
        for (String str : splitText(text)) {
            if (str.length() > maxCharPerLine) {
                return false;
            }
            if (str.length() <= remainingCharPerLine) {
                out.append(str);
                remainingCharPerLine -= str.length();
            }
            else {
                out.append("\n");
                out.append(str);
                remainingCharPerLine = maxCharPerLine - str.length();
            }
            
            out.append(" ");
            remainingCharPerLine -= 1;
        }
        System.out.println("Result :: " + out.toString());
        return true;
    }
    
    public static String[] splitText(String text) {
        String[] stringArray = new String[100];
        int stringArrayIndex = 0;
        StringBuffer temp = new StringBuffer();
        for (int i=0; i < text.length(); i++){
            //char chr = text.charAt(i);
            if ( text.charAt(i) == ' ') {
                stringArray[stringArrayIndex] = temp.toString();
                stringArrayIndex ++;
                temp.setLength(0);
            }
            else{
                temp.append(text.charAt(i));
            }
        }
        stringArray[stringArrayIndex] = temp.toString();
        String[] tempArray = new String[stringArrayIndex + 1];
        for(int i = 0; i <= stringArrayIndex; i++) {
            tempArray[i] = stringArray[i];
        }
        return tempArray;
    }
    public static void main(String[] args) {
        System.out.println("Running the test :: ");
        String text = "The quick brown fox jumps over the lazy dog";
        // System.out.println("print the array of strings after splitting the original text :: " + Arrays.toString(splitText(text)));
        if (canBeBroken(9, text)) {
            System.out.print("Text can be broken into multiple strings, where lenght of the each string is not exceeding 9");
        }
        
    }
}

// Running the test :: 
// Result :: The quick 
// brown fox 
// jumps 
// over the 
// lazy dog 
// Text can be broken into multiple strings, where lenght of the each string is not exceeding 9
