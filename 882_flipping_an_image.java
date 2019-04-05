class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        for (int i = 0; i < A.length; i++) {
            
            int end = A[0].length - 1;
            int compLength = A[0].length/2;
            if (A.length % 2 != 0)
                compLength++;
            
            
            for (int j = 0; j < compLength; j++) {
                
                int temp = A[i][end];
                A[i][end--] = opposite(A[i][j]);
                A[i][j] = opposite(temp);
                    
            }    
            
        }
        
        return A;
        
    }
    
    
    
    
    
    public static int opposite(int a) {
        
        if (a == 1) 
            return 0;
        else 
            return 1;
        
    }
}