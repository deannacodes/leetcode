class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        ArrayList<Integer> current = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            current.add(nums[i]);        
        ArrayList<Integer> sol = new ArrayList<>();
        
        return builder(res, current, sol);
        
    }

    
    public List<List<Integer>> builder(List<List<Integer>> res, List<Integer> current, List<Integer> sol) {
        
        if (current.size() <= 1) {
            sol.add(current.get(0)); 
            res.add(new ArrayList(sol));
            sol.remove(sol.size() - 1);   
            
        } else {

            for (int i = 0; i < current.size(); i++) {                
                
                List<Integer> currentCopy = new ArrayList<>();
                currentCopy.addAll(current);
                
                sol.add(current.get(i));
                currentCopy.remove(i);  
                
                res = builder(res, currentCopy, sol); 
                
                sol.remove(sol.size() - 1);
                
            }
        }
        
        return res;
        
    }   
           
}