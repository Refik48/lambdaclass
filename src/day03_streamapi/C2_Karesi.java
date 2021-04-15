package day03_streamapi;

import java.util.ArrayList;
import java.util.List;

public class C2_Karesi {
    public static void main(String[] args) {
        // Ornek 2 :
        // Bir listeyi parametre olarak alan ve listedeki her tek sayinin karesini aralarinda bir bosluk
        // birakarak konsola yazdiran method'u yazdirin.
        // map() => Bir diziyi, collection'i modifie edip, guncellememizi sagliyor.
        // Her elemanin 5 katini almak istiyoruz diyelim o zaman kullanacagiz, bu soruda karesi icin kullaniyoruz.
        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);
        karesiniAl(liste);
    }

    public static void karesiniAl(List<Integer> liste) {
        liste.stream().filter(x->x%2==1).map(x->x*x).forEach(x-> System.out.println(x + " "));
        System.out.println("\nVEYA");
        liste.stream().filter(C2_Karesi::tekMi).map(C2_Karesi::kare).forEach(C2_Karesi::yazdir);
    }

    public static boolean tekMi(Integer x) {
        return x%2==1;
    }

    public static int kare(Integer x) {
        return x*x;
    }

    public static void yazdir(Integer x) {
        System.out.println(x + " ");
    }
}