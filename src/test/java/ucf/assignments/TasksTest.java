package ucf.assignments;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Daniel Ragusa
 */

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {


    @org.junit.jupiter.api.Test
    void addNewItemReaction()
    {
        /*
        This test creates a description, and due date string to pass to addNewItemReaction.
        If the function works properly then the strings should be added to the items observable list with comma separation and with "Incomplete" added.
        The test asserts this.

         */
        Tasks TestTasks = new Tasks();
        String description="Test";
        String due_date= "0000-00-00";
        TestTasks.addNewItemReaction(description,due_date);

        assertEquals("Test,0000-00-00,Incomplete",TestTasks.items.get(0));


    }



    @org.junit.jupiter.api.Test
    void removeItemReaction()
    {
        /*
        This test first adds 3 items to the items observable list.
        It then calls removeItemReaction, passing 1.
        If the function works correctly it should remove the item from index 2, and the item from index 3 should now be in its place.
        The test asserts this.
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
        This test adds a new item to the items observable list.
        It then calls the editDescriptionReaction, passing 0 as the index, and "It Worked" as the new description.
        If the function works properly it should replace the current description "Test", with "It Worked", and the rest of the string should be unchanged.
        The test asserts this.
         */
        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Incomplete");
        TestTasks.editDescriptionReaction(0,"It Worked");
        assertEquals("It Worked,0000-00-00,Incomplete",TestTasks.items.get(0));


    }

    @org.junit.jupiter.api.Test
    void editDueDateReaction()
    {
        /*
        This test adds a new item to the items observable list.
        It then calls the editDueDateReaction, passing 0 as the index, and "2222-22-22" as the new due date.
        If the function works properly it should replace the current due date "0000-00-00", with "2222-22-22", and the rest of the string should be unchanged.
        The test asserts this.
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
        This test adds a new item to the items observable list.
        It then calls markItemAsCompleteReaction passing 0 as the index.
        If the function works properly it should replace the current completion status "Incomplete", with "Complete", and the rest of the string should be unchanged.
        The test asserts this.
         */

        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Incomplete");
        TestTasks.markItemAsCompleteReaction(0);
        assertEquals("Test,0000-00-00,Complete",TestTasks.items.get(0));


        TestTasks.markItemAsCompleteReaction(0);


    }

    @org.junit.jupiter.api.Test
    void markItemAsIncompleteReaction()
    {
        /*
        This test adds a new item to the items observable list.
        It then calls markItemAsIncompleteReaction passing 0 as the index.
        If the function works properly it should replace the current completion status "Complete", with "Incomplete", and the rest of the string should be unchanged.
        The test asserts this.
         */
        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Complete");
        TestTasks.markItemAsIncompleteReaction(0);
        assertEquals("Test,0000-00-00,Incomplete",TestTasks.items.get(0));
    }

    @org.junit.jupiter.api.Test
    void clearAllItemsReaction()
    {
        /*
        This test starts by adding 3 new items to each observable list, items,complete reserves,and incomplete reserves.
        The test then calls clearAllItemsReaction.
        If the function works correctly it should clear all items from each observable list.
        The test asserts that the size of each list is now 0.
         */
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
        This test starts by adding 3 new items to each observable list, items,complete reserves,and incomplete reserves.
        The test then calls displayAllItemsReaction.
        If the function works correctly it should first add all complete reserves, and then incomplete reserves to the items observable list.
        This test asserts that the items observable list now holds complete_reserves[0], at items[3], and incomplete_reserves[0], at items[6].
        Lastly, the test asserts that the size of each reserve list is now 0.

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
        This test first adds three items to the items observable list.
        This test then calls the displayIncompletedItemsReaction function.
        If the function works correctly it should add both completed items into the complete reserves observable list.
        The test asserts this.
         */
        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Complete");
        TestTasks.items.add(1,"Chores,0000-00-00,Incomplete");
        TestTasks.items.add(2,"Homework,0000-00-00,Complete");

        TestTasks.displayIncompletedItemsReaction();

        assertEquals("Test,0000-00-00,Complete",TestTasks.complete_reserves.get(0));
        assertEquals("Homework,0000-00-00,Complete",TestTasks.complete_reserves.get(1));
    }

    @org.junit.jupiter.api.Test
    void displayCompletedItemsReaction()
    {
        /*
        This test first adds three items to the items observable list.
        This test then calls the displayCompletedItemsReaction function.
        If the function works correctly it should add the 1 incomplete item into the incomplete reserves observable list.
        The test asserts this.
         */
        Tasks TestTasks = new Tasks();
        TestTasks.items.add(0,"Test,0000-00-00,Complete");
        TestTasks.items.add(1,"Chores,0000-00-00,Incomplete");
        TestTasks.items.add(2,"Homework,0000-00-00,Complete");

        TestTasks.displayCompletedItemsReaction();

        assertEquals("Chores,0000-00-00,Incomplete",TestTasks.incomplete_reserves.get(0));

    }

    @org.junit.jupiter.api.Test
    void loadListReaction() throws IOException
    {
        /*
        This test will start by creating a new file called LoadTest.txt
        This file holds a string at it's first line "Chores,2222-12-12,Incomplete".
        This test then calls loadListReaction, passing the file.
        If the function is working correctly it should add the first line from the LoadTest text file into the first index of the items observable list.
        The test asserts this.
         */

        Tasks TestTasks = new Tasks();
        File file = new File("src/test/java/ucf/assignments/LoadTest.txt");
        TestTasks.loadListReaction(file);
        assertEquals("Chores,2222-12-12,Incomplete",TestTasks.items.get(0));

    }

    @org.junit.jupiter.api.Test
    void saveListReaction() throws IOException
    {
        /*
        This test will start by creating a new file called SaveTest.txt
        This file is empty.
        This test then adds a new item to index [0] of the items observable list.
        This test then calls saveListReaction, passing the file.
        If the function is working correctly it should write the string from index[0] of items to the first line of the SaveTest text file.
        The test asserts this.
         */
        Tasks TestTasks = new Tasks();
        File file = new File("src/test/java/ucf/assignments/SaveTest.txt");
        TestTasks.items.add(0,"Test,2021-12-12,Incomplete");
        TestTasks.saveListReaction(file);
        BufferedReader br = new BufferedReader(new FileReader(file));

        assertEquals("Test,2021-12-12,Incomplete",br.readLine());

    }

}
