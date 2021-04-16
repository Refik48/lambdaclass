package day05;

import java.util.ArrayList;
import java.util.List;

public class C08_IgnoreCase {
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
        lowerCaseMethod(liste, "c");
        ignoreCaseMethod(liste);
    }
    public static void lowerCaseMethod(List<String> liste, String basla) {
        liste.stream().map(String::toLowerCase).
                filter(x->x.startsWith(basla)). // DIKKAT !! toLowerCase OLDUGU ICIN "a" OLMAK ZORUNDA
                forEach(x-> System.out.println("c ile baslayan : "+x+" ")); // toUpperCase OLSAYDI "A" OLURDU.
    }
    public static void ignoreCaseMethod (List<String> liste) {
        System.out.println("IGNORE CASE 26. SATIR");
        liste.stream().
                filter(t->t.substring(0, 1).equalsIgnoreCase("a")).
                forEach(System.out::println);
    }
}
