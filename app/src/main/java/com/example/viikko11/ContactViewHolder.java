package com.example.viikko11;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    ImageView ContactDelete, ContactDetails;
    TextView ContactIdName, ContactNumberName, ContactGroupName;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        ContactIdName = itemView.findViewById(R.id.ContactNameText);
        ContactNumberName = itemView.findViewById(R.id.ContactNumberText);
        ContactGroupName = itemView.findViewById(R.id.ContactGroupText);
        ContactDelete = itemView.findViewById(R.id.ContactDelete);
        ContactDetails = itemView.findViewById(R.id.ContactDetails);
    }
}
