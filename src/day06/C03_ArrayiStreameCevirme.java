package day06;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C03_ArrayiStreameCevirme {
    public static void main(String[] args) {
        // Bir double diziyi (notlar) Stream nesnesine donusturerek bu dizi icerisinde bulunan
        // sayilarin 50'dem buyuk olanlarini ayri bir listeye kaydederek yazdiran method'u tanimlayiniz.
        doubleDiziCevirList();
    }
    public static List<Double> doubleDiziCevirList(){
        Double [] notlar = { 88.5, 52.3, 88.9, 100.0, 99.6, 42.0, 10.0};
        Stream<Double> streamNotlar = Stream.of(notlar);
        // Normal double olan double turundeki Array'i , Stream haline donusturduk.
        // Artik Stream method'larin erisebiliyorum.
        return streamNotlar.filter(x->x>50.0).collect(Collectors.toList());
    }

}
