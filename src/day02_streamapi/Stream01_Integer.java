package day02_streamapi;

import java.util.ArrayList;
import java.util.List;

public class Stream01_Integer {

    public static void main(String[] args) {

        List<Integer> rakamlar = new ArrayList<>();

        rakamlar.add(-2);
        rakamlar.add(-1);
        rakamlar.add(0);
        rakamlar.add(1);
        rakamlar.add(2);
        rakamlar.add(1); // Tekrarlida mevcut.
        rakamlar.add(2);
        rakamlar.add(3);
        rakamlar.add(4);
        rakamlar.add(5);
        rakamlar.add(6);
        rakamlar.add(7);
        rakamlar.add(8);
        rakamlar.add(9);
        System.out.println("Liste : " + rakamlar);

        System.out.println("FOR EACH ICINI t'li SOUT YAZMA");
        // Method cagirma olunca t'ye gerek yok fakat Klasik kullanim yaparsam ;
        rakamlar.stream().filter(t -> t%2 != 0).forEach(t -> System.out.print(t + " "));

        System.out.println("\n FOR EACH ICINDE SOUT'U METHOD CALL YAPMA");
        // Method call ile yazma ;
        rakamlar.stream().filter(t -> t%2 != 0).forEach(System.out :: print);
        // Cikan sonucta rakamlar bitisik yazilacaktir burada onlari ayiramam. Ayirmak istersem diger yollardan birinde
        // rakamlari ayirip, yanyana yazdirabilirim.
        // Burada aralarina bosluk koyamadim cunku method referans'da boyle bir secegim yok.
        // Bunun icin soyle bir yol tercih edebilirim. (Baska yollarda var)
        System.out.println("\nFILTER'I DEGISTIREREK TEK RAKAMLARI BULMA");
        rakamlar.stream().filter(t -> t%2 == 1).forEach(Stream01_Integer :: yazdir);

        System.out.println("\nMETHOD CALL ILE TEK RAKAMLARI BULMA");
        rakamlar.stream().filter(Stream01_Integer::tekMi).forEach(Stream01_Integer :: yazdir);
    }
    public static void yazdir(int t) {
        System.out.print(t+" "); // Bu sekilde olunca Method referans ile bosluklu yazdirmis oluyorum.
    }

    public static boolean tekMi (int x) {

        return x%2!=0;
    }

}
