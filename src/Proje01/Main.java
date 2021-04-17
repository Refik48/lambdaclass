package Proje01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Ogrenci> ogrListesi = new ArrayList<>();

    public static void main(String[] args) {
        testOgrenciOlustur();
        ismeGoreListele("ahmet");
        // Ismi Ahmet olanlari gidip bulacak ignore case oldugu icin nasil yazdigimiz onemli degil.
        ismeGoreListele("ayse");
        ismeGoreListele("john"); // John ismi yok sonuc ekraninda da
        String flag = "Aradiginiz isim kayitlarimizda yok"; // Yapip if icinde flag yazdirabilirim.
    }
    private static void ismeGoreListele(String isim) {
        ogrListesi.stream().filter(x->x.getAd().equalsIgnoreCase(isim)).forEach(System.out::println);
        // x burada ogrenci nesnesidir, her elemanina ulasabiliyoruz.
        ogrListesi.stream().filter(x->!x.getAd().equalsIgnoreCase(isim)).
                forEach(x-> System.out.println("Aradiginiz isim kayitlarimizda yok"));
    }
    private static void testOgrenciOlustur() {
        // Ogrenci ogrListesi = new Ogrenci(); Bunun yerine asagiya new Ogreci yazinca aynisi oluyor.
        ogrListesi.add(new Ogrenci("Nihat", "Tekiner", 25, 88.4,"Erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ayse", "Can", 21, 82.3, "kadin"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ayse", "Yilmaz", 40, 45, "kadin"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "Ozturk", 20, 95.5, "erkek"));
    }
}
