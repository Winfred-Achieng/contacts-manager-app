package com.winfred.contactsmanagerapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.winfred.contactsmanagerapp.Entity.Contacts;
import com.winfred.contactsmanagerapp.Repository.Repository;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private final Repository myRepository;

    private LiveData<List<Contacts>> contact;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository=new Repository(application);
    }

    public void addNewContact(Contacts contacts){
        myRepository.addContact(contacts);
    }

    public void deleteContact(Contacts contacts){
        myRepository.deleteContact(contacts);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        return myRepository.getAllContacts();
    }
}
