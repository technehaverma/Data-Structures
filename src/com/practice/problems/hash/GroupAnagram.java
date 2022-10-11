package com.practice.problems.hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

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

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());
		List<String> res = new ArrayList<>();
		IntStream.range(0, q).forEach(qItr -> {
			try {
				String s = bufferedReader.readLine();
				res.add(s);

			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		List<List<String>> op = anagram(res);

		bufferedReader.close();
		bufferedWriter.close();
	}

}
