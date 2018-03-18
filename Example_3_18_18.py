# Code snippet by Deanna Streffer 
# 
# Given an array of integers, return indices of the two numbers such that they add up to a specific target.
#
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
#
# Example:
# Given nums = [2, 7, 11, 15], target = 9,
#
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].


class Solution(object):
    def twoSum(self, nums, target):
        answer = [0,0]
        for index in range(len(nums)):
            search = target - nums[index]
            
            for index2 in range(index+1,len(nums)):
                if nums[index2] == search :
                    answer[0] = index2
                    answer[1] = index
                    
        return answer
                    
        
