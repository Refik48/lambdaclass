package day04_reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class C10_ListeyiBuyukHarfYap {
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
        buyukListe(liste);
        System.out.println("\nOrjinal Liste Degismedi : " + liste);
        // IMMUTABLE OLDUKLARI ICIN ORJINAL LISTE DEGISMEZ.
    }

    public static void buyukListe(List<String> liste) {
        liste.stream().map(String::toUpperCase).forEach(x-> System.out.print(x + " "));
        System.out.println("\n===============MAP'IN ICINI FARKLI YAPABILIRIZ=================");
        liste.stream().map(x->x.toUpperCase()).forEach(x-> System.out.print(x + " "));
        // toUpperCase icinde Locale.ROOT yazdi silebiliriz.
    }
}
