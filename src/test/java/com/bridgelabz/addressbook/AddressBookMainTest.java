package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookMainTest {
    @Test
    public void givenReadFromDB_ShouldReturnListOfContacts() {
        AddressBookService addressBookService = new AddressBookService();
        List<PersonDetails> contactList  = addressBookService.readFromDataBase();
        Assert.assertEquals(4, contactList.size());
    }

    @Test
    public void givenUpadteEmployeeData_WhenUpdated_shouldSyncWithDatabase()
    {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readFromDataBase();
        addressBookService.updateContactInDataBase("Pavani",900000);
        Assert.assertTrue(addressBookService.checkSyncWithDB("Pavani"));
    }

    @Test
    public void givenAddressbookDB_WhenBetweenDates_ShouldReturnListOfContacts() {
        AddressBookService addressBookService = new AddressBookService();
        List<PersonDetails> contactList  = addressBookService.getContatctsAddedAfterdate("2020-1-1");
        Assert.assertEquals(4, contactList.size());
    }
}