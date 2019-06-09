class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        var res = ArrayList<Int>()
        
        for (i in left..right) {
            
            var n = i
            while (n > 0) {
                
                val digit = n % 10
                if (digit == 0 || i % digit != 0) 
                    n = -1
                else 
                    n /= 10
            }
            
            if (n != -1)
                res.add(i)
            
        }
        
        return res
        
    }
}