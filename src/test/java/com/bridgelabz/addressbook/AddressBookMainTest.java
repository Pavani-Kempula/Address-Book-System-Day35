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
}