package day04_reduce;

import java.util.ArrayList;
import java.util.List;

public class C04_KucukSayiReduce {
    public static void main(String[] args) {
        // Listenin elemanlarinin en kucugu nedir ?
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
        liste.add(-8);
        liste.add(-15);
        System.out.println(enKucukSayiReduce(liste)); // -15
        System.out.println(enKucukSayiMath(liste)); // -15
    }

    public static int enKucukSayiMath(List<Integer> liste) {
        return liste.stream().reduce(0,Math::min);
        // Math kutuphanesi ile listenin min degerini bulduk.
    }

    public static int enKucukSayiReduce(List<Integer> liste) {
        return liste.stream().reduce(0,(x,y)-> x < y ? x : y );
        // Baslangic degeri 0 ile listenin en kucuk elemanini bulduk,
        // Listeye gore baslangic degerini almaya dikkat et.
    }
}