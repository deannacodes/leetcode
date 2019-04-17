class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //We can take advantage of this sorted array to save time/space!
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums.length < 3 || nums[0] + nums[1] + nums[2] > 0 || nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < 0)
            return res;
        
        for (int i = 0; i < nums.length - 2; i++ ) {
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k) {
                
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum > 0) 
                    k--;
                else if (sum < 0)
                    j++;
                else {
                    List<Integer> winner = new ArrayList<>(Arrays.asList(new Integer[] {nums[i], nums[j], nums[k]}));
                    res.add(winner);
                    
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) 
                        j++;
                    while (k > j && nums[k] == nums[k+1]) 
                        k--;
                }
                    
            }
            
           while (i < nums.length - 1 && nums[i] == nums[i+1]) 
                i++;
            
        }
        
        return res;
         
    }
    
    
}