package com.gk.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    /***
     *
     * @param head
     * @param data
     * @return head
     *
     * insert node at the end of the list
     */
    static Node insertNode(Node head, int data){
        if(head == null){
            head = new Node(data);
        }else {
            Node temp = head;
            while (temp.next !=null){
                temp = temp.next;
            }

            temp.next = new Node(data);
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
            System.out.println(temp.data);
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
    static Node deleteNode(Node head, int data ){
        Node temp = head;
        Node current = head;
        if(head == null) return head;
        if (temp.data == data) return temp.next;
        current = temp;
        temp = temp.next;
        while (temp!= null){
            if (temp.data == data){
                Node next = temp.next;
                current.next = next;
                break;
            }
            current = temp;
            temp = temp.next;
        }
        return head;
    }

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
        for (int index=0; index<list.size(); index++){
           head = insertNode(head, list.get(index));
        }
        System.out.println("created linklist size and list is: "+ getSize(head));
        printLinedList(head);
        head = deleteNode(head, 8);
        System.out.println("After deleting node size and list is: "+getSize(head));
        printLinedList(head);
    }
}
