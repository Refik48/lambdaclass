package day04_reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class C09_aHarfiIleBaslayanlar {
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
        System.out.println("Orjinal Liste Degismedi : " + liste);
    }

    public static void aHarfBaslayanlar(List<String> liste) {
        liste.stream().filter(x->x.startsWith("A")).forEach(System.out::println);
    }

}
