package day04_reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class C01_BuyukSayiReduce {
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
        System.out.println(buyukSayiReduce(liste));
    }

    public static int buyukSayiReduce(List<Integer> liste) {
        return liste.stream().reduce(0,(x,y)-> x>y ? x : y);
        /* Buyuk sayiyi bulabilmek icin 2 parametreyi yani x ve y'yi karsilastiriyoruz.
          Eger ternary'den dolayi x > y olursa x'i, x !> y ise y'yi daha buyuk olarak goruyor ve
          hafizasinda tutuyor liste bitene kadar. Peki ilk karsilastirma nasil oluyor, hangi 2 parametreyi aliyor ?
          Burada baslangic degerimiz ilk parametremiz oluyor. Baslangic degerimizi ona gore secmeye ozen gosteriyoruz.
          Yani listenin elemanlari ile karsilastirma yaparken 0 ile 12'yi karsilastiriyor.
          12 daha buyuk oldugu icin 12'yi hafizada tutuyor. 12 ile 9'u karsilastiriyor,
          9 ile 13'u.... seklinde gidiyor ve en son hafizasindaki sayiyi ekrana veriyor.

          Burada identity 0 oldu fakat belki negatif degerler ile calisacagiz,
          o zaman daha dusuk baslangic deger almaliyiz.
          Baslangic degerini kucuk almak icin ;
           return liste.stream().reduce(Integer.MIN_VALUE,(x,y)-> x>y ? x : y);
          seklinde tanimlamada yapilabilir.

          Peki "identity" olmasa olur muydu ? Evet olurdu fakat bu sefer method'un return type'ini
          Optional<Integer> yapmak gerekiyor ve sonuc ekraninda Optinal[15] yaziyor .
          Asagiya nasil oldugunun halini yazdim.
          public static Optional<Integer> buyukSayi(List<Integer> liste) {
              return liste.stream().reduce((x,y)-> x>y ? x : y); }
          Burada map ve filter kullanmadik cunku filtrelenecek bir seye ihtiyacimiz yoktu
          ve map ile elemanlari degistirmeye ihtiyacimiz yoktu. Direkt reduce yaptik.
         */
    }
}
