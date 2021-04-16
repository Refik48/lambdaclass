package day04_reduce;

import java.util.ArrayList;
import java.util.List;

public class C02_BuyukSayiKutuphaneCagirma {
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
        System.out.println(buyukSayiMath(liste));
    }

    public static int buyukSayiMath(List<Integer> liste) {
        return liste.stream().reduce(0,Math::max);
        /*
          Burada Math Kutuphanesinden max method'u ile en buyuk sayiyi buldum.
          Neden identity: 0'a ihtiyacim oldu ? Bir onceki class ile ayni mantik ilk karsilastirilacak
          parametreye ihtiyacim vardi onun icin baslangic degeri atamak durumunda kaldim.
          Listeye gore sececegim baslangic degerine dikkat etmeliyiz.
          Baslangic degerini kucuk almak icin ;
           return liste.stream().reduce(Integer.MIN_VALUE,(x,y)-> x>y ? x : y);
          seklinde tanimlamada yapilabilir.
         */
    }
}
