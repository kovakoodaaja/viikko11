package com.example.viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    RecyclerView ListContactsRV;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ListContactsRV = findViewById(R.id.ListContactsRV);
            ListContactsRV.setLayoutManager(new LinearLayoutManager(this));
        }

        @Override
        protected void onResume() {
            super.onResume();

            ContactAdapter adapter =
                    new ContactAdapter(ContactStorage.getInstance().getContacts());

            ListContactsRV.setAdapter(adapter);
        }

        public void goToAddContact(View view) {
            Intent intent = new Intent(this, AddContactActivity.class);
            startActivity(intent);
        }

        public void sortAlphabetically(View view) {
            Collections.sort(ContactStorage.getInstance().getContacts(),
                    (c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));

            ListContactsRV.getAdapter().notifyDataSetChanged();
        }

        public void sortByGroup(View view) {
            ArrayList<Contact> original = ContactStorage.getInstance().getContacts();

            ArrayList<Contact> work = new ArrayList<>();
            ArrayList<Contact> personal = new ArrayList<>();

            for (Contact c : original) {
                if (c.getContactGroup().equals("Työt")) {
                    work.add(c);
                } else {
                    personal.add(c);
                }
            }

            original.clear();
            original.addAll(work);
            original.addAll(personal);

            ListContactsRV.getAdapter().notifyDataSetChanged();
    }
}