package com.practice.problems.linklist;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;


class SegregateLLEvenOdd {

    /*
     * Complete the 'SegregateLLEvenOdd' function below.
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
     */
   
    public static SinglyLinkedListNode SegregateLLEvenOdd(SinglyLinkedListNode start) {
        SinglyLinkedListNode curr = start;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode newList = null;
        SinglyLinkedListNode odd = start;
        int count = 0;
        while(curr!=null){
            SinglyLinkedListNode temp = curr;
           
            if(curr.data%2==0){
                if(count ==0){
                    newList = temp;
                    newList.data = temp.data;
                    newList.next = null; 
                    start = curr;
                    odd = newList;
                }
                if(newList==null){
                    newList = new SinglyLinkedListNode(temp.data);
               
                    odd = newList;
                }else{
                    SinglyLinkedListNode no = new SinglyLinkedListNode(temp.data);
                    no.next = null;
                    newList.next = no;
                   
                    newList = newList.next;
                }
                curr = curr.next;
                prev.next = curr;
            }else {
                prev = curr;
                curr = curr.next;
            }
            count++;
         
        }
        if(start!=null){
            newList.next = start;
        }

        return odd;
    }
}
public class SegregateLLEvenOddList {
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

        SinglyLinkedListNode result = SegregateLLEvenOdd.SegregateLLEvenOdd(start.head);

        SinglyLinkedListPrintHelper.printList(result, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
