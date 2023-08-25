package pl.kurs.zadanie4;

import java.util.Arrays;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 1, 5, 3, 4);
        List<String> strings = Arrays.asList("Ewa", "Ala", "Ola");

        MinMax<Integer> intigerMinMax = MinMaxService.getMinAndMax(integers);
        System.out.println(intigerMinMax.getMin());
        System.out.println(intigerMinMax.getMin().getClass());
        System.out.println(intigerMinMax.getMax());

        MinMax<String> stringMinMax = MinMaxService.getMinAndMax(strings);
        System.out.println(stringMinMax.getMin());
        System.out.println(stringMinMax.getMin().getClass());
        System.out.println(stringMinMax.getMax());


    }
}
