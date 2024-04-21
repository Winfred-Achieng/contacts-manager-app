package com.winfred.contactsmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Context context;
    Contacts contact;
    MyViewModel viewModel;

    public AddNewContactClickHandler(Context context, Contacts contact,MyViewModel viewModel) {
        this.context = context;
        this.contact = contact;
        this.viewModel =viewModel;
    }

    public void onSubmitBtnClicked(View view){

        if (contact.getName() == null || contact.getEmail()==null){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(context, MainActivity.class);
//            intent.putExtra("Name",contact.getName());
//            intent.putExtra("Email",contact.getEmail());

            Contacts c = new Contacts(contact.getName(), contact.getEmail());

            viewModel.addNewContact(c);

            context.startActivity(intent);
        }

    }
}
