class Solution {
    public String longestPalindrome(String s) {
        
        if (s.isEmpty() || s.length() == 0)
            return "";
        if (s.length() == 1) 
            return s;
        
        String maxPal = "";
        
        for (int i = 0; i < s.length(); i++) {
            
            for (int j = (i + maxPal.length()); j < s.length(); j++) {
                 if (s.charAt(i) == s.charAt(j)) {
                    String test = s.substring(i, j+1);

                    if (isPalindrome(test)) {
                        if (test.length() > maxPal.length())
                            maxPal = test;
                    }
                }
            }
            
        }
        
        return maxPal;
        
    }
    
    public static Boolean isPalindrome(String s) {
        
        int end = s.length() - 1;
        
        for (int i = 0; i < s.length(); i++){
            
            if (s.charAt(i) != s.charAt(end))
                return false;
            
            end--;
            
        }
        
        return true;
        
    }
}