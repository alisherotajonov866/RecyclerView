package ru.startandroid.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

// Biz yaratgan adapter classimiz RecyclerView ning Adapter idan meros oldi
public class ContactsRecViewAdapter extends RecyclerView.Adapter<ContactsRecViewAdapter.ViewHolder> {

    // arrayList dan obyekt oldik, malumotlar shunda turadi va undan adapter orqali view ga uzatamiz
    private ArrayList<Contact> contacts = new ArrayList<>();

    // Context - dasturning resurslariga kirish, fayl tizimiga kirish,
    // Activity ga qo'ng'iroq qilish va boshqa shu kabi asosiy funksiyalarga kirishni ta'minlovchi obyekt.
    private Context context;

    public ContactsRecViewAdapter(Context context) {
        this.context = context;
    }

    /*
    ViewHolder element ko'rinishini va uning RecyclerView ichidagi o'rni haqidagi maluumotlarni tavsiflaydi, yani
    ViewHolder orqali recyclerView ichidagi elementlarning masalan pozitsiyasini, ularning nomini va shunga o'hshagan zarur malumotlarni olishimiz mumkun.
    holder - ushlagich
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater classi, XML formatidagi fayllar tarkibini mos keladigan View ob'ektlariga o'rnatish uchun ishlatiladi
        // LayoutInflater orqali contacts_list_item.xlm faylidan olgan fayllar tarkibini view ga o'zlashtiramiz
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);

        // view o'zgaruvchisidagi fayllar tarkibini ViewHolder dan olgan obyektimizga beramiz va uni qaytaramiz
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // onBindViewHolder > Belgilangan pozitsiyada ma'lumotlarni ko'rsatish uchun RecyclerView tomonidan chaqiriladi.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //
        holder.tvName.setText(contacts.get(position).getName());
        holder.tvEmail.setText(contacts.get(position).getEmail());
        holder.itemParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, contacts.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // ekranda rasmlarni ko'rsatish uchun xizmat qiladi
        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageUrl())
                .into(holder.ivImage);
    }

    // RecyclerView dagi elementlar sonini qaytaradi, biz u yerda arraylist obyektining size ni qaytarsak ham bo'laveradi
    @Override
    public int getItemCount() {
        return contacts.size();
    }

    // ArrayList uchun setter method yaratdik
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        // RecyclerView ga refresh barish uchun
        notifyDataSetChanged();
    }

    // ViewHolder classini yaratdik va RecyclerView ning ViewHolderidan meros oldik
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvEmail;
        private ImageView ivImage;
        private CardView itemParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            ivImage = itemView.findViewById(R.id.ivImage);
            itemParent = itemView.findViewById(R.id.itemParent);

        }
    }

}
