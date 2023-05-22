import java.util.*;

public class StackDS {

//Stack using Linked_list
    static class StackLL {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
        public static Node head = null;
        public static void push(int data) {
            Node newNode = new Node(data);

            if(head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static boolean isEmpty() {
            return head == null;
        }

        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            Node top = head;
            head = head.next;
            return top.data;
        }

        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            Node top = head;
            return top.data;
        }
    }
//Stack using Array list
    static class stackarraylist {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size()==0;
        }

        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if (isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek (){
            if (isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    public static  void pushAtBottom(int data, Stack<Integer> s){
        if (s.isEmpty()){
            s.push(data);
            return;
        }
      int top = s.pop();
        pushAtBottom(data,s);
        s.push(top);

    }

    public static void  reverse(Stack<Integer> s){
        if (s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse(s);
        pushAtBottom(top,s);
    }


    public static void main(String args[]) {

        System.out.println("\nSTACK USING LL");
        Stack stackLL = new Stack();
        stackLL.push(1);
        stackLL.push(2);
        stackLL.push(3);
        stackLL.push(4);
        while(!stackLL.isEmpty()) {
            System.out.println(stackLL.peek());
            stackLL.pop();
        }

        System.out.println("\nSTACK USING ARRAYLIST");
        stackarraylist stackarraylist = new stackarraylist();
        stackarraylist.push(1);
        stackarraylist.push(2);
        stackarraylist.push(3);
        while (!stackarraylist.isEmpty()){
            System.out.println(stackarraylist.peek());
            stackarraylist.pop();

        }

        System.out.println("\nSTACK USING COLLECTION");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
//        while (!stack.isEmpty()){
//            System.out.println(stack.peek());
//            stack.pop();
//        }
        pushAtBottom(4,stack);
        reverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }



    }
}