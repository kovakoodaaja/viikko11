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
}