class LongestPalindromSubstringDP {
    
    public static void printSubstring(String str, int low, int high) {
        System.out.println(str.substring(low, high+1));
        
    } 
    
    public static int longestPalSubstr(String str) {
        
        int maxLength = 1;
        int len = str.length();
        int start = 0;
        boolean sol[][] = new boolean[len][len];
        for(int i=0; i<len;i++) {
            sol[i][i] = true;
        }
        
        for(int i=0; i<len-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                sol[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        for(int k=3; k<=len; k++){
            for(int i=0; i<=len-k; i++)
            {
                int j = i+k-1;
                if(sol[i+1][j-1] && str.charAt(i) == str.charAt(j)){
                    sol[i][j] = true;
                    if(k > maxLength){
                        maxLength = k;
                        start = i;
                    }
                }
            }
            
        }
        System.out.println("the longest substring palindrom is ");
        printSubstring(str, start, start+maxLength-1);
        return maxLength;
    }
    public static void main(String[] args)
    {
        String str = "programmingaaaaatenet";
        System.out.println("Length is: " + longestPalSubstr(str));
    }
}
