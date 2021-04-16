package day04_reduce;

import java.util.ArrayList;
import java.util.List;

public class C06_KacTaneDokuzSayisiVar {
    public static void main(String[] args) {
        // Listenin kac tane elemani var ?
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
        System.out.println(listeElemanSayisi(liste));
        System.out.println("Listede kac eleman old. boyle de bulunabiliyor : " + liste.size());
        System.out.println(kacTaneDokuzVar(liste));
    }

    public static int listeElemanSayisi(List<Integer> liste) {
        return (int) liste.stream().count(); // 11
        // Listede kac tane eleman oldugunu saydirdi.
    }

    public static int kacTaneDokuzVar(List<Integer> liste) {
        return (int) liste.stream().filter(x->x==9).count(); // 2
        // Hata verdi ustune gelip cast int yaptim.
    }
}
