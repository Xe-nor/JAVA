import java.util.*;

public class Linked_list {
   /*
    used for multiple insertion scenarios
    Non contigous
    insert - o(1)
    search - o(n)
    */
   Node head;
   private int size;

   Linked_list(){
       this.size = 0;
   }

   private static class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
   }
    public void addFirst(String data){
        Node newNode =  new Node(data);
        //if no elements exist
        if (head == null){
            head = newNode;
            return;
        }
        //if elements exist
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
       Node newNode =  new Node(data);
       //no elements exist
       if (head==null){
           head= newNode;
           return;
       }
       // elements already exist
       Node currNode = head;
       //loop till we reach the last node
       while (currNode.next != null){
           currNode = currNode.next;
       }
       currNode.next=newNode;
    }

    public void deleteFirst(){
       if (head == null){
           System.out.println("List is empty");
       }
       head=head.next;
    }
    public void deleteLast(){
       //No elements
       if (head == null){
           System.out.println("List is empty");
       }
       // single element
       if (head.next==null){
           head=null;
       }
       //elements exist
       Node currNode= head.next;
       Node prevNode = head;
       while (currNode.next !=null){
           currNode=currNode.next;
           prevNode = prevNode.next;
       }
    }
    public int getSize(){
       return size;
    }
    public void reverseIterate(){
       if (head.next == null|| head == null){
           return;
       }
       Node prevNode = head;
       Node currNode = head.next;
       while(currNode!=null){
           Node nextNode = currNode.next;
           currNode.next = prevNode;
           //update
           prevNode = currNode;
           currNode= nextNode;

       }
       head.next=null;
       head = prevNode;
    }

    public Node reverseRecursive(Node head){
       if (head ==null||head.next==null){
           return head;
       }
      Node newHead =  reverseRecursive(head.next);
      head.next.next = head;
      head.next = null;
      return newHead;
    }

    public void printList(){
       if (head==null){
           System.out.println("List is empty");
       }
       Node currNode =head;
       while (currNode!=null){
           if (currNode.next == null){
               System.out.print(currNode.data + "\n");
           }
           else {

               System.out.print(currNode.data + "->");
               }
           currNode = currNode.next;

       }
    }

   public static void main(String[] args) {
      Linked_list list = new Linked_list();
      list.addFirst("ram");
      list.addFirst("was");
      list.addFirst("stupid");
      list.addLast("last");
      list.printList();

      list.deleteFirst();
      list.deleteLast();
      list.printList();

      list.reverseIterate();
      list.printList();
      list.reverseRecursive(list.head);
      list.printList();

      //using collections
       LinkedList<String>linkedlist = new LinkedList<>();
       linkedlist.addFirst("first");
       linkedlist.addLast("last");
       System.out.println(linkedlist);

       System.out.println(linkedlist.size());

   }

}
