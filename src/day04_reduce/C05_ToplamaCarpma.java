package day04_reduce;

import java.util.ArrayList;
import java.util.List;

public class C05_ToplamaCarpma {
    public static void main(String[] args) {
        // Listenin elemanlarinin toplami ve carpimi ?
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
        System.out.println(toplam(liste)); // 57
        System.out.println(carpma(liste)); // 144068608
    }

    public static int toplam(List<Integer> liste) {
        return liste.stream().reduce(0, (x, y) -> x + y);
        /* Toplama islemi yapacagim icin baslangic degerini ona gore sectim, 0 Toplama isleminde etkisiz elemandir.
         Cunku 1. parametremizle 2. parametreyi toplayarak ilerleyecek ve burada 1. parametremiz
         identity:0 yazan yer yani 0'dir. Islem siramiz su sekilde ilerleyecektir ;
         0 + 12 = 12 , 12 + 9 = 21, .... Bu yuzden identity'nin ne secilecegi onemlidir.
         */

    }
    public static int carpma(List<Integer> liste) {
        return liste.stream().reduce(1,(x,y)-> x*y);
        // Burada da identity:1 aldik cunku carpma isleminde 1 etkisiz elemandir.
    }

}
