package day04_reduce;

import java.util.ArrayList;
import java.util.List;

public class C03_BuyukSayiSiralama {
    public static void main(String[] args) {
        // Listenin en buyuk sayisi hangisi ?
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
        System.out.println(siralamaIleBuyuk(liste));
    }

    public static int siralamaIleBuyuk(List<Integer> liste) {
        return liste.stream().sorted().reduce(0,(x,y)->y);
        /* Sorted ile listeyi en kucukten en buyuge siraladim.
         Daha sonra reduce ile Baslangic degerini 0 alarak su halde terminal operatorunu kullandim ;
         0,-15 -> 15,-8 -> -8,2 -> 2,4..... 13,15 -> 15 bu sekilde en buyuk degeri bulmus oldum.
         */
    }
}
