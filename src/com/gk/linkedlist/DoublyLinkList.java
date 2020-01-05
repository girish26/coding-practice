package com.gk.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkList {

    static class Node{
        Node next;
        Node previous;
        Integer data;

        Node(Integer data){
            this.data = data;
        }
    }

    static Node insertNode(Node head, Integer data){
        Node temp = head;
        if (head == null){
            return new Node(data);
        }else{
            while (temp.next != null){
                temp = temp.next;
            }

            temp.next = new Node(data);
            temp.next.previous = temp;

        }
        return head;
    }

    static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+ ( temp.next == null ? "" :"->"));
            temp = temp.next;
        }
        System.out.println();
    }

    static Node deleteNode(Node head, int data){
        Node temp = head;
        Node current = head;
        if (temp.data == data) return temp.next;
        temp = temp.next;
        while (temp != null){
            if (temp.data == data){
                Node next = temp.next;
                current.next = next;
                break;
            }
            current = temp;
            temp = temp.next;
        }

        return  head;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(8);
        list.add(10);
        list.add(15);
        list.add(19);
        Node head = null;
        for (int index=0; index<list.size(); index++){
            head = insertNode(head, list.get(index));
        }
        printList(head);
        head = deleteNode(head, 19);
        printList(head);
    }
}
