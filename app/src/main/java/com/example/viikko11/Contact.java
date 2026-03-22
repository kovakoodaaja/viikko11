package com.example.viikko11;

public class Contact {
    private String firstName;
    private String lastName;
    private String number;
    private String contactGroup;
    private boolean showDetails = false;


    public Contact(String firstName, String lastName, String number, String contactGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.contactGroup = contactGroup;
    }

    public boolean isShowDetails() {
        return showDetails;
    }

    public void setShowDetails(boolean showDetails) {
        this.showDetails = showDetails;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getContactGroup() {
        return contactGroup;
    }
}
