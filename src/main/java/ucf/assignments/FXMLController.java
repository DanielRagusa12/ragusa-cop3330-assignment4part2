package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Daniel Ragusa
 */
import javafx.event.ActionEvent;



public class FXMLController
{

    /*
    The main idea of this controller class is to register which behavior the user wishes to execute.
    The functions in this class will take in action events as parameter, which will allow them to be executed from the application.
    Each behavior has an associated action event.
    Each function has a counterpart "Reaction" function that is located in the Tasks class.
    These Reaction functions will hold the true code, for processing, and displaying information to the user.
    When an action event occurs, the function will then call its counterpart "Reaction" function.
     */



    //Function that allows the user to add a new list.
    public void addNewList(ActionEvent actionEvent)
    {
        /*
        This method will happen when the user clicks on the addNewList button.
        This function will read the current text from the title text field assigned to the addNewList button and store it in a string variable.
        It will then pass this string variable to addNewListReaction, in the Tasks class.
        */


    }


    //Function that removes a list.
    public void removeList(ActionEvent actionEvent)
    {
        /*
        This will happen when the user clicks on the removeListButton.
        This function will call removeListReaction, from the Tasks class, with current_list_titles which holds the title of each list at an index.
         */

    }


//This function will allow the user to edit the title of a list in the left-hand listView area.

    public void editTitle(ActionEvent actionEvent)
    {
        /*
        This function will happen when the user clicks on the editTitle button.
        This function will call editTitleReaction, from the Tasks class, with the string from the edit title text field in the application.
         */

    }


    //Function to add a new item to an existing list.

    public void addNewItem(ActionEvent actionEvent)
    {
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

    }

    //A function that allows the user to edit the description of an existing item.
    public void editDescription(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks on the editDescription button.
        It will call editDescriptionReaction, from the Tasks class, with the array current_items which holds all the information for each item.

        */
    }


    //This function will allow the user to edit the due date of an existing item.

    public void editDueDate(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks on the editDueDate button.
        This function will call editDueDateReaction, from the Tasks class, with the 2d array that holds all items.
         */

    }

    //A function that allows the user to mark a current item as complete.
    public void markItemAsComplete(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the markItemAsComplete button.
        This function will call the markItemAsCompleteReaction function, from the Tasks class, with the 2d array that holds all items.
         */

    }


    //A function that allows the user to display all current items.
    public void displayAllItems(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks on the displayAllItems button.
        This function will call displayAllItemsReaction, from the Tasks class, with the current_items 2d array that holds all items.
         */


    }

    //A function that allows the user to sort the ListView item list by only incomplete items.
    public void displayIncompletedItems(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the displayIncompletedItems button.
        This function will call displayIncompletedItemsReaction, from the Tasks class, with the 2d array current_items which holds all items.
         */


    }

    //A function that allows the user to sort the ListView item list by only incomplete items.
    public void displayCompletedItems(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the displayCompletedItems button.
        This function will call displayCompletedItemsReaction, from the Tasks class, with the 2d array current_items which holds all items.
         */

    }

    //A function that allows the user to save all the items from a specific list into external storage.
    public void saveItemsFromList(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the saveItemsFromList button.
        This function will create an integer variable that holds the position of the currently highlighted list when the user clicks the aveItemsFromList button.
        This function will then use this index to find the title of the list from the current_lists ArrayList, and save it in a string variable called title.
        This function will then call saveItemsFromListReaction, from the Tasks class, with the 2d array current_items, and the title string.
         */

    }

    //A function that allows the user to save all current items.
    public void saveAllItems(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the saveAllItems button.
        This function will call saveAllItemsReaction from Tasks class.
         */

    }

    //A function that allows the user to load a singular list from external storage.
    public void loadSingleList(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the loadSingleList button.
        This function will create a string variable called title that holds the string from the loadSingleList title text field.
        This function will call loadSingleListReaction, from the Tasks class, with the title string.
         */


    }

    //A function that allows the user to load multiple lists from external storage.
    public void loadMultipleLists(ActionEvent actionEvent)
    {
        /*
        This function will be executed when the user clicks the loadSingleList button.
        This function will create a string variable called titles that holds the string from the loadMultipleLists title text field.
        This function will call loadMultipleListsReaction, from the Tasks class, with the title string.
         */

    }

}

