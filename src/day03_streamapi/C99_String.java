package day03_streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class C99_String {
    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");
        // Listedeki bas harf A ile baslayan isimleri yazdiran method'u tanimlayalim
        System.out.println("A ILE BASLAYANLAR");
        aHarfBaslayanlar(liste); // IMMUTABLE OLDUKLARI ICIN ORJINAL LISTE DEGISMEZ.
        System.out.println("HEPSINI BUYUK HARF YAP");
        isimleriBuyukHarfeCevir(liste);
    }

    public static void aHarfBaslayanlar(List<String> liste) {
        liste.stream().filter(x->x.startsWith("A")).forEach(System.out::println);
    }
    public static void isimleriBuyukHarfeCevir(List<String> liste) {
        liste.stream().map(x->x.toUpperCase()).forEach(System.out::println);
        // toUpperCase icinde Locale.ROOT yazdi silebiliriz.
    }

}
