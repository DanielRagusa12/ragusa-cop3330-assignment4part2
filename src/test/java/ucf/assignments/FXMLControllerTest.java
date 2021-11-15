package ucf.assignments;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Daniel Ragusa
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FXMLControllerTest {

    @Test
    void isDateValid()
    {
        /*
        This test first creates a controller object.
        The test then calls isDateValid twice, the first time passing an incorrect date, and the second passing a correct date.
        The test asserts that the first call will return false, and the second return true.
         */
        FXMLController testController = new FXMLController();
        assertFalse(testController.isDateValid("0000-00-00"));
        assertTrue(testController.isDateValid("2021-11-11"));
    }

    @Test
    void isDescriptionValid()
    {
        /*
        This test first creates a controller object.
        The test then creates a string variable called test that is 257 characters long.
        The test then calls isDescriptionValid twice, the first time passing the 257-character description, and the second passing "Hello".
        If the function is working properly it should return false for the first call, and return true for the second.
        The test asserts this.
         */
        FXMLController testController = new FXMLController();
        String test="a";
        test=test.repeat(257);
        assertFalse(testController.isDescriptionValid(test));
        String test2="Hello";
        assertTrue(testController.isDescriptionValid(test2));

    }
}