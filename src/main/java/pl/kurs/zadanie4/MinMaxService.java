package pl.kurs.zadanie4;

import java.util.Comparator;
import java.util.List;

public class MinMaxService {
    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements != null) {
            T minValue = elements.stream().min(Comparator.naturalOrder()).get();
            T maxValue = elements.stream().max(Comparator.naturalOrder()).get();
            return new MinMax<>(minValue, maxValue);
        } else
            return null;
    }
}
