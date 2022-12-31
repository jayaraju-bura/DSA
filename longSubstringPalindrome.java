// Longest Substring Palindrome

class Solution {
    static int maxLength;
    static String longestPalindrome;
    public static void expand(String str, int left, int right) {
        while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        
        if ((right - left -1) > maxLength ) {
            maxLength = right - left - 1;
            longestPalindrome = str.substring(left+1, right);
        }
        
        
    }
    public static int getLongestPalindromeSubString(String str) {
        maxLength = 1;
        if (str.length() <= 1) {
            longestPalindrome = str; 
            System.out.println("longest palindrome is " + longestPalindrome);
            return maxLength;     
        }
        for(int i=0; i < str.length(); i++) {
            
            expand(str, i, i);
            expand(str, i, i+1);
            
        }
        
        System.out.println("Longest Substring Palindrome is " + longestPalindrome);
        return maxLength;
    }
    public static void main(String[] args) {
        String str = "heistprofradarrans";
        System.out.println("The length of longest substring palindrome is " + getLongestPalindromeSubString(str));
    }
}


// Longest Substring Palindrome is radar
// The length of longest substring palindrome is 5
