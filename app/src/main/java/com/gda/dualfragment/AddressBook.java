package com.gda.dualfragment;

import java.util.ArrayList;

public class AddressBook {
    private static final AddressBook ourInstance = new AddressBook();
    private ArrayList<NameAndAdress> mNameAndAdresses;

    public static AddressBook getInstance() {
        return ourInstance;
    }

    private AddressBook() {
        mNameAndAdresses = new ArrayList<NameAndAdress>();

        NameAndAdress temp = new NameAndAdress("B Obama", "The White House",
                "Washington", "DC1");
        mNameAndAdresses.add(temp);
        temp = new NameAndAdress("V Putin", "The Kremlin",
                "Moscow", "MS1");
        mNameAndAdresses.add(temp);
        temp = new NameAndAdress("E Windsor", "Bukingham Palace",
                "London", "LN1");
        mNameAndAdresses.add(temp);
    }

    public ArrayList<NameAndAdress> getBook() {
        return mNameAndAdresses;
    }
}
