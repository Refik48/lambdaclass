package day05;

import java.util.ArrayList;
import java.util.List;

public class C04_aHarfiIleBaslamayanlar {
    public static void main(String[] args) {
        // Hangi elemanlar "a" harfi ile baslamiyor ?
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");
        aHarfiIleBaslamayanlar(liste,"A");
        System.out.println("\nB Harfi ile BASLAMAYAN var mi : " + baslamayanHarf(liste,"B")); // True
}

    public static void aHarfiIleBaslamayanlar(List<String> liste, String harf) {
        liste.stream().filter(x->!x.startsWith(harf)).forEach(x-> System.out.print(x + " "));
    }
    private static boolean baslamayanHarf(List<String> liste, String harf2) {
        return liste.stream().noneMatch(x->x.startsWith(harf2));
    }
    // NONEMATCH() Belirtilen sartları tüm elemanlar sağlamıyorsa "true" döndürür. yoksa "false"
    // B ile baslamayan var mi diye bakti ve olmadigi icin TRUE Dondurdu.
    }
