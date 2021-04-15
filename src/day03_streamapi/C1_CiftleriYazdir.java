package day03_streamapi;

import java.util.ArrayList;
import java.util.List;

public class C1_CiftleriYazdir {
    public static void main(String[] args) {
       // Ornek 1:
       // Bir listeyi parametre olarak alan ve listedeki cift elemanlari yan yana yazdiran method'u
       // yapisal ve fonksiyonel olarak yazdirin.

        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);
        ciftleriYazdir(liste);

    }

    public static void ciftleriYazdir(List<Integer> liste) {
        liste.stream().filter(x-> x%2==0).forEach(x-> System.out.print(x + " "));
        System.out.println("\nVEYA");
        liste.stream().filter(x-> x%2==0).forEach(System.out::print);
        System.out.println("\nVEYA");
        liste.stream().filter(C1_CiftleriYazdir::ciftMi).forEach(C1_CiftleriYazdir::yazdir);
    }

    public static void yazdir(Integer x) {
        System.out.print(x + " ");
    }
    public static boolean ciftMi(Integer a) {
        return a%2==0;
    }
}
