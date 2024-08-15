package com.practice.problems.hash;
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

class Anagram {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

      public static int anagram(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        int[] ascii = new int[26];
        
        if(ch.length%2!=0){
            return -1;
        }
        for(int i = 0; i<ch.length/2;i++){
            ascii[ch[i]-97] = ascii[ch[i]-97]+1; 
        }
        for(int i = ch.length/2;i<ch.length;i++) {
            ascii[ch[i]-97] = ascii[ch[i]-97]-1; 

        }
        
        for(int i = 0; i<ascii.length;i++) {
            if(ascii[i] != 0)
          {
            count+= Math.abs(ascii[i]);
          }
            
        }
        return count/2;
    }
}

public class AnagramExample {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Anagram.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
