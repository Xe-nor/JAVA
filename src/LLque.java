public class LLque {
     Node head;
     Node tail;

    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    public void addNode(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next=newNode;
            tail=tail.next;
        }
    }
    public void printList(){
        if (head == null){
            System.out.println("EMpty");
        }
        Node currnode = head;
        while (currnode!= null){
            System.out.println(currnode.data);
            currnode = currnode.next;
        }
    }
    public void middle(){
        Node slow = head;
        Node fast = head;
        while (fast != null&& fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        System.out.println(slow.data);
    }


    public static void main(String[] args) {
       LLque list = new LLque();
       list.addNode(1);
       list.addNode(2);
       list.addNode(3);
       list.addNode(4);
       list.addNode(5);
       list.printList();
        System.out.println();
       list.middle();


    }
}
