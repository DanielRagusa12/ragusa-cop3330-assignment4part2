package ucf.assignments;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    @org.junit.jupiter.api.Test
    void addNewListReaction()
    {
        /*
        Here a ArrayList of string will be declared called current_lists.
        This test will be passing a string variable called title to the addNewListReaction function.
        If the function works correctly then the title should be added to current_lists.
        The test will assert that this title is the same as the string at index [0] of current_lists.
        This will ensure the list was correctly added.

         */
    }


    @org.junit.jupiter.api.Test
    void removeListReaction()
    {
        /*
        This test will be passing an ArrayList of string that has 1 string at index [0].
        Since the removeListReaction function defaults the index to 0 the function should remove the string from the ArrayList.
        The test will assert that the returned ArrayList that was passed is NULL at index [0].
         */
    }

    @org.junit.jupiter.api.Test
    void editTitleReaction()
    {
        /*
        This test will initialize an empty ArrayList of string called test.
        This test will initialize a string variable and set it to "working".
        This test will be passing the string to the editTitleReaction function. The editTitleReaction function will return to the test ArrayList.
        This test will be asserting that the empty array now holds "working" at index [0].
         */
    }

    @org.junit.jupiter.api.Test
    void addNewItemReaction()
    {
        Tasks TestTasks = new Tasks();
        String description="Test";
        String due_date= "0000-00-00";
        TestTasks.addNewItemReaction(description,due_date);
        assertEquals("Test",TestTasks.current_items[0][0]);
        assertEquals("0000-00-00",TestTasks.current_items[0][1]);
        assertEquals("Incomplete",TestTasks.current_items[0][2]);

        /*
        This test will be creating a 2d array of string that holds the following values at each index. [0][0]="0",[0][1]="1",[0][2]="2".
        The addNewItemReaction defaults all string to NULL, because in the junit test there will be no input from the applications text fields.
        This means the returned 2d array of string should now hold NULL instead of "0","1","2".
        This test will assert that NULL is at all 3 indexes of the returned 2d Array.
         */

    }

    @org.junit.jupiter.api.Test
    void removeItemReaction()
    {
        /*
        This test will be creating an ArrayList of string. With the string "test" at index [0].
        This ArrayList will be passed to the removeItemReaction function.
        Since the removeItemReaction function will not be able to assign its index variable from the application, the index will be defaulted to 0.
        This test will assert that the returned ArrayList from removeItemReaction will now NOT hold "test" at index [0].

         */
        Tasks TestTasks = new Tasks();
        TestTasks.current_items[0][0]="Chores";
        TestTasks.current_items[0][1]="0000-00-00";
        TestTasks.current_items[0][2]="Complete";

        TestTasks.current_items[5][0]="Homework";
        TestTasks.current_items[5][1]="5555-55-55";
        TestTasks.current_items[5][2]="Incomplete";

        TestTasks.removeItemReaction(0);
        assertEquals("Removed Item",TestTasks.current_items[0][0]);
        assertEquals("",TestTasks.current_items[0][1]);
        assertEquals("",TestTasks.current_items[0][2]);

        TestTasks.removeItemReaction(5);
        assertEquals("Removed Item",TestTasks.current_items[5][0]);
        assertEquals("",TestTasks.current_items[5][1]);
        assertEquals("",TestTasks.current_items[5][2]);
    }

    @org.junit.jupiter.api.Test
    void editDescriptionReaction()
    {
        /*
        This test will be creating a 2d array that holds the following values at each index. [0][0] ="0",[0][1]="1",[0][2]="2".
        This test will then call the editDescriptionReaction function, passing the 2d array.
        If the function is working correctly then it should only replace the string value at index [0][0], and the others should still be "1", and "2".
        The test will then assert that the returned 2d array will be NULL at index [0][0], and that indexes [0][1], and [0][2] are unchanged.
         */
    }

    @org.junit.jupiter.api.Test
    void editDueDateReaction()
    {
        /*
        This test will be creating a 2d array that holds the following values at each index. [0][0] ="0",[0][1]="1",[0][2]="2".
        This test will then call the editDueDateReaction function, passing the 2d array.
        If the function is working correctly then it should only replace the string value at index [0][1], and the others should still be "0", and "2".
        The test will then assert that the returned 2d array will be NULL at index [0][1], and that indexes [0][0], and [0][2] are unchanged.
        */
    }

    @org.junit.jupiter.api.Test
    void markItemAsCompleteReaction()
    {
        /*
        This test will be creating a 2d array that holds the following values at each index. [0][0] ="Chores",[0][1]="2022-02-12",[0][2]="Incomplete".
        This test will then call the markItemAsCompleteReaction function, passing the 2d array.
        If the function is working correctly then it should only replace the string value at index [0][3], and the others should still be "Chores", and "2022-02-12".
        The test will then assert that the returned 2d array will hold a string "Completed" at index [0][2], and that indexes [0][0], and [0][1] are unchanged.
         */

    }

    @org.junit.jupiter.api.Test
    void displayAllItemsReaction()
    {
        /*
        This test will be creating a 2d array that holds the following values at each index. [0][0] ="Chores",[0][1]="2022-02-12",[0][2]="Incomplete".
        The test will then call the displayAllItemsReaction function, passing the 2d array.
        This function will return to an empty ArrayList of String.
        If the function is working properly it should add the strings from [0][0],[0][1], and [0][2], into one continuous string with each part being separated by a /.
        The test will assert that the empty array list now holds "Chores/2022-02-12/Incomplete" at index [0].
         */
    }

    @org.junit.jupiter.api.Test
    void displayIncompletedItemsReaction()
    {
        /*
        This test will be creating a 2d array that holds the following values at each index.
        [0][0] ="Chores",[0][1]="2022-02-12",[0][2]="Incomplete".
        [0][0] ="Homework",[0][1]="2021-11-10",[0][2]="Complete".
        [0][0] ="Cleaning",[0][1]="2022-02-14",[0][2]="Incomplete".

        The test will then call the displayIncompletedItemsReaction function, passing the 2d array.
        This function will return to an empty ArrayList of String.
        If the function is working properly it should only add the incomplete items into the ArrayList.
        The test will assert that the empty array list now holds
        "Chores/2022-02-12/Incomplete" at index [0]. and "Cleaning/2022-02-14/Incomplete" at index [1].
         */
    }

    @org.junit.jupiter.api.Test
    void displayCompletedItemsReaction()
    {
        /*
        This test will be creating a 2d array that holds the following values at each index.
        [0][0] ="Chores",[0][1]="2022-02-12",[0][2]="Incomplete".
        [0][0] ="Homework",[0][1]="2021-11-10",[0][2]="Complete".
        [0][0] ="Cleaning",[0][1]="2022-02-14",[0][2]="Incomplete".

        The test will then call the displayIncompletedItemsReaction function,passing the 2d array.
        This function will return to an empty ArrayList of String.
        If the function is working properly it should only add the completed items into the ArrayList.
        The test will assert that the empty array list now holds
        "Homework/2021-11-10/Complete" at index [0].
         */
    }

    @org.junit.jupiter.api.Test
    void saveItemsFromListReaction()
    {
        /*
        This test will be creating a 2d array that holds the following values at each index.
        [0][0] ="Chores",[0][1]="2022-02-12",[0][2]="Incomplete".
        [0][0] ="Homework",[0][1]="2021-11-10",[0][2]="Complete".
        [0][0] ="Cleaning",[0][1]="2022-02-14",[0][2]="Incomplete".
        This test will create a string variable called title that holds "test".
        This test will then call the saveItemsFromListReaction function,passing the 2d array, and title string.
        If the function is working properly it will return an ArrayList with the following string values.
        [0]="{test}"
        [1]="Chores,2022-02-12,Incomplete"
        [2]="Homework,2021-11-10,Complete"
        [3]="Cleaning,2022-02-14,Incomplete"
        The test will assert that indexes [0],[1],[2], and [3] match the above strings.
        This test works because the saveItemsFromListReaction uses the tested ArrayList to print to the ExternalStorage.txt output file.

         */

    }

    @org.junit.jupiter.api.Test
    void saveAllItemsReaction()
    {
         /*
        This test will be creating a 2d array that holds the following values at each index.
        [0][0] ="Chores",[0][1]="2022-02-12",[0][2]="Incomplete".
        [0][0] ="Homework",[0][1]="2021-11-10",[0][2]="Complete".
        [0][0] ="Cleaning",[0][1]="2022-02-14",[0][2]="Incomplete".
        This test will then call the saveItemsFromListReaction function,passing the 2d array.
        If the function is working properly it will return an ArrayList with the following string values.
        [0]="Chores,2022-02-12,Incomplete"
        [1]="Homework,2021-11-10,Complete"
        [2]="Cleaning,2022-02-14,Incomplete"
        The test will assert that indexes [0],[1],and [2] match the above strings.
        This test works because the saveItemsFromListReaction uses the tested ArrayList to print to the ExternalStorage.txt output file.

         */


    }

    @org.junit.jupiter.api.Test
    void loadSingleListReaction()
    {
        /*
            This test will start by creating an ArrayList of string called loadable_lists with the following values.
            [0]="Chores"
            [1]="Cleaning"
            [2]="Homework"
            The test will then create a string variable called title that holds "test".

            This test will then call the loadSingleListReaction function, passing the ArrayList, and title string.
            This test will assert that the loadSingleListReaction function will return 0, because "test" does not exist in its loadable_lists ArrayList.


         */


    }

    @org.junit.jupiter.api.Test
    void loadMultipleListsReaction()
    {
        /*
            This test will start by creating an ArrayList of string called loadable_lists with the following values.
            [0]="Chores"
            [1]="Cleaning"
            [2]="Homework"
            The test will then create a string variable called titles that holds "test,Chores,hello".

            This test will then call the loadSingleListReaction function, passing the ArrayList, and title string.
            This test will assert that the loadSingleListReaction function will return 1, because "Chores" exists in its loadable_lists ArrayList.


         */


    }
}
