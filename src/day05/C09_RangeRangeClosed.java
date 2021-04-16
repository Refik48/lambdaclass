package day05;

import java.util.stream.IntStream;

public class C09_RangeRangeClosed {
    public static void main(String[] args) {
        /*
          Collection'larimizi stream method;u ile Stream'e cevirmeyi ogrendik.
          Collection : List,Map,HashMap vb..
          Stream'e cevirdikten sonra Stream API kullanarak pipeLine'a sokuyorduk.

          IntStream : Integer seklinde Stream olusturabiliriz.
          LongStream, DoubleStream
          Bunlarin ne artisi var ? Sayisal degerlerle islem yapacaksak isleri kolaylastiriyor.
          Biz istersek Integer, Double, Long tipinde Stream'ler olusturabiliyoruz.
         */

        // 1'den belirtilen degere kadar olan tamsayilari toplayan ve sonucu donduren method'u yaziniz.
        System.out.println("Toplamlari : "  + topla(4)); // 6
        // Range dersek 1 dahil oluyor fakar "deger" yazan yerdeki 4 dahil olmuyor o yuzden 6 cikiyor.
        // range(1,deger+1) dersem 4'u de dahil etmis olurum.

        System.out.println("Toplamlari : "  + topla2(4)); // 10
        // Eger biz rangeClosed(1,deger) yaptigimizda deger yazan yerdeki degeri de toplar.

        tekToplam(1,7);
    }

    public static int topla(int deger) {
        return IntStream.range(1,deger).sum();

    }
    public static int topla2(int deger) {
        return IntStream.rangeClosed(1,deger).sum();
    }
    public static void tekToplam(int baslangic, int bitis) {
        System.out.println(IntStream.rangeClosed(baslangic,bitis).filter(x->x%2==1).sum());
    }
    // Sum ile topladigim zaman terminal islemi yapmis oluyorum ve elimizde bir deger oluyor.
    // Ya return ile dondurecegiz ya da method icerisinde sout yapacagiz.
}
