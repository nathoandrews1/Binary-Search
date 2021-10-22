package projectca2;
import java.util.*;

/**
 *
 * @author Nathan Andrews x19135394
 *
 * PRESS SHIFT + F6 to run specifically the class you are viewing.
 */

public class AppClass {
    public static void main(String[] args){
         //I am copying the exact same lists from the GUI just incase there is any problems or confusion.
        //Search list 5
        MyArrayList list5;
        list5 = new MyArrayList<>();


        fillArrayList(list5, 5);

        System.out.println("The elemnts are "+ list5.toString());
        System.out.println("The size is " + list5.size() + "\n");

        int searchItem = 6;

        list5.runBinarySearch(searchItem, 0, list5.size()-1);
        list5.runLinearSearch(searchItem);

        //Search list 10
        MyArrayList list10;
        list10 = new MyArrayList<>();


        fillArrayList(list10, 10);

        System.out.println("The elemnts are "+ list10.toString());
        System.out.println("The size is " + list10.size() + "\n");

        searchItem = 11;

        list10.runBinarySearch(searchItem, 0, list10.size()-1);
        list10.runLinearSearch(searchItem);


        //Search list 50
        MyArrayList list50;
        list50 = new MyArrayList<>();


        fillArrayList(list50, 50);

        System.out.println("The elemnts are "+ list50.toString());
        System.out.println("The size is " + list50.size() + "\n");

        searchItem = 62;

        list50.runBinarySearch(searchItem, 0, list50.size()-1);
        list50.runLinearSearch(searchItem);
    }

    //Loop method to add numbers to the object which is faster for this purposes as specific values
   //are not neccessarily needed and bonus the collection is already sorted. No need for Collection.sort(list)
  //I really hope this is ok and manual insertion was not neccessary.
    public static void fillArrayList(MyArrayList object, int arraySize)
    {
        for(int i = 0; i <= arraySize-1; i++)
        {
            object.add(i);
        }
    }
}
