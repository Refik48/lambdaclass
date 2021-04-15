package day03_streamapi;

import java.util.ArrayList;
import java.util.List;

public class C3_Distinct {
    public static void main(String[] args) {
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
        distinctMet(liste);
    }

    public static void distinctMet(List<Integer> liste) {
        liste.stream().distinct().filter(x->x%2==1).map(x->x*x).forEach(x-> System.out.println(x + " "));
        // Distinct'i nerede kullanacagim ?
        // Distinct her asamada kullanilabilir, sorudan soruya gore nerede kullanmamiz konusunda karari biz verecegiz.
        // Burada en sonra distinct diyerek tekrar edenleri ayiklayabilirim ama en basta da ayiklayabilirim.
        // Burada farketmiyor ama Java gereksiz islem yapmasin diye en basta ayiklayacagim.

    }
}
