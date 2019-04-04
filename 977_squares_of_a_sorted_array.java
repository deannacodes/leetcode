class Solution {
    public int[] sortedSquares(int[] A) {
        
        int start = 0;
        int end = A.length - 1;
        int curr = A.length - 1;
        int[] res = new int[A.length];        
        
        while (curr >= 0) {
            
            int startVal = A[start] * A[start];
            int endVal = A[end] * A[end];
            
            if (startVal > endVal) {
                
                res[curr--] = startVal;
                start++;
                
            } else {
                
                res[curr--] = endVal;
                end--;
                
            }
            
        }
        
        return res;     
        
    }
    
}