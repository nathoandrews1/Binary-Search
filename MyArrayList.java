/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectca2;

import java.util.*;

/**
 *
 * @author Nathan Andrews x19135394
 * **********************************************************************************************************
 *
 * I will provide notes that will show that not only am I using the methods we have learned in class.
 * But, that I am also showing that I understand the concepts, as I am also reading the documentation and
 * exploring new functionality there, there's really no reason to look elsewhere.
 *
 * **********************************************************************************************************
 */

//Extending the Arraylist Class allows us to call the methods locally.
//a list of methods are available here via the oracle documentation ->
//https://docs.oracle.com/javase/8/docs/api/?java/util/ArrayList.html

public class MyArrayList<ArrayType> extends ArrayList<ArrayType> {

    private int searchAmount = 0;

    //Recurssive binary search method like implemented in class I have chosen the recurssive method as it
   //is more complex and better to learn to create better logical thinking.
  //Binary search relies on the collection being sorted. It will find if the input number is less than
 //or greater than the middle index. If it is higher it splits the stack and searches from the middle to end.
//If it's lower it splits and searches from start to (middle - 1)

    int binarySearch(ArrayType item, int start, int end)
    {
        searchAmount = 0;
        int middle = 0;
        int result;
        middle = (start+end) / 2;

        //This If checks to see if the compared value is the same as the middle.
       //If the middle is the same, result = (result == middle ? true : false); <- This is knows as ternary IF
      //Also Typecasting Comparable below
          if (((Comparable)get(middle)).compareTo((Comparable)item) == 0)
          {
                result = middle;
                searchAmount++;
          }

          //Simple check to make sure the list is not empty, if it is result / return -1 for false
          else if (start == end)
          {
                result = -1;
                searchAmount++;
          }
         else
         {
            //This recalls the method above as is what is expected with recursion, this is searching
            //The first half of the method, we set the new start point to the original start, then we
           //continue to search up until the middle - 1. We have split the list based on input size.
            if (((Comparable)get(middle)).compareTo((Comparable)item) > 0)
            {
                result = binarySearch(item, start, middle - 1);
                searchAmount++;
            }

           //This method is similar to the top except, this changes the start point to middle,
          //then we continue our search to the original end point. We split and are search the higher
         //half of the list of elements. Middle + 1 because we have already checked it.
            else
            {
                result = binarySearch(item, middle + 1, end);
                searchAmount++;
            }
         }
        return result;
    }


    //Example of an un ordered linear search as demonstrated in class.
   //We can use the this.size() because we are extending from the ArrayList class.
    public int linearSearch(ArrayType item)
    {
        searchAmount = 0;
        int i;
        for (i = 0; i < this.size(); i++)
        {
            //We can use the this.get() again because we are extending from the ArrayList class.
           //We TypeCast (Compareable) to convert the the items to use the Comparable<T> interface.
          //This ensures the object is valid for comparison. All objects in java extend Comparable
         //As described below on the documentation and in class ->
        //https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html

            //Comparable will return 0 if TRUE or -1 if FALSE by Default. We also define our own method to
           //do the same with the return value of -1
            if (((Comparable) this.get(i)).compareTo((Comparable) item) == 0)
            {
                //The item was found at the start so the item had searched once
                searchAmount++;
                return 0;
            }
            else
            {
                //This will run when the item is NOT FOUND so +1 to searchAmount
                searchAmount++;
            }
        }
        return -1;
    }

    public int getSearchAmount()
    {
        return this.searchAmount;
    }

    public void runLinearSearch(ArrayType item){
        int pos = linearSearch(item);
        if(pos == 0)
        {
            System.out.println("Linear search item FOUND and it compared a total of " + searchAmount + " times \n");
            System.out.println("Item " + item + " is in the list \n");         }
        else
        {
            System.out.println("Linear search item NOT FOUND and it compared a total of " + searchAmount + " times \n");
            System.out.println("Item " + item + " is NOT in the list \n");
        }
    }

    public void runBinarySearch(ArrayType item, int start, int end)
    {
        int pos;
        pos = binarySearch(item, 0, this.size()-1);
        if(pos == -1)
        {
            System.out.println("Binary search item NOT FOUND and it compared a total of " + searchAmount + " times \n");
            System.out.println("Item " + item + " is NOT in the list \n");
        }
        else
        {
            System.out.println("Binary search item FOUND and it compared a total of " + searchAmount + " times \n");
            System.out.println("Item " + item + " is in the list \n");
        }
    }

    //<-----------------------------------------------------------------------------------------------------------------
    //GUI methods below for return type of String


    //GUI Method for binary search to return as String
    public String runBinarySearchGUI(ArrayType item, int start, int end)
    {
        String text;
        int pos;
        pos = binarySearch(item, 0, this.size()-1);
        if(pos == -1)
        {
            text = ("Binary search item NOT FOUND and it compared a total of " + searchAmount + " times \n");
            text += ("Item " + item + " is NOT in the list \n\n");
            return text;
        }
        else
        {
            text = ("Binary search item FOUND and it compared a total of " + searchAmount + " times \n");
            text += ("Item " + item + " is in the list \n\n");
            return text;
        }
    }
    //Linear search GUI method to return String.
    public String runLinearSearchGUI(ArrayType item){
        String text;
        int pos = linearSearch(item);
        if(pos == 0)
        {
            text = ("Linear search item FOUND and it compared a total of " + searchAmount + " times \n");
            text += ("Item " + item + " is in the list \n\n");
            return text;
        }
        else
        {
            text = ("Linear search item NOT FOUND and it compared a total of " + searchAmount + " times \n");
            text += ("Item " + item + " is NOT in the list \n\n");
            return text;
        }
    }
}
