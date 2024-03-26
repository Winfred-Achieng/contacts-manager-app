package com.winfred.contactsmanagerapp.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.winfred.contactsmanagerapp.Entity.Contacts;
import com.winfred.contactsmanagerapp.R;
import com.winfred.contactsmanagerapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private ArrayList<Contacts> contactList;

    public MyAdapter(ArrayList<Contacts> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.contact_list_item,parent,false);

        return new ContactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contacts currentContacts =contactList.get(position);

        holder.binding.setContact(currentContacts);

    }

    @Override
    public int getItemCount() {

        if (contactList !=null) {
            return contactList.size();
        }else {
            return 0;
        }
    }

    public void setContactList(ArrayList<Contacts> contactList) {
        this.contactList = contactList;

        notifyDataSetChanged();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        private ContactListItemBinding binding;
        public ContactViewHolder(@NonNull ContactListItemBinding binding) {
            super(binding.getRoot());
            this.binding =binding;

        }

    }

}
