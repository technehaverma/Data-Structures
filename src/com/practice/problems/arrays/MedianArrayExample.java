package com.practice.problems.arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MedianArray {

    /*
     * Complete the 'median_array' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums1
     *  2. INTEGER_ARRAY nums2
     */

    public static String median_array(List<Integer> nums1, List<Integer> nums2) {
    // Write your code here
        List<Integer> res = new ArrayList<>();
        int len1 = nums1.size();
        int len2 = nums2.size();
        int i = 0;
        int j = 0;
        int k = 0;

        while(i<len1 && j<len2){
            if(nums1.get(i)<nums2.get(j)){
                res.add(nums1.get(i));
                i++;
            }else{
                res.add(nums2.get(j));
                j++;
            }
            k++;
            
        }
        while(i<len1){
            res.add(nums1.get(i));
            i++;
            k++;
        }
        while(j<len2){
            res.add(nums2.get(j));
            j++;
            k++;
        }
        
        Double median = Double.NEGATIVE_INFINITY;
         if(k%2!=0){
                median = (double)(res.get((k-1)/2));
           
            }
            
            else{
                if(res.size()>0)
                    median = (double)((res.get(k/2)+res.get((k/2)-1)))/2;

            }
         return median.toString();                         
        }

}

public class MedianArrayExample {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> nums1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> nums2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = MedianArray.median_array(nums1, nums2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
