package com.example.viikko11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class AddContactActivity extends AppCompatActivity{
    EditText FirstNameEdit, LastNameEdit, PhoneNumberEdit;
    RadioGroup ContactTypeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        FirstNameEdit = findViewById(R.id.FirstNameEdit);
        LastNameEdit = findViewById(R.id.LastNameEdit);
        PhoneNumberEdit = findViewById(R.id.PhoneNumberEdit);
        ContactTypeRadioGroup = findViewById(R.id.ContactTypeRadioGroup);
    }

    public void addContact(View view) {
        String firstName = FirstNameEdit.getText().toString();
        String lastName = LastNameEdit.getText().toString();
        String number = PhoneNumberEdit.getText().toString();

        int selectedId = ContactTypeRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedButton = findViewById(selectedId);

        String group = selectedButton.getText().toString();

        Contact contact = new Contact(firstName, lastName, number, group);
        ContactStorage.getInstance().addContact(contact);

        finish(); // palaa takaisin MainActivityyn
    }
}
