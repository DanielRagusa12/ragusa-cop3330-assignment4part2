package ucf.assignments;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Daniel Ragusa
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;



public class Tasks
{
    //Here a global ArrayList of String will be created to hold current lists. current_lists
    //Here a global 2d array of String will be created to hold current items. current_items[100][2]

    ObservableList<String> items = FXCollections.observableArrayList();
    ObservableList<String> incomplete_reserves = FXCollections.observableArrayList();
    ObservableList<String> complete_reserves = FXCollections.observableArrayList();





    public void addNewItemReaction(String description, String due_date)
    {
        /*
        This function will store the text from the addNewItem description, and due date text fields into 2 separate string variables, these String will be defaulted to NULL.
        The 2d string array current_items will hold an item at each column, and each item will have a description, due date, and completion status.
        Completion status will be defaulted to NULL when a new item is added.
        The strings will be added to the current_items array each time the function is called.
        The function will also add the string to a ListView variable that will display the current list of items to the user, with each value separated by a /.
        Lastly the function will return the current_items array for junit testing.

         */
        items.add(description + "," + due_date + "," + "Incomplete");



    }
    public void removeItemReaction(int index)
    {
        /*
        This function will take the current items 2d array as parameter.
        It will create an integer variable that will store the index of whichever item is highlighted when the user clicks removeItem.
        This index will be defaulted to 0 for junit testing.
        This index will be used to locate the current_items index that contains that items' description, and due date, and completion status.
        This index will be erased from the current_items arrayList.
        This index will be erased from the ListView item list, allowing the user to immediately see the updated list of items.
        Lastly, the function will return the updated current_items array for junit testing.
         */
        //current_items[index][0]="";
        //current_items[index][1]="";
        //current_items[index][2]="";
        items.remove(index);


    }
    public void editDescriptionReaction(int index, String new_description)
    {
        /*
        This function will take in the array current_items as its parameter.
        It will then locate the item the user is trying to edit by creating an integer variable that holds the index of whichever item is highlighted when the user clicks the editDescription button.
        This index will be defaulted to 0.
        This function will then create a string variable to hold the user input from the editDescription text field.
        This string will be defaulted to NULL.
        This string will be replacing the 1st of 3 values that each index holds, (Description[index][0],DueDate[index][1],CompletionStatus[index][2]), in the current_items arrayList at the highlighted index.
        This function will replace the Description index with the user's input from the editDescription text field.
        The function will then use the new string to update the listView items list.
        Lastly the function will return the current_items array for junit testing.
         */
        //current_items[index][0]=new_description;

        String current = items.get(index);
        String[] current_string = current.split(",");
        items.set(index, new_description + "," + current_string[1] + "," + current_string[2]);








        //items.add(index,new_description+","+current_string[1]+","+current_string[2]);
    }
    public void editDueDateReaction(int index, String  new_due_date)
    {
        /*
        This function will take in the 2d array that holds all items as parameter.
        The function will then create an integer variable to hold the index of the currently highlighted item when the editDueDate button is clicked.
        Then the function will use this index to locate the highlighted item.
        Once the index of the highlighted item is found the row index for due date, will be [index][1].
        At this index the 2d array will be holding the current due date of the highlighted item.
        The function will then replace the string at this index with the string that the user has input into the editDueDate text field.
        The function will then update the ListView item list with the information from the edited 2 array.
        The user will then be able to see the updated due date.
        Lastly the function will return the current_items 2d array for junit testing.
         */
        //current_items[index][1]=new_due_date;

            String current = items.get(index);
            String[] current_string = current.split(",");
            items.set(index, current_string[0] + "," + new_due_date + "," + current_string[2]);


    }
    public void markItemAsCompleteReaction(int index)
    {
        /*
        This function will take in the current_items 2d array as parameter.
        This function will create an integer variable that will hold the index value of whichever item is highlighted when the user clicks the markItemAsComplete button, the index will de defaulted as 0.
        The function will use this index value to find the items index in the current_items 2d array.
        Once the item has been found the function will be editing the [index][2] string value, which will be holding the completion status of the highlighted item.
        The string at this index will be replaced by "Completed".
        The function will then use the same index to locate the item in the ListView item list and update the item with its new completion status.
        The user will then be able to view the updated status.
        Lastly the function will return the edited current_items array to be used in junit testing.
         */

        String current = items.get(index);
        String[] current_string = current.split(",");
        items.set(index, current_string[0] + "," + current_string[1] + "," + "Complete");

        //current_items[index][2]="Complete";
    }

