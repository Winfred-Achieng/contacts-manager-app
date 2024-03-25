package com.winfred.contactsmanagerapp.Repository;

import com.winfred.contactsmanagerapp.Dao.ContactDao;
import com.winfred.contactsmanagerapp.Entity.Contacts;

import java.util.List;

public class Repository {
    //the available data sources: ->ROOM DB

    private final ContactDao contactDao;

    public Repository(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    //methods in DAO executed from repository
    public void addContact(Contacts contact){
        contactDao.insert(contact);
    }

    public void deleteContact(Contacts contact){
        contactDao.delete(contact);
    }
    public List<Contacts> getAllContacts(){
        return contactDao.getAllContacts();
    }
}
