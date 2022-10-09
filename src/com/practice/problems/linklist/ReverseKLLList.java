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



class ReverseKLL {

    /*
     * Complete the 'ReverseKLL' function below.
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

    public static SinglyLinkedListNode reverseKLL(SinglyLinkedListNode start, int k) {
        SinglyLinkedListNode curr = start;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode prevCurr = start;
        while(curr!=null){
            int count = k;
            SinglyLinkedListNode tail = null;
            while(curr!=null && count>0){
                SinglyLinkedListNode next = curr.next;
                curr.next = tail;
                tail = curr;
                curr = next;
                count--;
            }
            if(prev!=null){
                prev.next = tail;
            }else
                start = tail;
            prev = prevCurr;
            prevCurr = curr;
        }
        return start;
    }

}

public class ReverseKLLList {
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

        SinglyLinkedListNode result = ReverseKLL.reverseKLL(start.head, k);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