    public void markItemAsIncompleteReaction(int index)
    {

        String current = items.get(index);
        String[] current_string = current.split(",");
        items.set(index, current_string[0] + "," + current_string[1] + "," + "Incomplete");


        //current_items[index][2]="Incomplete";

    }
    public void displayAllItemsReaction()
    {
        /*
        This function will take in the current_items 2d array as parameter.
        This function will use the current_items array to update the ListView items list.
        The current_items array can hold up to 100 items, each with their own description,due date, and completion status.
        This function will run a for loop to fully update the ListView item list.
        A new string variable will be created to hold the current items' information.
        This will be a nested loop that uses an integer variable i to increment through each item.
        Each index will enter the inner loop which will increment though each data field using an integer variable j.
        The inner loops job is to create a string combining each data field separated by a /.
        At the end of the outer loop this string will be added to the ListView item list, and added into a ArrayList of string called displayed_items.
        This ArrayList will hold each fully formatted item string, the same string that the user will see on the ListView item list.
        Lastly the function will return this ArrayList for junit testing.
         */
        items.addAll(complete_reserves);
        items.addAll(incomplete_reserves);
        complete_reserves.clear();
        incomplete_reserves.clear();

    }
    public void clearAllItemsReaction()
    {
        items.clear();
        incomplete_reserves.clear();
        complete_reserves.clear();
    }
    public ObservableList<String> displayIncompletedItemsReaction()
    {
        /*
        This function will take in the 2d array current_items as parameter.
        This function will have the job of filling a new ArrayList with only incomplete items.
        This function will loop through the 2d array current_items.
        In this loop the function will be looking at the string located at [index][2].
        This index will hold the completion status for each item.
        The function will then compare the string at this index to "Incomplete".
        If the strings match then the item is incomplete, and will be added to the incomplete items array list.
        Once the loop has finished all incomplete items will be in the new ArrayList.
        The function will then use this ArrayList of incomplete items to update the ListView item list.
        Lastly the function will return the ArrayList for junit testing.
         */


        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for(int i=0;i<items.size();i++)
        {
            String current=items.get(i);
            String[] current_string=current.split(",");
            if(current_string[2].equals("Complete"))
            {
                complete_reserves.add(items.get(i));
                items.remove(i);
                i--;
            }
        }


        return complete_reserves;
    }
    public ObservableList<String> displayCompletedItemsReaction()
    {
        /*
        This function will take in the 2d array current_items as parameter.
        This function will have the job of filling a new ArrayList with only completed items.
        This function will loop through the 2d array current_items.
        In this loop the function will be looking at the string located at [index][2].
        This index will hold the completion status for each item.
        The function will then compare the string at this index to "Completed".
        If the strings match then the item is completed, and will be added to the incomplete items array list.
        Once the loop has finished all completed items will be in the new ArrayList.
        The function will then use this ArrayList of completed items to update the ListView item list.
        Lastly the function return the ArrayList for junit testing.
         */
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for(int i=0;i<items.size();i++)
        {
            String current=items.get(i);
            String[] current_string=current.split(",");
            if(current_string[2].equals("Incomplete"))
            {
                incomplete_reserves.add(items.get(i));
                items.remove(i);
                i--;
            }
        }
        return incomplete_reserves;
    }


    public int loadSingleListReaction(String title, ArrayList<String> loadable_lists)
    {
        /*
        This function will read from the external storage file called ExternalStorage.txt.
        This function will take in a string called title as parameter.
        This string will be used to locate the correct list.
        The function will then iterate through the ExternalStorage.txt file and fill up an ArrayList of string called loadable_lists.
        The function will use string.split to properly locate the title of each list in storage.
        If the loop reaches the end of the file without a match then 0 will be returned.
        If the loop finds a match then it will add the lists items into the loaded_lists ArrayList.
        Once the loop is complete it will have filled the loaded_lists with all matches, and the loaded_lists ArrayList will be copied to the ListView item list.
        The function will then return 1.
        */
        return 1;
    }

}
