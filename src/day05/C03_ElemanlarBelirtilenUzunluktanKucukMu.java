package day05;

import java.util.ArrayList;
import java.util.List;

public class C03_ElemanlarBelirtilenUzunluktanKucukMu {
    public static void main(String[] args) {
        // Listedeki tum elemanlarin uzunluklari belirtilen uzunluktan
        // kucuk mu diye kontrol eden method'u yaziniz
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Christ");
        System.out.print("Tum elemanlar belirtilen degerden kucuk mu ? : ");
        System.out.println(belirtilenUzunluktanKucukMu(liste,9));
        // Hepsi 9 uzunluktan kucuk old. icin true dondu ama 1 tanesi bile uzun olsaydi false olurdu
        System.out.println("5 Uzunlugundna kucuk mu : " + belirtilenUzunluktanKucukMu2(liste,5));
}
    public static boolean belirtilenUzunluktanKucukMu(List<String> liste, int uzunluk) {
        return liste.stream().allMatch(x -> x.length() < uzunluk);
        // Icinde belirttigimiz sarta gore icerige bakiyor ve HEPSI DOGRU ISE "true",
        // 1 TANESI BILE DEGILSE "false" donduruyor.
    }
    public static boolean belirtilenUzunluktanKucukMu2(List<String> liste, int uzunluk) {
        return liste.stream().allMatch(x -> x.length() < uzunluk);
    }
}
