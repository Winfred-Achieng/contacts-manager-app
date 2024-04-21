package com.winfred.contactsmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.winfred.contactsmanagerapp.ContactDao;
import com.winfred.contactsmanagerapp.ContactDatabase;
import com.winfred.contactsmanagerapp.Contacts;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {
    //the available data sources: ->ROOM DB

    private final ContactDao contactDao;
    ExecutorService executor;    //for background DB operations
    Handler handler;    //for updating the UI


    public Repository(Application application) {
        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDao = contactDatabase.getContactDao();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }


    public void addContact(Contacts contact){  //methods in DAO executed from repository
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.insert(contact);
            }
        });

    }

    public void deleteContact(Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.delete(contact);
            }
        });

    }
    public LiveData<List<Contacts>> getAllContacts(){

        return contactDao.getAllContacts();
    }
}
