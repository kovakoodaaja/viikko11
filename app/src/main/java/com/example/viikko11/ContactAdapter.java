package com.example.viikko11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> contacts;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.contactviewholder, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Contact contact = contacts.get(position);

        holder.ContactIdName.setText(contact.getFullName());
        holder.ContactNumberName.setText(contact.getNumber());
        holder.ContactGroupName.setText(contact.getContactGroup());

        holder.ContactDelete.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            if (pos != RecyclerView.NO_POSITION) {
                ContactStorage.getInstance().removeContact(pos);
                notifyItemRemoved(pos);
            }
        });

        if (contact.isShowDetails()) {
            holder.ContactNumberName.setVisibility(View.VISIBLE);
            holder.ContactGroupName.setVisibility(View.VISIBLE);
        } else {
            holder.ContactNumberName.setVisibility(View.GONE);
            holder.ContactGroupName.setVisibility(View.GONE);
        }

        holder.ContactDetails.setOnClickListener(v -> {
            contact.setShowDetails(!contact.isShowDetails());
            notifyItemChanged(holder.getAdapterPosition());
        });
        }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
