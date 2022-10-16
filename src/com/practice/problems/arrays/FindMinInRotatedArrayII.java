package com.ds.practice;
public class FindMinInRotatedArrayII {
     public int findMin(int[] nums) {
       
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
       int mid = low+ (high-low)/2;
       if(nums[mid]>nums[high]){
          
           return findMinBinary(nums,mid+1,high);
       } else if(nums[mid]<nums[high]){
            return findMinBinary(nums,low,mid);
       }else{
           return findMinBinary(nums,low,high-1);
       }
        
    }
}
 