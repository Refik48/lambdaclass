package day07_StreamAPI_DosyaOkuma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.stream.Stream;

public class C01_Files {
    public static void main(String[] args) throws IOException {
        // Files.lines( ) method'u icerisine bir path aliyor. Path.of("dosyaYolu") Sekilde yaziliyor.
        System.out.println("=============Files Yazdirma=============");
        Stream<String> satirlar = Files.lines(Path.of("src/day07_StreamAPI_DosyaOkuma/mars.txt"));
        // Calismazsa butun path'i yapistir yoksa Path From Contect Root'u kopyala ve "TIRNAK" icinde yaz.
        // lines kismi hata veriyor bunu handle etmemiz lazim.
        // Yaziyi stream'e cevirdim ve methodlari kullanabilirim artik.
        satirlar.forEach(System.out::println);

        // Bir dosyadan okunan satirlari buyuk harf olarak konsola yazdilarim
        System.out.println("\n=============Hepsini Buyuk Harf Yapma=============");
        // satirlar.map(x->x.toUpperCase()).forEach(System.out::println);
        // IllegalStateException: stream has already been operated upon or closed Exception'i verdi.
        // Cunku her Stream'de bir kez terminal operatoru olabilir o yuzden yeniden olusturmamiz gerekmektedir.
        // Asagida atama yapmadan yazdim (Alternatif yol) , istersem yukarda ki gibi atamam yapabilirim.
        Files.lines(Path.of("src/day07_StreamAPI_DosyaOkuma/mars.txt")).
                map(x->x.toUpperCase()).forEach(System.out::println);
        System.out.println("\n=============Hepsini Buyuk Harf Yapma vol2=============");
        // path yolu yerine String path = "src/day07_StreamAPI_DosyaOkuma/mars.txt";
        String path = "src/day07_StreamAPI_DosyaOkuma/mars.txt";
        Files.lines(Paths.get(path)).map(String::toUpperCase).forEach(System.out::println);
        // Bu sekilde de yapabilirim. Ayni zaman da map'in icini de bu sekilde yapabiliriz .

        System.out.println("\n=============Sadece Ilk Satiri Yazdirma=============");
        // Dosyadan sadece ilk satiri okuyarak buyuk harf olarak konsola yazdiralim.
        Files.lines(Paths.get(path)).limit(1).forEach(System.out::println);
        
        System.out.println("\n=============Limit Yazilan Sayi Kadar Satiri Bize Yazdirir=============");
        Files.lines(Paths.get(path)).limit(2).forEach(System.out::println);

        System.out.println("\n=============Skip Yapilan Satir Esgecip Kalanlar Yazdirilir=============");
        Files.lines(Paths.get(path)).skip(1).forEach(System.out::println);
    }
}