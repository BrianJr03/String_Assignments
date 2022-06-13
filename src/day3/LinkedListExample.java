package day3;

import java.util.Scanner;
class LinkedList {
    private Node first, last;

    static class Node {
        private final int data;
        private Node next;

        public Node(int d) {
            data = d;
        }
    }

    public void add(int d) {
        Node node = new Node(d);

        if(first == null) {   // this means that linked list is empty
            first = node;
            last = first;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void showListData() {
        System.out.println("Linked list is: ");
        for(Node temp = first; temp!= null; temp = temp.next) {
            System.out.println(temp.data);
        }
    }


}

class LinkedListDemo {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.println("How many numbers: ");
        int n = sin.nextInt();

        System.out.println("Enter "+n+" numbers: ");
        for(int i=0;i<n;i++) {
            int d = sin.nextInt();

            list.add(d);
        }

        list.showListData();
    }
}