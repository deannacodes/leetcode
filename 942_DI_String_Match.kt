class Solution {
    fun diStringMatch(S: String): IntArray {
        
        var start = 0
        var end = S.length
        var res = IntArray(S.length + 1)
        
        for ((index, ch) in S.withIndex()) {
            
            res[index] = if (ch == 'D') end-- else start++
            
        }
        
        res[S.length] = start
        
        return res;
        
    }
}