package day05;

import java.util.ArrayList;
import java.util.List;

public class C06_aBaslaObitir {
    public static void main(String[] args) {
        // Elemanlar "a" harfi ile bitiyor mu ?
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");
        aBaslaOBitir(liste,"A","o");

}

    public static void aBaslaOBitir(List<String> liste, String basla, String bitir) {
        liste.stream().filter(x-> x.startsWith(basla) && x.endsWith(bitir)).forEach(x-> System.out.println(x+" "));
    }
    }


