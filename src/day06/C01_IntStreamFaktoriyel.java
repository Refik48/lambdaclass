package day06;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class C01_IntStreamFaktoriyel {
    public static void main(String[] args) {
        // Belirtilen sayinin faktoriyelini hesaplayan method'u yazin.
        faktoriyel(5);
        System.out.println(faktoriyel2(7));

    }
    public static void faktoriyel(int sayi) {
        System.out.println(IntStream.rangeClosed(1,sayi).reduce(1,(x,y)->x*y));
        // Belli bir yere carpiyor daha sonrasinda "-" negatif degere donuyor cunku int'de sinirli bir sekilde
        // Sinir degerini yukseltmek icin IntStream yerine IntLong, daha da buyuk icin IntDouble kullanabiliriz.
        // Eger Double'den daha buyuk bir sinir degeri kullanmak istersek daha yeni Java'ya giren
        // "BigInteger" data type'inda calisabiliriz. Biraz teferruatli ve karisiktir arastirmak gerekiyor.
    }
    public static double faktoriyel2(int n) {
        return DoubleStream.iterate(1,t->t+1).limit(n).reduce(1,(x,y)->x*y);
        // n data type olarak int ve long olabiliyor bu method icin .
        // Cunku limit icerisine long veya int data type yazilabilir.
        // Double'da calisiyoruz diye n'yi double yaparsak limit'den hata verir.
    }


}
