package day04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C1_ReduceBuyukSayi {
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
        System.out.println(parametreliReduce(liste)); // Buyuk Sayi icin
        System.out.println(mathKutuphaneMax(liste)); // Buyuk sayi icin
        System.out.println(buyukSayi2(liste)); // Buyuk Sayi icin
        System.out.println(enKucuk(liste)); // Kucuk sayi icin
        System.out.println(toplamlari(liste));
        System.out.println(carpimlari(liste));
        System.out.println(kacTaneDokuzVarCount(liste));
        System.out.println(negatifSayilariListeYap(liste));
    }

    public static int parametreliReduce(List<Integer> liste) {
        System.out.println("Parametreli Reduce 32.satir");
        return liste.stream().reduce(0, (x,y)-> x>y ? x : y);
        // Burada filter ve map yok
    }
    public static int mathKutuphaneMax(List<Integer> liste) {
        System.out.println("Math Kutuphanesinden Max Method'lu Reduce 37.satir");
        return liste.stream().reduce(0, Math::max);
    }
    public static int buyukSayi2(List<Integer> liste) {
        System.out.println("Anlamadigim method 41.satir");
        return liste.stream().sorted().reduce(0,(x,y)->y);
    }
    public static int enKucuk(List<Integer> liste) {
        System.out.println("En Kucuk Sayi 45.satir");
        return liste.stream().reduce(0,(x,y)-> x<y ? x : y);
    }
    public static int toplamlari(List<Integer> liste) {
        System.out.println("Listenin Toplami 49.satir");
        return liste.stream().reduce(0,(x,y)-> x+y);
        // Toplamlari olacagi icin ilk elemanin etkisiz eleman olmali o yuzden 0 aldim.
    }
    public static int carpimlari(List<Integer> liste) {
        System.out.println("Listenin Carpimlari 54.satir");
        return liste.stream().reduce(1,(x,y)-> x*y);
        // Carpimlari olacagi icin ilk elemanin etkisiz eleman olmali o yuzden 1 aldim.
    }
    public static int kacTaneDokuzVarCount(List<Integer> liste) {
        System.out.println("Kac tane 9 elemani var COUNT ile 61.satir");
        // return (int) liste.stream().count();
        // Boyle yazdigimizda listenin elemanlarini saydir oncesinde filtrelemem gerekiyor
        return (int) liste.stream().filter(x-> x==9).count(); // Hata verdi ustune geldim cast int yaptim.
    }
    // Listedeki negatif sayıları yazdıran metodu yazalım.

    public static List<Integer> negatifSayilariListeYap(List<Integer> liste) {
        System.out.println("Negatif sayilari yeni bir liste yap 68.satir");
        return liste.stream().filter(x -> x<0).collect(Collectors.toList());
        /* Negatifleri secmek icin filtreye ihtiyacim var, x<0 olanlar varsa bunlari al filtrele diyorum.
         Filtreden gecenleri yeni bir liste yapacagim. Fakat Filtreden gecenler kalici halde durmuyorlar (immutable)
         forEach ile de negatif degerleri gorebiliriz fakat biz bu soruda Liste yap dedik o yuzden Collect kullaniyorum.
         Collect Nesnelerimizi yeni bir listeye aktarmamizi saglar.
        */
    }

}
