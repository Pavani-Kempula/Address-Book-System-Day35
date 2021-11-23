package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Test
    public void givenAddressbookDB_WhenInSameCity_ShouldReturnNumberOfContacts() {
        AddressBookService addressBookService = new AddressBookService();
        HashMap<String, Integer> sameCity = addressBookService.getContactHaveSameCity();
        Assert.assertEquals(3, sameCity.size());
    }

    @Test
    public void givenInsertEmployeeData_WhenInserted_shouldSyncWithDatabase() {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readFromDataBase();
        List<String> groups = new ArrayList<String>();
        groups.add("family");
        groups.add("friend");
        addressBookService.insertContactInDataBase("Sameer","Vaidya","Shriwardhan","Raigad","Maharashtra","402110",0000,"Vaidya@gmail.com",groups);
        Assert.assertTrue(addressBookService.checkSyncWithDB("rohit"));
    }
}