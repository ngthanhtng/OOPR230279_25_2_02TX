package utils;

import java.util.List;

public class LibraryUtils {

    // Tìm phần tử nhỏ nhất trong mảng Generic
    public static <T extends Comparable<T>> T findMin(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }

        return min;
    }

    // In tất cả phần tử trong List (Unbounded Wildcard)
    public static void printAll(List<? extends Object> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    // Copy từ src sang dest (PECS: Producer Extends, Consumer Super)
    public static <T> void copyList(List<? super T> dest, List<? extends T> src) {
        for (T item : src) {
            dest.add(item);
        }
    }
}