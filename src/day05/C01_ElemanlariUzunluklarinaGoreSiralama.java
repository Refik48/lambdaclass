package day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C01_ElemanlariUzunluklarinaGoreSiralama {
    public static void main(String[] args) {
        // Listenin elemanlarini uzunluklarina gore siralayin ve kucuk harfe ceviren
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");
        uzunlukSiralama(liste); // IMMUTABLE OLDUKLARI ICIN ORJINAL LISTE DEGISMEZ.
        System.out.println("=========================================================");
    }

    public static void uzunlukSiralama(List<String> liste) {
        liste.stream().sorted(Comparator.comparing(x->x.length())).map(x->x.toLowerCase()).
                forEach(x-> System.out.print(x+" "));
        System.out.println("\n==================COMPARATOR ICI BOYLE YAZILABILIR=================");
        liste.stream().sorted(Comparator.comparing(String::length)).map(h->h.toLowerCase()).
                forEach(x-> System.out.print(x+" "));
        /*
          Eger sorted fonksiyonunu tek basina yazarsak natural order'a gore siralama yapar.
          Eger Comparator'den sonra .comparing yazarsam sonrasinda yazacagim lambda'ya gore
          siralama kuralini ben belirlemis olurum.
         */
    }
}
