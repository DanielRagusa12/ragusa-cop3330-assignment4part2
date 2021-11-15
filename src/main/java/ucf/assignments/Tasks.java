package ucf.assignments;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Daniel Ragusa
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;



public class Tasks
{

    ObservableList<String> items = FXCollections.observableArrayList();
    ObservableList<String> incomplete_reserves = FXCollections.observableArrayList();
    ObservableList<String> complete_reserves = FXCollections.observableArrayList();
    int Completion_Flag=0;


    public void addNewItemReaction(String description, String due_date)
    {
        /*
        This function will take in the description, and due date from the addNewItem function from the FXMLController class as parameters.
        Then the function will use the global Completion_Flag variable to check if the user wishes to add a complete, or incomplete item.
        If the flag is 0 then the function will add the item with "Incomplete" status.
        Otherwise, the function will add the new item with "Complete" status.
        The item will be added to the items observable list.
        The item will be added with a csv approach separating description,due date, and completion status.
        */
        if(Completion_Flag==0)
        {
            items.add(description + "," + due_date + "," + "Incomplete");
        }
        else
            items.add(description + "," + due_date + "," + "Complete");
    }
    public void removeItemReaction(int index)
    {
        /*
        This function will take the index from the removeItem function from the FXMLController class as parameter.
        Then the function will use the index to remove the item from the items observable list.
         */
        items.remove(index);


    }
    public void editDescriptionReaction(int index, String new_description)
    {
        /*
        This function will take in the index, and description from the editDescription function from the FXMLController class.
        This function will then create a string current, which is set to the string located at the index value of the items observable list.
        The function will then create a string array, that will utilize .split to separate the description,due date, and completion status of the item.
        This function will then .set to replace the first index of the string array which holds the items current description.
        This will be replaced by the new description taken in as parameter.
        The due date and completion status will not be changed.
         */

        String current = items.get(index);
        String[] current_string = current.split(",");
        items.set(index, new_description + "," + current_string[1] + "," + current_string[2]);
    }
    public void editDueDateReaction(int index, String  new_due_date)
    {
        /*
        This function will take in the index, and due date from the editDueDate function from the FXMLController class.
        This function will then create a string current, which is set to the string located at the index value of the items observable list.
        The function will then create a string array, that will utilize .split to separate the description,due date, and completion status of the item.
        This function will then .set to replace the second index of the string array which holds the items current due date.
        This will be replaced by the new due date taken in as parameter.
        The description and completion status will not be changed.
         */
        String current = items.get(index);
        String[] current_string = current.split(",");
        items.set(index, current_string[0] + "," + new_due_date + "," + current_string[2]);


    }
    public void markItemAsCompleteReaction(int index)
    {
        /*
        This function will take in the index from the markItemAsComplete function from the FXMLController class.
        This function will then create a string current, which is set to the string located at the index value of the items observable list.
        The function will then create a string array, that will utilize .split to separate the description,due date, and completion status of the item.
        This function will then .set to replace the third index of the string array which holds the items current completion status.
        This will be replaced by "Complete".
        The description and due date will not be changed.
        */

        String current = items.get(index);
        String[] current_string = current.split(",");
        items.set(index, current_string[0] + "," + current_string[1] + "," + "Complete");

    }

    public void markItemAsIncompleteReaction(int index)
    {
        /*
        This function will take in the index from the markItemAsIncomplete function from the FXMLController class.
        This function will then create a string current, which is set to the string located at the index value of the items observable list.
        The function will then create a string array, that will utilize .split to separate the description,due date, and completion status of the item.
        This function will then .set to replace the third index of the string array which holds the items current completion status.
        This will be replaced by "Incomplete".
        The description and due date will not be changed.
        */


        String current = items.get(index);
        String[] current_string = current.split(",");
        items.set(index, current_string[0] + "," + current_string[1] + "," + "Incomplete");


    }
    public void displayAllItemsReaction()
    {
        /*
        This function will first add all the items in the complete reserves, and incomplete reserves observable lists to the items observable list.
        It will then clear both observable list reserves. This is done to ensure items are not duplicated if the user clicks the displayAllItems button multiple times.
         */
        items.addAll(complete_reserves);
        items.addAll(incomplete_reserves);
        complete_reserves.clear();
        incomplete_reserves.clear();

    }
    public void clearAllItemsReaction()
    {
        /*
        This function uses .clear to remove all items from the items, complete reserves, and incomplete reserves observable lists.
         */
        items.clear();
        incomplete_reserves.clear();
        complete_reserves.clear();
    }
    public void displayIncompletedItemsReaction()
    {
        /*
        This function runs a for loop that increments through each item in the items observable list.
        Then the function creates a string variable to hold the current items' information with each iteration.
        It then creates a string array, that utilizes .split to separate each items' description, due date, and completion status.
        The [2] index of the array, which holds the items' completion status, is compared to "Complete".
        If the strings match then the item is added to the complete reserves observable list, and the item is removed from the items observable list.
        When an item is removed from an observable list, it shifts all indexes down by 1, i is decremented by 1 to account for this.
         */
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
    }
    public void displayCompletedItemsReaction()
    {
        /*
        This function runs a for loop that increments through each item in the items observable list.
        Then the function creates a string variable to hold the current items' information with each iteration.
        It then creates a string array, that utilizes .split to separate each items' description, due date, and completion status.
        The [2] index of the array, which holds the items' completion status, is compared to "Incomplete".
        If the strings match then the item is added to the incomplete reserves observable list, and the item is removed from the items observable list.
        When an item is removed from an observable list, it shifts all indexes down by 1, i is decremented by 1 to account for this.
         */

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
    }


    public void loadListReaction(File file) throws IOException
    {
        /*
        This function first takes in directory of the desired load file, from the loadList function from the FXMLController class.
        It then creates a new buffered reader to read from the load file.
        The function then creates a string variable to hold the current line being read by the buffered reader.
        The while loop will run until the current string is null, indicating the end of the file has been reached.
        Each time the loop is run the current line will be added to the items observable list.
         */
        BufferedReader br = new BufferedReader(new FileReader(file));

        String current = "";
        while ((current = br.readLine()) != null)
        {
            items.add(current);
        }

    }
    public void saveListReaction(File file) throws IOException
    {
        /*
        This function first takes in directory of the desired save file, from the saveList function from the FXMLController class.
        It then creates a new buffered writer to write to the save file.
        The function then has a for loop that increments through the items observable list.
        Each time the loop is run the function will write to the save file using, the current string from the items observable list. items.get(i)
        It will then create a new line after the item is added.
        Lastly this function will flush and close the save file.
         */

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for(int i=0;i<items.size();i++)
        {
            bw.write(items.get(i));
            bw.write("\n");
        }

        bw.flush();
        bw.close();


    }

}
