package ucf.assignments;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {


    @org.junit.jupiter.api.Test
    void addNewItemReaction()
    {
        Tasks TestTasks = new Tasks();
        String description="Test";
        String due_date= "0000-00-00";
        TestTasks.addNewItemReaction(description,due_date);

        assertEquals("Test,0000-00-00,Incomplete",TestTasks.items.get(0));

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
        TestTasks.items.add("Test,0000-00-00,Incomplete");
        TestTasks.items.add("Chores,0000-00-00,Incomplete");
        TestTasks.items.add("Homework,0000-00-00,Incomplete");
        TestTasks.removeItemReaction(1);
        assertEquals("Homework,0000-00-00,Incomplete",TestTasks.items.get(1));

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
        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Incomplete");
        TestTasks.editDescriptionReaction(0,"It Worked");
        assertEquals("It Worked,0000-00-00,Incomplete",TestTasks.items.get(0));

        //assertEquals(TestTasks.current_items[0][0],"Homework");


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

        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Incomplete");
        TestTasks.editDueDateReaction(0,"2222-22-22");
        assertEquals("Test,2222-22-22,Incomplete",TestTasks.items.get(0));

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
        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Incomplete");
        TestTasks.markItemAsCompleteReaction(0);
        assertEquals("Test,0000-00-00,Complete",TestTasks.items.get(0));


        TestTasks.markItemAsCompleteReaction(0);

        //assertEquals(TestTasks.current_items[0][2],"Complete");

    }

    @org.junit.jupiter.api.Test
    void markItemAsIncompleteReaction()
    {
        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Complete");
        TestTasks.markItemAsIncompleteReaction(0);
        assertEquals("Test,0000-00-00,Incomplete",TestTasks.items.get(0));
    }

    @org.junit.jupiter.api.Test
    void clearAllItemsReaction()
    {
        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Complete");
        TestTasks.items.add(1,"Chores,0000-00-00,Incomplete");
        TestTasks.items.add(2,"Homework,0000-00-00,Complete");

        TestTasks.complete_reserves.add(0,"Test,0000-00-00,Complete");
        TestTasks.complete_reserves.add(1,"Chores,0000-00-00,Incomplete");
        TestTasks.complete_reserves.add(2,"Homework,0000-00-00,Complete");

        TestTasks.incomplete_reserves.add(0,"Test,0000-00-00,Complete");
        TestTasks.incomplete_reserves.add(1,"Chores,0000-00-00,Incomplete");
        TestTasks.incomplete_reserves.add(2,"Homework,0000-00-00,Complete");

        TestTasks.clearAllItemsReaction();

        assertEquals(0,TestTasks.items.size());
        assertEquals(0,TestTasks.complete_reserves.size());
        assertEquals(0,TestTasks.incomplete_reserves.size());


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
        Tasks TestTasks = new Tasks();

        TestTasks.items.add(0,"Test,0000-00-00,Complete");
        TestTasks.items.add(1,"Chores,0000-00-00,Incomplete");
        TestTasks.items.add(2,"Homework,0000-00-00,Complete");

        TestTasks.complete_reserves.add(0,"Coding,3333-33-33,Incomplete");
        TestTasks.complete_reserves.add(1,"Chores,0000-00-00,Incomplete");
        TestTasks.complete_reserves.add(2,"Homework,0000-00-00,Complete");

        TestTasks.incomplete_reserves.add(0,"Practice,5555-55-55,Complete");
        TestTasks.incomplete_reserves.add(1,"Chores,0000-00-00,Incomplete");
        TestTasks.incomplete_reserves.add(2,"Homework,0000-00-00,Complete");

        TestTasks.displayAllItemsReaction();

        assertEquals("Test,0000-00-00,Complete",TestTasks.items.get(0));
        assertEquals("Coding,3333-33-33,Incomplete",TestTasks.items.get(3));
        assertEquals("Practice,5555-55-55,Complete",TestTasks.items.get(6));

        assertEquals(0,TestTasks.complete_reserves.size());
        assertEquals(0,TestTasks.incomplete_reserves.size());


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

}
