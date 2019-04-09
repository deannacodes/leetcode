class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0)
            return 0;
        
        int start = 0;
        int end = 0;
        int max = 1;
        
        HashSet<Character> added = new HashSet<>();
        
        while (end < s.length()) {
            
            while (added.contains(s.charAt(end)) && start <= end) {
                added.remove(s.charAt(start));
                start++;
            } 
            
            added.add(s.charAt(end));          
            max = Math.max(max, (end - start + 1));

            end++;
            
        }
        
        return max;
    }
}