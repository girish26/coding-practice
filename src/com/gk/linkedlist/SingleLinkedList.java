package com.gk.linkedlist;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.*;

public class SingleLinkedList {
    static class Node{
        int id;
        String subject;
        int mark;
        Node next;
        Node(int id, int mark, String sub){
            this.id= id;
            this.mark = mark;
            this.subject = sub;
        }
    }

    /***
     *
     * @param head
     * @param
     * @return head
     *
     * insert node at the end of the list
     */
    static Node insertNode(Node head, int id, int mark, String sub){
        if(head == null){
            head = new Node(id, mark, sub);
        }else {
            Node temp = head;
            while (temp.next !=null){
                temp = temp.next;
            }

            temp.next = new Node(id, mark, sub);
        }
        return head;
    }

    /**
     *
     * @param head
     * prints the linked list
     */
    static  void printLinedList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println("id="+temp.id + " marks="+temp.mark+" sub="+temp.subject);
            temp = temp.next;
        }
    }

    /**
     *
     * @param head
     * @param data
     * @return head
     *
     * delets particular node
     */
//    static Node deleteNode(Node head, int data ){
//        Node temp = head;
//        Node current = head;
//        if(head == null) return head;
//        if (temp.data == data) return temp.next;
//        current = temp;
//        temp = temp.next;
//        while (temp!= null){
//            if (temp.data == data){
//                Node next = temp.next;
//                current.next = next;
//                break;
//            }
//            current = temp;
//            temp = temp.next;
//        }
//        return head;
//    }

    /**
     *
     * @param head
     * @return size of linked list
     *
     */
    static  Integer getSize(Node head){
        Integer size = 0;
        Node temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    static Boolean checkSubjectExist(String subject, HashMap<String, Student> map){
        boolean resultFlag = false;
        for (Map.Entry<String,Student> entry : map.entrySet()){
            if(subject.equals(entry.getValue().subject))
                resultFlag = true;
        }
        return resultFlag;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(4);
        list.add(5);
        list.add(8);
        list.add(10);
        list.add(15);
        list.add(19);
        Node head = null;
        System.out.println(list);
        SingleLinkedList linkedList = new SingleLinkedList();
//        for (int index=0; index<list.size(); index++){
//           head = insertNode(head, list.get(index));
//        }
//        System.out.println("created linklist size and list is: "+ getSize(head));
//        printLinedList(head);
//        head = deleteNode(head, 8);
//        System.out.println("After deleting node size and list is: "+getSize(head));
//        printLinedList(head);

        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\input.txt")));
            HashMap<String, HashMap<Integer, Integer>> hashMap = new HashMap<>();
            HashMap<String, Student> innerMap = new HashMap<>();

            while(in.hasNextLine()) {
                String inputLine = in.nextLine();
                String[] tempLine = inputLine.split("\\|");
                int studentId = Integer.parseInt(tempLine[0]);
                String subject = tempLine[1];
                int marks = Integer.parseInt(tempLine[2]);
                if(innerMap.containsKey(subject)){
                    if(marks > innerMap.get(subject).marks){
                        innerMap.put(subject, new Student(studentId, marks, subject));
                    }
                }else{
                    innerMap.put(subject, new Student(studentId, marks, subject));
                }
            }
            for (Map.Entry<String,Student> entry : innerMap.entrySet()){
                System.out.println(""+entry.getValue().subject + "=>"+entry.getValue().marks);
            }
            System.out.println(innerMap);;
          //  printLinedList(head);
//            Map<String,Integer> retVal = processData(inputData);
//            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
//            for(Map.Entry<String,Integer> e: retVal.entrySet())
//                output.println(e.getKey() + ": " + e.getValue());
//            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }


}
