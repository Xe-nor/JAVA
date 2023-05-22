import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class queueDS {
    static class queue {
        static int arr[];
        static int rear;
        static int size;

        queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void enqueue(int data) {//o(1)
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public static int dequeue() { //o(n)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];

            }
            rear--;
            return front;
        }

        public static int peek() {//o(n)
            if (isEmpty()) {
                return -1;
            }
            return arr[0];
        }
    }

    static class circularqueue {
        static int arr[];
        static int front;
        static int size;
        static int rear;

        circularqueue(int n) {
            arr = new int[n];
            front = -1;
            rear = -1;
            size = n;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return front == (rear + 1) % size;
        }

        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Full");
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int dequeue() {
            if (isEmpty()) {
                return -1;
            }

            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("empty");
                return -1;
            }
            return arr[front];
        }
    }

    static class llqueue {
        public static class node {
            int data;
            node next;

            node(int data) {
                this.data = data;
                next = null;
            }
        }

        static node head = null;
        static node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void enqueue(int data) {
            node newnode = new node(data);
            if (tail == null) {
                tail = head = newnode;
            }
            tail.next = newnode;
            tail = newnode;
        }

        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            int front = head.data;
            if (head == tail) {
                tail = null;
            }
            head = head.next;
            return front;
        }

        public static int peek() {
            return head.data;
        }


    }

    static class qufromstacks {
        static Stack <Integer> s1 = new Stack<>();
        static Stack <Integer> s2 = new Stack<>();

        public static  boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void enqueue(int data){
          while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
           while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int dequeue(){
            if (isEmpty()){
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if (isEmpty()){
                return -1;
            }
            return s1.peek();
        }

    }




    public static void main(String[] args) {
//        queue newqueue = new queue(5);
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        while (!queue.isEmpty()){
//            System.out.println(queue.peek());
//            queue.dequeue();
//        }
//
//        circularqueue newcircle = new circularqueue(3);
//        newcircle.enqueue(1);
//        newcircle.enqueue(2);
//        newcircle.enqueue(3);
//        while (!newcircle.isEmpty()){
//            System.out.println(newcircle.peek());
//            newcircle.dequeue();
//        }

//      llqueue llqu = new llqueue();
//        llqu.enqueue(1);
//        llqu.enqueue(2);
//        llqu.enqueue(3);
//        while (!llqu.isEmpty()){
//            System.out.println(llqu.peek());
//            llqu.dequeue();
//        }

//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);

//        Queue<Integer>queue = new ArrayDeque<>();

        qufromstacks qs = new qufromstacks();
        qufromstacks.enqueue(1);
        qufromstacks.enqueue(2);
        qufromstacks.enqueue(3);
        while (!qufromstacks.isEmpty()) {
            System.out.println(qufromstacks.peek());
            qufromstacks.dequeue();
        }


    }
}
