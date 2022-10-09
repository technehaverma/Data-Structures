package com.practice.problems.linklist;
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


class RemoveNNodeBackList {

    /*
     * Complete the 'RemoveNNodeBack' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST start
     *  2. INTEGER k
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode removeNNodeBack(SinglyLinkedListNode start, int k) {
        SinglyLinkedListNode curr = start;
        SinglyLinkedListNode end = null;
        SinglyLinkedListNode prev = null;
        int temp = k;
        for(int i = 1;i<k;i++) {
            
            if(curr!=null){
                curr = curr.next;
            }
         
        }
        while(curr!=null){
            if(end ==null){
                end = start;
            }
            else{
                 end = end.next;
                 if(prev ==null){
                    prev = start;
                 }
                 else prev = prev.next;
            }
               
            curr = curr.next;
        }
        if(end!=null){
            prev.next = end.next;
            end.next = null;
            return start;
        }
        return null;

    }

}

public class RemoveNNodeBackLink {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedList start = new SinglyLinkedList();

        int startCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, startCount).forEach(i -> {
            try {
                int startItem = Integer.parseInt(bufferedReader.readLine().trim());

                start.insertNode(startItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedListNode result = RemoveNNodeBack.RemoveNNodeBack(start.head, k);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
