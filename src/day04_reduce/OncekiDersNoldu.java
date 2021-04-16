package day04_reduce;

public class OncekiDersNoldu {
    /*
      Reduce : Icerisine 2 parametre alir(3. parametrede alir fakat ileri seviye icin o).
       Ilk parametre (identified) kismi bir sayidir, bu sayi baslangic sayisidir.
       2. parametresi Function Accumalator'dir, bu kisim Lambda yazilir ve yapilacak islem yazilir.
      Ornek olarak : reduce(0,(x,y)-> (x+y)); "0" 1. parametredir, "x,y" 2. parametredir.


      Map : Eger bir diziyi Transformasyona ugratacaksak, biz Map kullanilir.
      String'ler icin Nihat isimlerini cikarmak istiyoruz  diyelim,
      Integer da her elemani 4'le carp gibi.

      listemiz = {3,2,5,1,7,9} olsun
      Yani burada once 0 ile 3'u karsilastiriyor, 3'u baslangic degerine koyuyor,
      3 ile 2'yi karsilastiriyor 2!<3 oldugundan 3 kaliyor. Boyle Boyle en buyugu buluyor.
      liste.stream().reduce(identity: 0, (x,y) -> x>y ? x : y); Yazim sekli bu sekilde.
      liste.stream().reduce(identity: 0, Math::max); seklinde de olur.(Math yerine Integer olabilir yanlis yazmis olabilirim)
     */
}
