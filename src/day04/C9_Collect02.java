package day04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C9_Collect02 {
    public static void main(String[] args) {
        // Listenin tek elemanlarin karelerini sirali olarak ve tekrarsiz bir sekilde listeye kaydeden method'u yaziniz.
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
        List<Integer> liste2 = tekKareSiraTekrarsiz(liste);
        System.out.println("25.Satir" + liste2);
        System.out.println("26. Satir" + tersSirala(liste));
        List<Integer> powList = powMethodKaresiAlma(liste);
        System.out.println("28. Satir" + powList);
    }

    public static List<Integer> tekKareSiraTekrarsiz(List<Integer> liste) {
        return liste.stream().sorted().filter(x->x%2==1).map(x->x*x).distinct().collect(Collectors.toList());
        // Distinct'i nerede kullabacagina dikkat et cunku -2 ile 2'nin karesi ayni fakat -2 ile 2 ayni sayi degil
        // Ilk basta distinct yazarsak iki tane 4'umuz olur ve distinct olmamis olur.
        // Distinct bir kez kullanilmak zorunda degildir hem basta hem sonda da kullanabiliriz.
    }
    public static List<Integer> tersSirala(List<Integer> liste) {
        return liste.stream().distinct().filter(x->x%2==1).map(x->x*x).distinct().
                sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    public static List<Integer> powMethodKaresiAlma(List <Integer> liste){
        return liste.
                stream().
                distinct().
                filter(x->x%2==1).
                map(x -> (int) Math.pow(x, 2)). // UST ALMA DEMEKTIR YANI BURASI ICIN KARESI
                distinct().
                sorted().
                collect(Collectors.toList());
    }
}
