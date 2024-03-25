package com.winfred.contactsmanagerapp.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.winfred.contactsmanagerapp.Entity.Contacts;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert
    void insert(Contacts contact);

    @Delete
    void delete(Contacts contact);

    @Query("SELECT * FROM contacts_table")
    List<Contacts> getAllContacts();
}
