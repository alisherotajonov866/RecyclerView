package ru.startandroid.recyclerview;

public class Contact {

    // o'zgaruvchilarni tavsiflab oldik
    private String name;
    private String email;
    private String imageUrl;

    // konstruktor yaratdik
    public Contact(String name, String email, String imageUrl) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    /* getter va setter dan nima uchun foydalanamiz? >

    Biz yaratgan 'ContactsRecViewAdapter' classimizda 'contacts_list_item' o'zgaruvchilarini id sini o'ziga olgan private o'zgaruvchilarimiz bor
    biz ulardan foydalanishimiz kerak.

    get - methodi bizga o'zgaruvchining malumotini olish uchun yordam beradi
    set - esa shu o'zgaruvchining malumotini biz yuborgan malumotga o'zgartirishga yordam beradi

    biz bu projectimizda faqat get methodini foydalandik yani faqat bor malumotni oldik lekin
    malumotlarni o'zgartirishga urunmadik shuning uchun bizga set methodi zarur bo'lmadi
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // bu method obyektni matn ko'rinishida uzatilishini kafolatlaydi
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
