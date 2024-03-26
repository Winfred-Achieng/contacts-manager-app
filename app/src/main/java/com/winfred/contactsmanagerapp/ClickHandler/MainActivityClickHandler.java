package com.winfred.contactsmanagerapp.ClickHandler;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.winfred.contactsmanagerapp.AddNewContactActivity;

public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onFabClicked(View view){
        Intent intent = new Intent(view.getContext(), AddNewContactActivity.class);
        context.startActivity(intent);

    }
}
