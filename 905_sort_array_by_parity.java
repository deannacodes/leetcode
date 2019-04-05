class Solution {
    public int[] sortArrayByParity(int[] A) {        
        
        int[] res = new int[A.length];
        int even = 0;
        int odd = A.length - 1;
        
        for (int i : A) {
            
            if (i % 2 == 0)
                res[even++] = i;
            else 
                res[odd--] = i;
            
        }
        
        return res;
        
        
    }
}