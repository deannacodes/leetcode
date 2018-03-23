class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if ( x < 0 ) {
            neg = true;
            x *= -1;
        }
        
        char[] num = ("" + x).toCharArray();
        
        for ( int i = 0 ; i < (num.length*0.5) ; i++ ) {            
            char temp = num[i];        
            num[i] = num[num.length-(i+1)];
            num[num.length-(i+1)] = temp;
        }
        
        int reversed = 0;
        
        try {
            reversed = Integer.parseInt( new String(num) );
        } catch (NumberFormatException ex) {
            
        }
        
        if (neg)
            reversed *= -1;
    
        
        return reversed;
    }
}