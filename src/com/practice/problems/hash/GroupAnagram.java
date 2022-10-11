package com.practice.problems.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

	private static List<List<String>> anagram(List<String> res) {
		HashMap<String,List<String>> map=new HashMap<>();

        for(int i=0;i<res.size();i++){
            String s1=res.get(i);
            char[] arr=s1.toCharArray();
            Arrays.sort(arr);
            String str=new String(arr);

            if(map.containsKey(str)){
                map.get(str).add(s1);
            }else{
                map.put(str,new ArrayList<>());
                map.get(str).add(s1);
            }
        }
        return new ArrayList<>(map.values());
 
	}

	private static List<List<String>> anagramWithOutSort(List<String> res) {
		HashMap<String,List<String>> map=new HashMap<>();

        for(int i=0;i<res.size();i++){
            String s1=res.get(i);
            int[] arr1 = new int[26];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j< s1.length();j++) {
            	arr1[s1.charAt(j)-97] = arr1[s1.charAt(j)-97]+1; 
            	
            }
            for(int j = 0; j<26;j++) {
            	if(arr1[j]!=0) {
            		sb.append(Character.toChars(j+97));
            	}
            }
            
            String str=sb.toString();

            if(map.containsKey(str)){
                map.get(str).add(s1);
            }else{
                map.put(str,new ArrayList<>());
                map.get(str).add(s1);
            }
        }
        return new ArrayList<>(map.values());
 
	}

	/*
	 * public static void main(String[] args) throws IOException { BufferedReader
	 * bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	 * BufferedWriter bufferedWriter = new BufferedWriter(new
	 * FileWriter(System.getenv("OUTPUT_PATH")));
	 * 
	 * int q = Integer.parseInt(bufferedReader.readLine().trim()); List<String> res
	 * = new ArrayList<>(); IntStream.range(0, q).forEach(qItr -> { try { String s =
	 * bufferedReader.readLine(); res.add(s);
	 * 
	 * } catch (IOException ex) { throw new RuntimeException(ex); } });
	 * List<List<String>> op = anagramWithOutSort(res);
	 * 
	 * bufferedReader.close(); bufferedWriter.close(); }
	 */
	 public static void main(String[] args) {
		 List<String> res = new ArrayList<>(Arrays.asList("eat","tea","tan","ate","nat","bat"));
	        List<List<String>> res1 = anagramWithOutSort(res);
	        System.out.println(res1);
	    }

}
