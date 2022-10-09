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


class RotateLL {

    /*
     * Complete the 'RotateLL' function below.
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

    public static SinglyLinkedListNode rotateLL(SinglyLinkedListNode A, int B) {
        SinglyLinkedListNode slowPtr = A;
        SinglyLinkedListNode fastPtr = A;
        SinglyLinkedListNode curr = A;
        
        int temp = B;
        if(A == null || A.next == null){
            return A;
        }
        while(temp>1){
            fastPtr = fastPtr.next;
            temp--;
        }
        while(curr.next!=null){
            curr=curr.next;
        }
        SinglyLinkedListNode next = fastPtr.next;
        fastPtr.next = null;
        curr.next = slowPtr;
        return next;
        
    }

}

public class RotateLLLinked {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode result = RotateLL.rotateLL(start.head, k);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
