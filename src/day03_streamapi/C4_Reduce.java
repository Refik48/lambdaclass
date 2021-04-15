package day03_streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class C4_Reduce {

    public static void main(String[] args) {
        // ORNEK : Bir listeyi parametre olarak alan ve
        // listedeki tek sayilarin kuplerinin toplamini hesaplayan method'u yaziniz.
        // Tek kareler -> filter ||| kareler -> map ||| toplamini hesaplamak -> reduce ifade ediyor.
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
        System.out.println("TOPLAM : " + tekKupToplami(liste)); // Bir deger dondurecek o yuzden sout icinde yazdim.
        // Yukarda Lambda fonksiyonunu kullanarak yaptim.
        // Asagida Math kutuphanesinden addExact fonksiyonu ile yaptim
        System.out.println("Math Kutuphanesinde addExact ile : " + tekKupToplami2(liste));
        // Asagida Integer kutuphanesinden sum fonksiyonu ile yaptim.
        System.out.println("Integer Kutuphanesinden sum ile : " + tekKupToplami3(liste));
        // Optional yazisini kaldirmak icin baslangic deger (identity) atamalisin. Alttaki method'da yaptigim gibi.
        System.out.println("Optional yazisi olmadan Kutuphaneden Method kullanma : " + tekKupToplami4(liste));

    }

    public static int tekKupToplami(List<Integer> l) {
        return l.stream().filter(x->x%2==1).map(x->x*x*x).reduce(0,(x,y)-> (x+y)); // 7030
       /* Stream01_Integer::tekMi diger class'daki method'u cagirdim bununla.
        reduce(identity: 0, (x,y)-> (x+y) nedir ?
        identity: 0 baslangic degerimiz , (x,y)-> (x+y) ise Lambda .
        Burada 2 parametremiz var ve baslangic degerimiz var.
        Baslangic degerimiz 0 cunku daha hic bir islem yapmadim, ben baslangici 0'dan baslattim
        istersem baska bir degerden baslatabilirdim.

        Listemiz tek tek filterden gecti, gecen elemanlarin kupleri alindi . Suan elimizde su degerler var :
        729 (9'un kupu) , 2917 (13'un kupu) , 729 (9'un kupu) , 3375 (15'in kupu)
        indetitiy: 0,(x,y)-> (x+y)   Burada ardisik toplama yapacagiz ama sistem nasil isliyor ?
        Baslangic deger + Islemden cikmis deger = Yeni Baslangic Degeri
        0 + 729 = 729
        729 + 2917 = 3646
        3646 + 729 = 4375
        4375 + 3375 = 7750 daha baska eleman kalmadigi icin sonucu yazdiriyor en son.
       */
   }
    public static Optional<Integer> tekKupToplami2(List<Integer> l) {
        return l.stream().filter(x->x%2==1).map(x->x*x*x).reduce(Math::addExact); // 7030
        /* Math Java'da matematik kutuphanesi Math'in altinda bir suru fonksiyon (Method) mevcut.
         Burada addExact'i kullaniyoruz, toplama islemini yapmamizi sagliyor.
         Hata veriyor ustune geldim Optional<Integer> yapti.
         Optional bir nesne tipidir. Amaci : Null Exception'la ugrasmamak icin kullaniyoruz.
         Sonuc ekraninda da Optional diye yaziyor. Peki ben bu gozuksun istemiyorsam Optionalsiz nasil cozerim ?
         Eger bir baslangic deger atarsak identity ile Java optional kullanmayi zorunlu kilmiyor.
         */
    }
    public static Optional<Integer> tekKupToplami3(List<Integer> l) {
        return l.stream().filter(x->x%2==1).map(x->x*x*x).reduce(Integer::sum); // 7030
        // Integer Kutuphanesinden sum method'unu kullandim, baslangic degerim olmadigi icin Optional yaptim/
    }

    public static Integer tekKupToplami4(List<Integer> l) { // OPTIONAL'I KALDIRMAK ICIN :
        return l.stream().filter(C4_Reduce::tekMi).map(C4_Reduce::kupu).reduce(0, Integer::sum);
        // filter ve map icini methodcall ile yapmak zorunlu degil sadece elim alissin diye yazdim.
        // Optional'i kaldirmak icin identity: 0 yazdim ve optional'e gerek kalmadi.
        // Sadece Integer kutuphanesi icin degil Math kutuphanesi icinde baslangic degeri ile optional'den kurtulabilirim.
    }
    public static boolean tekMi(int x){
        return x % 2 != 0;
    }
    public static int kupu(int x){
        return x*x*x;
    }



}

