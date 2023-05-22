import java.util.*;
public class array_list {
    public static void main(String[] args) {
        // Array list is non contigous and stores only objects
        // insert o(n)
        // search o(1)

        ArrayList<Integer> list = new ArrayList<>();

        //Add elements
        list.add(0);
        list.add(22);
        list.add(3);
        System.out.println("Original ArrayList: "+list);

        //add elements in between
        list.add(1,5);
        System.out.println("Add elements in between at index 1: "+list);

        //get elements
        System.out.println("Get element in index 2: "+list.get(2));

        //set elements i.e modify existing element
        list.set(1,4);
        System.out.println("set existing elements in index 1 as 4: "+list);

        //delete element
        list.remove(1);
        System.out.println("remove element at index 1: "+list);

        //size
        System.out.println("Size of arraylist: "+ list.size());

        //loop
        for (int i=0;i<list.size();i++) {
            System.out.println("element at index " + i + " is " + list.get(i));
        }

        //Sorting in ascending order
        Collections.sort(list); //doesnt work on arrays

    }

}
