package ucf.assignments;/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Daniel Ragusa
 */
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class FXMLController
{
    public Button addNewItem_btn;
    public Button removeItem_btn;
    public Button editDescription_btn;
    public Button editDueDate_btn;
    public Button markItemAsComplete_btn;
    public ListView<String> list_of_items;
    public Button displayAllItems_btn;
    public Button displayIncompletedItems_btn;
    public Button displayCompletedItems_btn;
    public Button loadSingleList_btn;
    public TextField addNewItem_Desciption;
    public TextField addNewItem_DueDate;
    public TextField editDescription_Description;
    public TextField editDueDate_DueDate;
    public Button saveList_btn;
    public Button clearAllItems_btn;
    public Button markItemAsIncomplete_btn;
    public CheckBox setComplete_checkbox;
    public Text error_box;
    public Text error_box2;
    Tasks Tasks= new Tasks();


    /*
    The main idea of this controller class is to register which behavior the user wishes to execute.
    The functions in this class will take in action events as parameter, which will allow them to be executed from the application.
    Each behavior has an associated action event.
    Each function has a counterpart "Reaction" function that is located in the Tasks class.
    These Reaction functions will hold the true code, for processing, and displaying information to the user.
    When an action event occurs, the function will then call its counterpart "Reaction" function.
     */

    //A function that checks if the user entered a valid date.
    public boolean isDateValid(String due_date)
    {
        /*
        This function first clears the error box for due date errors.
        It then sets the format for the date "YYYY-MM-DD".
        Following this is a try catch block that attempts to parse the date to the correct format.
        If this throws a parse exception then an error message will be printed to the user, and the function will return false, meaning the date was in incorrect format.
        If the date was able to be parsed then the function will return true.
        */
        if(error_box!=null)
        {
            error_box.setText("");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try
        {
            LocalDate.parse(due_date, formatter);
        } catch (DateTimeParseException e)
        {
            if(error_box!=null)
            {
                error_box.setText("Invalid Date!");

            }
            return false;
        }
        return true;
    }

    //A function that checks if the description entered by the user meets restrictions.
    public boolean isDescriptionValid(String description)
    {
        /*
        This function first clears the current error box for description errors.
        It then checks if the user's inputted description is empty, and also checks to see if it is longer than 256 characters.
        If either of these are true the function returns false, and displays an error message to the user.
        If the description is less than 256 characters, and not empty then the function will return true.
         */
        if(error_box2!=null)
        {
            error_box2.setText("");

        }

        if(description.isEmpty() || description.length()>256)
        {
            if(error_box2!=null)
            {
                error_box2.setText("Invalid Description!");

            }
            return false;
        }
        else
            return true;
    }



//This function is called when the user clicks on the completed checkbox when adding a new item.

    public void setComplete(ActionEvent actionEvent)
    {
        /*
        This function checks to see if the box is checked or not.
        If the box is checked then a global variable, Completion_Flag in the tasks class, is set to 1.
        If the box is unchecked it is set to 0.
        The tasks class will use this to determine if a new item should be marked as complete, or incomplete.
         */

        if(setComplete_checkbox.selectedProperty().get())
        {
            Tasks.Completion_Flag=1;
        }
        else
            Tasks.Completion_Flag=0;
    }

    //Function to add a new item to the list.

    public void addNewItem(ActionEvent actionEvent)
    {
        /*
        This function first links the listView variable to the observable list items, from the tasks class.
        The listView will now automatically update when the observable list is updated.
        Next, the function creates two string variables to hold the description, and due date from the add new item text fields.
        Then the function will call isDateValid, and isDescriptionValid, to ensure the inputs meet constrictions.
        If both of the calls return true, then the function will call addNewItemReaction from the tasks class.
         */



        list_of_items.setItems(Tasks.items);


        String description=addNewItem_Desciption.getText();
        String due_date=addNewItem_DueDate.getText();

        boolean date_check=isDateValid(due_date);
        boolean des_check=isDescriptionValid(description);

        if(date_check && des_check)
        {
            Tasks.addNewItemReaction(description, due_date);
            //Tasks.addNewItem_i++;
        }


    }


    //A function to remove an existing item.
    public void removeItem(ActionEvent actionEvent)
    {
        /*
        This function will first create an index variable to hold the integer value of the currently highlighted index in the listView when the user clicks remove item.
        It will then check if this index is a positive number to prevent errors.
        If the index is positive, then removeItemReaction is called from the tasks class, with the index being passed.
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
        This function first creates an integer variable to hold the index of the currently highlighted item.
        Then a string variable is created to hold the description from the edit description text box.
        This function then calls isDescriptionValid, to ensure the description meets constrictions.
        If the call returns true, then the function will call editDescription from the tasks class, passing the index, and new description.
        */
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        String new_description=editDescription_Description.getText();

        boolean des_check=isDescriptionValid(new_description);
        if(des_check)
        {
            Tasks.editDescriptionReaction(index,new_description);
        }


    }


    //This function will allow the user to edit the due date of an existing item.

    public void editDueDate(ActionEvent actionEvent)
    {
        /*
        This function first creates an integer variable to hold the index of the currently highlighted item.
        Then a string variable is created to hold the due date from the edit due date text box.
        Next the function will call isDateValid to ensure the new due date meets constrictions.
        If the call returns true the function will call editDueDate reaction from the tasks class, passing the index, and new due date.
         */
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        String new_due_date=editDueDate_DueDate.getText();

        boolean date_check=isDateValid(new_due_date);

        if(date_check)
        {
            Tasks.editDueDateReaction(index,new_due_date);
        }

    }

    //A function that allows the user to mark a current item as complete.
    public void markItemAsComplete(ActionEvent actionEvent)
    {
        /*
        This function first creates an integer variable to hold the index of the currently highlighted item.
        If the index is positive then the function will call markItemAsCompleteReaction from the tasks class, passing the index.
         */
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        if(index>=0)
        {
            Tasks.markItemAsCompleteReaction(index);
        }


    }
    public void markItemAsIncomplete(ActionEvent actionEvent)
    {
        /*
        This function first creates an integer variable to hold the index of the currently highlighted item.
        If the index is positive then the function will call markItemAsIncompleteReaction from the tasks class, passing the index.
         */
        int index =  list_of_items.getFocusModel().getFocusedIndex();
        if(index>=0)
        {
            Tasks.markItemAsIncompleteReaction(index);
        }


    }


    //A function that allows the user to display all current items.
    public void displayAllItems(ActionEvent actionEvent)
    {
        //This function calls displayAllItems from the tasks class.

        Tasks.displayAllItemsReaction();

    }
    public void clearAllItems(ActionEvent actionEvent)
    {
        //This function calls clearAllItems from the tasks class.

        Tasks.clearAllItemsReaction();
    }

    //A function that allows the user to sort the ListView item list by only incomplete items.
    public void displayIncompletedItems(ActionEvent actionEvent)
    {
        //This function first calls displayAllItemsReaction. This is done to update the list before filtering is done.
        //The function then calls displayIncompletedItems from the tasks class.
        Tasks.displayAllItemsReaction();
        Tasks.displayIncompletedItemsReaction();
    }

    //A function that allows the user to sort the ListView item list by only incomplete items.
    public void displayCompletedItems(ActionEvent actionEvent)
    {
        //This function first calls displayAllItemsReaction. This is done to update the list before filtering is done.
        //The function then calls displayCompletedItems from the tasks class.
        Tasks.displayAllItemsReaction();
        Tasks.displayCompletedItemsReaction();
    }

    //A function that allows the user to load a singular list from external storage.
    public void loadList(ActionEvent actionEvent) throws IOException
    {
        /*
        This function first sets the listView item list to the items observable list from the tasks class.
        This function then creates a new file chooser object, and sets the title to "Open".
        Then the txt extension filter is added, to ensure users can only open text files.
        Then a new file is created, and set equal to the file choosers open dialog.
        This will set the file directory to the user's chosen file.
        If the user cancels, then the file will return null, and the exception is handled appropriately.
        Otherwise, the function will call loadListReaction with the file directory.
         */
        list_of_items.setItems(Tasks.items);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file=fileChooser.showOpenDialog(null);
        if(file==null)
        {
            return;
        }
        Tasks.loadListReaction(file);


    }


    public void saveList(ActionEvent actionEvent) throws IOException
    {
        /*
        This function first creates a new file chooser object.
        Then sets the title to "Save".
        Then the extension filter is set to ensure that the saved file is a text file.
        Then a new file is created, and set equal to the file choosers save dialog.
        This will set the file directory to the user's chosen file.
        If the user cancels, then the file will return null, and the exception is handled appropriately.
        Otherwise, the function will call saveListReaction with the file directory.

         */
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File file = fileChooser.showSaveDialog(null);
            if(file==null)
            {
                return;
            }
            Tasks.saveListReaction(file);


    }



}


