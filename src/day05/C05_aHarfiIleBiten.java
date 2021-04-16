package day05;

import java.util.ArrayList;
import java.util.List;

public class C05_aHarfiIleBiten {
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
        System.out.println(aHarfiIleBitenler(liste,"k")); // k ile bitenler
}

    public static boolean aHarfiIleBitenler(List<String> liste, String harf) {
        return liste.stream().anyMatch(t->t.endsWith(harf));
        // Herhangi bir tanesi belirtilen harf ile ("k") ile bitiyorsa true dondurur.
        // Hic bir eleman k ile bitmiyorsa false donduruyor.
        // Herhangi bir sartin saglanip saglanmamasina bakar,
        // sart bir defa saglaniyorsa true dondurur, hic sagmanmiyorsa false.
    }
    }
