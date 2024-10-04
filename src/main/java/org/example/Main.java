package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Örnek Contact listesi ile başlıyoruz
        List<Contact> initialContacts = new ArrayList<>();
        initialContacts.add(new Contact("John Doe", "123123123"));
        initialContacts.add(new Contact("Jane Doe", "124124124"));
        initialContacts.add(new Contact("Baby Doe", "125125125"));

        // MobilePhone nesnesi oluşturuluyor
        MobilePhone myPhone = new MobilePhone("11111111", initialContacts);

        // İletişim listesi yazdırılıyor
        System.out.println("---- Contacts ----");
        myPhone.printContacts();

        // Yeni kişi ekleme
        Contact newContact = new Contact("Alice", "555555555");
        myPhone.addNewContact(newContact);

        // Güncelleme
        Contact updatedContact = new Contact("Alice", "999999999");
        myPhone.updateContact(newContact, updatedContact);

        // İletişim listesi tekrar yazdırılıyor
        System.out.println("\n---- Updated Contacts ----");
        myPhone.printContacts();

        // Market listesi başlatılıyor
        System.out.println("\n---- Grocery List ----");
        Grocery.addItems("banana, apple, orange");
        Grocery.addItems("banana, pear");
        Grocery.removeItems("orange");
        Grocery.printSorted();
    }
}
