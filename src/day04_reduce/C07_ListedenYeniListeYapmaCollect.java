package day04_reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C07_ListedenYeniListeYapmaCollect {
    public static void main(String[] args) {
        // Listenin negatif elemanlarini yeni bir liste yapiniz .
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
        liste.add(-8);
        liste.add(-15);
        List<Integer> negatifListe = negatif(liste);
        System.out.println(negatifListe);
    }

    public static List<Integer> negatif(List<Integer> liste) {
        return liste.stream().filter(x -> x<0).collect(Collectors.toList());
         /* Negatifleri secmek icin filtreye ihtiyacim var, x<0 olanlar varsa bunlari al filtrele diyorum.
         Filtreden gecenleri yeni bir liste yapacagim. Fakat Filtreden gecenler kalici halde durmuyorlar (immutable)
         forEach ile de negatif degerleri gorebiliriz fakat biz bu soruda Liste yap dedik o yuzden Collect kullaniyorum.
         Collect() => Var olan verileri ayriyetten baska bir collection'a
         kopyalayip bu verileri saklayabilmemizi saglar.
         */
    }
}
