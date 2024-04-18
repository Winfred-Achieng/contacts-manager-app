package com.winfred.contactsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomSQLiteQuery;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.winfred.contactsmanagerapp.Adapter.MyAdapter;
import com.winfred.contactsmanagerapp.ClickHandler.MainActivityClickHandler;
import com.winfred.contactsmanagerapp.Database.ContactDatabase;
import com.winfred.contactsmanagerapp.Entity.Contacts;
import com.winfred.contactsmanagerapp.ViewModel.MyViewModel;
import com.winfred.contactsmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data Source
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contacts = new ArrayList<>();

    //Adapter
    private MyAdapter adapter;

    //binding
    private ActivityMainBinding binding;
    private MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        handler= new MainActivityClickHandler(this);

        binding.setClickHandler(handler);


        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new MyAdapter(contacts);

        contactDatabase =ContactDatabase.getInstance(this);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        Contacts c1 = new Contacts("Hulo","hulo@gmail.com");

        viewModel.addNewContact(c1);

        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                for (Contacts c: contacts){
                    Log.v("TAGY", c.getName());
                }
            }
        });
    }
}













