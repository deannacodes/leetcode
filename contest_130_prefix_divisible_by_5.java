class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        
        ArrayList<Boolean> answer = new ArrayList<>();
        double rem = 0;
        
        for (int i = 0; i < A.length; i++) {
            
            rem = ((2*rem) + A[i]) % 5;
            
            boolean testMe = false;
            if (rem == 0)
                testMe = true;
            
            answer.add(testMe);
        }
        
        return answer;
        
    }
    
}