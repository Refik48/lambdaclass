package day05;

import java.util.ArrayList;
import java.util.List;

public class C02_BelirtilenUzunlugaSirala {
    public static void main(String[] args) {
        // Elemanlarin uzunluklari belirtilen uzunluktan fazla ise bunlari yazdiran method'u tanimlayalim.
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");
        beliritilenUzunluk(liste, 5);
    }
    public static void beliritilenUzunluk(List<String> liste, int uzunluk) {
        liste.stream().filter(x->x.length() > uzunluk).forEach(x-> System.out.print(x+ " "));
    }
}
