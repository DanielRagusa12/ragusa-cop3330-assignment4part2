package ucf.assignments;/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Daniel Ragusa
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.text.StringContent;
import java.util.Arrays;


public class FXMLController
{
    public Button addNewItem_btn;
    public Button removeItem_btn;
    public Button editDescription_btn;
    public Button editDueDate_btn;
    public Button markItemAsComplete_btn;
    public ListView list_of_items;
    public Button displayAllItems_btn;
    public Button displayIncompletedItems_btn;
    public Button displayCompletedItems_btn;
    public Button loadSingleList_btn;
    public TextField addNewItem_Desciption;
    public TextField addNewItem_DueDate;
    public TextField editDescription_Description;
    public TextField editDueDate_DueDate;
    public Button saveList_btn;
    public ChoiceBox loadSingleList_selector;
    public Button clearAllItems_btn;
    public Button markItemAsIncomplete_btn;
    public TextField saveList_title;
    Tasks Tasks= new Tasks();



    /*
    The main idea of this controller class is to register which behavior the user wishes to execute.
    The functions in this class will take in action events as parameter, which will allow them to be executed from the application.
    Each behavior has an associated action event.
    Each function has a counterpart "Reaction" function that is located in the Tasks class.
    These Reaction functions will hold the true code, for processing, and displaying information to the user.
    When an action event occurs, the function will then call its counterpart "Reaction" function.
     */












    //Function to add a new item to an existing list.

    public void addNewItem(ActionEvent actionEvent)
    {
        list_of_items.setItems(Tasks.items);


        String description=addNewItem_Desciption.getText();
        String due_date=addNewItem_DueDate.getText();
        if(!description.isEmpty() && !due_date.isEmpty())
        {
            Tasks.addNewItemReaction(description, due_date);
            //Tasks.addNewItem_i++;
        }


    /*
    This function will be executed when the user presses the add new item button.
    The function will call addNewItemReaction, from the Tasks class, and pass an empty 2d array of string that will hold the items.
     */

    }


    //A function to remove an existing item.
    public void removeItem(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the removeItem button is clicked by the user.
        It will then call removeItemReaction, from the Tasks class, with the array that holds the existing items.
         */
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        if(index>=0)
        {
            Tasks.removeItemReaction(index);
        }


    }

    //A function that allows the user to edit the description of an existing item.
    public void editDescription(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks on the editDescription button.
        It will call editDescriptionReaction, from the Tasks class, with the array current_items which holds all the information for each item.

        */
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        String new_description=editDescription_Description.getText();
        Tasks.editDescriptionReaction(index,new_description);

    }


    //This function will allow the user to edit the due date of an existing item.

    public void editDueDate(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks on the editDueDate button.
        This function will call editDueDateReaction, from the Tasks class, with the 2d array that holds all items.
         */
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        String new_due_date=editDueDate_DueDate.getText();
        Tasks.editDueDateReaction(index,new_due_date);
    }

    //A function that allows the user to mark a current item as complete.
    public void markItemAsComplete(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the markItemAsComplete button.
        This function will call the markItemAsCompleteReaction function, from the Tasks class, with the 2d array that holds all items.
         */
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        Tasks.markItemAsCompleteReaction(index);


    }
    public void markItemAsIncomplete(ActionEvent actionEvent)
    {
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        Tasks.markItemAsIncompleteReaction(index);


    }


    //A function that allows the user to display all current items.
    public void displayAllItems(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks on the displayAllItems button.
        This function will call displayAllItemsReaction, from the Tasks class, with the current_items 2d array that holds all items.
         */
        Tasks.displayAllItemsReaction();
        //list_of_items.setItems(Tasks.items);

    }
    public void clearAllItems(ActionEvent actionEvent)
    {
        Tasks.clearAllItemsReaction();
    }

    //A function that allows the user to sort the ListView item list by only incomplete items.
    public void displayIncompletedItems(ActionEvent actionEvent)
    {
        Tasks.displayIncompletedItemsReaction();
        //list_of_items.setItems(Tasks.incomplete_items);
        /*
        This function will be executed when the user clicks the displayIncompletedItems button.
        This function will call displayIncompletedItemsReaction, from the Tasks class, with the 2d array current_items which holds all items.
         */


    }

    //A function that allows the user to sort the ListView item list by only incomplete items.
    public void displayCompletedItems(ActionEvent actionEvent)
    {
        Tasks.displayCompletedItemsReaction();
        /*
        This function will be executed when the user clicks the displayCompletedItems button.
        This function will call displayCompletedItemsReaction, from the Tasks class, with the 2d array current_items which holds all items.
         */

    }

    //A function that allows the user to save all the items from a specific list into external storage.



    //A function that allows the user to load a singular list from external storage.
    public void loadSingleList(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the loadSingleList button.
        This function will create a string variable called title that holds the string from the loadSingleList title text field.
        This function will call loadSingleListReaction, from the Tasks class, with the title string.
         */


    }


    public void saveList(ActionEvent actionEvent)
    {
        
    }




}


