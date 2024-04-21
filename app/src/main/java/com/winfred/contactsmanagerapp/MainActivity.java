package com.winfred.contactsmanagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.winfred.contactsmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data Source
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();

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

        adapter = new MyAdapter(contactsArrayList);

        contactDatabase =ContactDatabase.getInstance(this);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        Contacts c1 = new Contacts("Hulo","hulo@gmail.com");

        viewModel.addNewContact(c1);

        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();

                for (Contacts c: contacts){
                    Log.v("TAGY", c.getName());

                    contactsArrayList.add(c);
                }

                adapter.notifyDataSetChanged();
            }
        });

        adapter=new MyAdapter(contactsArrayList);
        recyclerView.setAdapter(adapter);

        //swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                Contacts c =contactsArrayList.get(viewHolder.getAdapterPosition());

                viewModel.deleteContact(c);
            }
        }).attachToRecyclerView(recyclerView);

    }
}













