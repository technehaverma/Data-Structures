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



class AddNumbers {

    /*
     * Complete the 'addNumbers' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST start_one
     *  2. INTEGER_SINGLY_LINKED_LIST start_two
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

    public static SinglyLinkedListNode addNumbers(SinglyLinkedListNode start_one, SinglyLinkedListNode start_two) {
        int carry = 0;
        SinglyLinkedListNode curr1 = start_one;
        SinglyLinkedListNode curr2 = start_two;
        SinglyLinkedListNode res = null;
        SinglyLinkedListNode prev = null; 
        while(curr1!=null && curr2!=null){
            
            int sum = curr1.data+curr2.data+carry;
            int A = sum;
            carry = A/10;
            int newVal = A%10;
            if(res==null){
                res = new SinglyLinkedListNode(newVal);
                prev = res;
            }else{
                SinglyLinkedListNode temp = new SinglyLinkedListNode(newVal);
                res.next = temp;
                res = res.next;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
    return prev;
    }

}

public class AddNumbersLinked {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList start_one = new SinglyLinkedList();

        int start_oneCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, start_oneCount).forEach(i -> {
            try {
                int start_oneItem = Integer.parseInt(bufferedReader.readLine().trim());

                start_one.insertNode(start_oneItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedList start_two = new SinglyLinkedList();

        int start_twoCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, start_twoCount).forEach(i -> {
            try {
                int start_twoItem = Integer.parseInt(bufferedReader.readLine().trim());

                start_two.insertNode(start_twoItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedListNode result = AddNumbers.addNumbers(start_one.head, start_two.head);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
