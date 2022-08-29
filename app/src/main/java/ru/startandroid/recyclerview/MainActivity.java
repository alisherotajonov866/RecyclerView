package ru.startandroid.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // recyclerView o'zgaruvshini tavsifladik
    RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // o'zgaruvchiga recyclerView ning id sini o'zlashtirdik
        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Alisher Otajonov", "alisherotajonov866", "https://media.istockphoto.com/photos/portrait-of-handsome-smiling-young-man-with-crossed-arms-picture-id1200677760?k=20&m=1200677760&s=612x612&w=0&h=JCqytPoHb6bQqU9bq6gsWT2EX1G5chlW5aNK81Kh4Lg="));
        contacts.add(new Contact("Boltayev Diyorbek", "boltayevdiyorbek", "https://thumbs.dreamstime.com/b/portrait-handsome-smiling-young-man-folded-arms-isolated-gray-background-joyful-cheerful-men-crossed-hands-studio-shot-172868988.jpg"));
        contacts.add(new Contact("Xojaniyozov Fayzulla", "xojaniyozovfayzulla", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJm3r9vdxYJokVgk7-W0omVsHI_OLMPqBZVs3Jy2NlMEgBNiXJcq721mi-f9FDqjiNBSc&usqp=CAU"));
        contacts.add(new Contact("Ruzimov Jasur", "ruzimovjasur", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmU7w8sUBJjgIqm1xSankH-wL5ALjMCGJ51EPIdyhXi6_s95hpdy6PCaBSy5y877tzfHw&usqp=CAU"));
        contacts.add(new Contact("Boltayev Abror", "abrorboltayev", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYkDBYkvHPH0H25Wwtfn1bZtoiV5ZYScDw81J9vQtyfStE4jALWn4g9Jf3PDCf3IbnlOc&usqp=CAU"));

        // ContactsRecViewAdapter classiga array listdan olinga contacts obyektiga qo'shilgan malumotlarni yubordik
        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        // adapterdagi malumotlarni asosiy oynamizga yani recyclerView ga uzatdik
        contactsRecView.setAdapter(adapter);

        // RecyclerView dagi elementlar qanday ko'rinishini shu yerdan ko'rsatishimiz mumkun bo'ladi
        // biz bu dasturda recyclerView ichidagi item lar 2 ustunga joylashishini yozdik
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));

    }
}