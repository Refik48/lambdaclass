package fonksiyonel01;

import java.util.Arrays;
import java.util.List;

public class LambdaKurallar01 {
    public static void main(String[] args) {

        List<Integer> Liste = Arrays.asList(1,2,3,4,5);
        Liste.forEach (x -> System.out.println(x));

    }
}
