package day03_streamapi;

public class Sozeller {

    /*
     - Stream API icerisinde hazir yazilmis bir cok HOF (High Order Function) vardir. filter(), foreach(), map() vb.
     HOF'lar ile buyuk miktarda veri iceren Collection'lari isliyoruz. Ozellikle pipeline teknigi ile arka arkaya
     yuklu miktardaki kolay bir bicimde verileri isleyebiliyorum. Herhangi bir collection'i Stream fonksiyonu(Method'u) ile
     Stream'e uygun hale getiriyoruz. Normalde bir collection yatay haldedir, Stream bunu dikey hale getiriyor ve tek tek
     alinabilir hale getiriyor. Daha sonrasinda belirli sayida ara islmelerle (0, n kadar) filter,map,distinct, vb. ara islemlerle
     arka arkaya verileri isliyoruz ve Stream'i kapatan Terminal Operator ile foreach,count,reduce vb. islemlerle bitiriyoruz.

     - Ornek olarak : Bizim bir listemiz var diyelim, Pipeline mantigi olarak ;
     liste.stream() => Stream'e ceviriyorum
     liste.stream().filter((x) -> x>10) => Burada filtreleme yaparak 10'dan buyuk sayilari aliriz.
     liste.stream().filter((x) -> x>10).foreach(sout) => Burada Termianl Operator'u olan foreach ile bitirdik.
     Eger biz bir Terminal Operator'u kullanmazsak, buradaki islemler yapilmayacaktir.

     - Pipeline diyor ki ben son adim olan Terminal Operator'unu goreyim de ona gore calisayim.
     Terminal operator'u olmadan Pipeline calismaz. Cunku pipeline'i sonlandiriyor, hesaplari yaptiriyor ve
     islemleri bitirerek yazdiriyor.

     - Filter (Ara islemler) kismi LAZY, terminal (Bitirici) kismi EAGER'dir.
     Terminal islemler'in EAGER olmamasinin sebebi son noktayi koyup, islemleri bitirmesinden kaynaklaniyor.
     Filter'in Lazy olmasinin sebebi ise zaman kaybetmemektir, milyonlarca veriyi bosu bosuna islememek adina
     once bir filter yaparak gerekli olanlari aliyoruz.

     - Stream'lerde ara islemler, tembel(lazy) olarak yurutulur. Yani terminal islemi cagirlama kadar kosturulmazlar.
     Sadece yeni bir Stream nesene hazirlarlar. Terminal islemi cagrildiginda ise bu Stream'ler alinarak tek tek
     ara islemler gerceklesterilir ve sonuc olusturulur.
     Stream'lerin buyuk veri gruplarinda calisacagi dusunuldugunde terminal islemlini cagrilmadan tum islemleri
     bastan yapmak zaman kaybina yol acabilir, belki de bazi islemlerdeki veriler hic kullanilmayacakti.
     Bu yuzden tembel davranmak daha efektif bir yontemdir.

     - Ara islemler nelerdir ?
     Ara islemler 0 ya da daha fazla olabilir.
     Islemlerin sirasi ozellikle buyuk miktardaki veriler icin onem arz eder. Once filtreleme(filter),
     sonra siralama (sort) ve degistirme (map).
     Buyuk miktardaki veriler icin "ParallelStream" kullanmak mantiklidir.
     Yaygin kullanilan ara islemler :
     1) filter() => filtrelemeyi sagliyor
     2) findFirst() => Bir seyin ilk bulundugu yeri bize soyler.
     3) map() => Bir diziyi, collection'i modifie edip, guncellememizi sagliyor.(Her elemanin 5 katini almak istiyoruz diyelim)
     4) sorted() => Verdigimiz collection'i siraliyoruz. Parantez icine bir sey yazmaksak Natural Order seklinde siralar
     ama parantez icine sart koyarsak ona gore siralama islemi yaptirabiliriz.
     5) distinct() => Tekrarli verileri engeller ve tekrarli veri sayisini 1'e dusurur.
     6) limit() => Sinirlama koyariz, suradan sonrasini al gibi.
     7) flatMap() => Birden fazla collection'i birlestirerek tek bir collection haline getirmemizi sagliyor.
     8) skip() => Sirala bir sekilde olabilir, olmayabilir ilk 5 elemani atla derken skip(5) kullanacagim mesela.
     Bunun gibi bir cok method vardir..

     - Terminal Islemler :
     Terminal islemi Stream nesnesini alir ve tuketir (EAGER).
     Sadece tek terminal islemi kullanilabilir.
     Yaygin kullanilan Terminal Islemler :
     1) forEach() => Verdigimiz sarta gore yazdirir, iterasyon yapar.
     2) collect() => Var olan verileri ayriyetten baska bir collection'a kopyalayip bu verileri saklayabilmemizi saglar.
     3) max() => Filtrelenmis veriler arasindan Max olani alir ve bize dondurur.
     4) min() => Filtrelenmis veriler arasindan Min olani alir ve bize dondurur.
     5) count() => Filtrelenmis veriler arasindan kac tane 5 var onu dondurur veya kac tane Nihat var onu dondurur.

     Burada yaptiklarimiz orjinal collection'i degistirmez.

     - Bir Stream nasil olusturulur ?
     Herhangi List, Set gibi bir Collection .stream() method'u ile, Stream'ler ile calisabilir hale gelir.
     List<Integer> liste = new ArrayList<>();
     liste.stream() Artik pipeline'a girebilir.
     Herhangi bit dizi Stream.of() method'u yardimiyla Stream'ler ile calisabilir hale gelir veya
     yeni bir Stream dogrudan olusturulabilir.

     Integer dizi [] = {3,1,4,1,5,9}; Var olan diziyi stream'e cevirdim.
     Stream<Integer> streamDizi = Stream.of(dizi)
     VEYA
     Stream<String> kisiler = Stream.of("Kazim", "Nihat", "Veli");
     Stream<Integer> rakamlar = Stream.of(1,2,3,4,5,6);
     Bu sekilde de stream hale getirip pipeline icerisine sokabilirim.

     - Ornek 1: (C1_CiftleriYazdir Class'inda cevabi)
     Bir listeyi parametre olarak alan ve listedeki cift elemanlari yan yana yazdiran method'u
     yapisal ve fonksiyonel olarak yazdirin.

     filter() : Stream'deki verileri icerisinde cagirilan fonksyiona gore filtreleyen Ara islem method'udur.
     forEach() : Gelen verilen tamami islenene (verile method'a gore) veya bir exception olusana kadar
     iterasyiona devam eder. Terminal islemdir, Stream'i kapatir.

     - Ornek 2 : (C2_Karesi CLass'inda Cevabi)
     Bir listeyi parametre olarak alan ve listedeki her tek sayinin karesini aralarinda bir bosluk
     birakarak konsola yazdiran method'u yazdirin.
         Stream->Filter->Map->forEach
     map() : Stream'deki verileri verilen method'a gore degistiren (transformasyon) ara islem method'udur.

     - Ornek 3 : (C3_Distinct CLass'inda Cevabi)
     Ornek 2'nin sonuc ekraninda tekrarsiz eden sayilari tekrarsiz hale getir. (Her sayidan 1 tane)

     - Reduce (Termianl operatoru)
     ORNEK 4 : (C4_Reduce Class'inda cevabi)
     Bir listeyi parametre olarak alan ve listedeki tek sayilarin kuplerinin toplamini hesaplayan method'u yaziniz.
     COZUMU : Tek kareler -> filter ||| kareler -> map ||| toplamini hesaplamak -> reduce ifade ediyor.

     - Reduce :
     Indirgeme (reduction) bir Stream'in bir ture veya bir primitive'e donusturulmesini saglayan bir terminal islemdir.
     Java 8 Stream API'de average(),sum(), min(), max(), ve count() gibi tanimlanmis bir cok indirgeme method'u bulunmaktadir.
     Bu method'lar ilgili islemleri gerceklestirip tek bir deger dondurmektedir.
     reduce() : Kendi indirgeme islemlerimizi tanimlayabilecegimiz genel amacli bir method'dur.


     */
}
