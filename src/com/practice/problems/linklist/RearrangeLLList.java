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


class RearrangeLL {

    /*
     * Complete the 'RearrangeLL' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST start as parameter.
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

    public static SinglyLinkedListNode rearrangeLL(SinglyLinkedListNode start) {
                SinglyLinkedListNode slowPtr = start;
        SinglyLinkedListNode fastPtr = start;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        fastPtr = start;
        SinglyLinkedListNode second = slowPtr.next;
        slowPtr.next = null;

        SinglyLinkedListNode reverseList = second;
        SinglyLinkedListNode curr = reverseList;
        SinglyLinkedListNode prev = null;

        while (reverseList != null) {
            curr = reverseList.next;
            reverseList.next = prev;
            prev = reverseList;
            reverseList = curr;

        }

        SinglyLinkedListNode third = start;

        while (start != null && prev != null) {

            SinglyLinkedListNode next = third.next;
            SinglyLinkedListNode temp = new SinglyLinkedListNode(prev.data);

            third.next = temp;
            temp.next = next;
            third = third.next;
            prev = prev.next;
            start = start.next;
            third = third.next;

        }
        return fastPtr;
    }

}

public class RearrangeLLList {
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

        SinglyLinkedListNode result = RearrangeLL.rearrangeLL(start.head);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
