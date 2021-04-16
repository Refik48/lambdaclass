package day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C07_HerElemanUzunluguNedir {
    //  ÖRNEK24: Aşağıdaki formata göre listedeki her bir elemanın uzunluğunu yazdıran metodu yazınız.
    //  Ali: 3        Mark: 4       Amanda: 6     vb.
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
        uzunluklarNe(liste);
    }

    public static void uzunluklarNe(List<String> liste) {
        liste.stream().
                sorted(Comparator.comparing(String::length)). // Istedigimiz kurala gore siralama yapti.
                map(t-> t  + " : " + t.length() + " ").       // map'in icini istedigimiz gibi modifiye edebiliriz.
                forEach(x-> System.out.print(x+" "));
    }
}
