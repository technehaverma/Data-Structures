package com.ds.practice;
public class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        if(nums.length==2){
            return Math.min(nums[0],nums[1]);
        }else if(nums.length == 1){
            return nums[0];
        }
       int min = findMinBinary(nums,0,nums.length-1);
        return min;
    }
    
    public int findMinBinary(int nums[], int low, int high){
        if (high == low) 
         return nums[low]; 
       
       if ((high == low + 1))
       { 
         if(nums[low] >= nums[high]) 
            return nums[high]; 
       
          return nums[low]; 
       } 
        
        int mid = low + (high-low)/2;
        if(nums[mid]<=nums[mid-1] && nums[mid]<nums[mid+1]){
            return nums[mid];
        }
        if(nums[mid]>nums[low]){
            if(nums[mid]>nums[high])
                return findMinBinary(nums, mid+1,high);
            else
               return  findMinBinary(nums, low, mid-1);
            
        }else if(nums[mid]<nums[low]){  
           return findMinBinary(nums, low, mid-1);
        } 
        return findMinBinary(nums, mid+1, high);
    }
}

// 5 1 2 3 4
// 3 4 5 1 2
// 1 2 3 4 5
