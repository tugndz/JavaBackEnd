package BaitapSetMap;

import java.util.*;

public class Set {
    public static void main(String[] args) {
        int[] arr = {5, 7, 5, 3, 7, 1, 9, 4, 2, 1, 6};

        System.out.println("Mang ban dau: " + Arrays.toString(arr));

        removeDuplicates(arr);
        sumUnique(arr);
        findCommonElements(arr);
        findMinMax(arr);
    }


    private static void removeDuplicates(int[] arr) {
        java.util.Set<Integer> unique = new LinkedHashSet<>();
        for (int x : arr) unique.add(x);

        System.out.println("\n=== (a) Loai bo phan tu trung lap ===");
        System.out.println("Cac phan tu duy nhat: " + unique);
    }


    private static void sumUnique(int[] arr) {
        java.util.Set<Integer> unique = new HashSet<>();
        for (int x : arr) unique.add(x);

        long sum = 0;
        for (int x : unique) sum += x;

        System.out.println("\n=== (b) Tong cac phan tu khong trung ===");
        System.out.println("Tong cac phan tu duy nhat: " + sum);
    }


    private static void findCommonElements(int[] arr) {
        int mid = arr.length / 2;
        int[] a1 =  {5, 7, 5, 3, 11, 12, 91, 41, 21, 19, 68};
        int[] a2 =  {5, 7, 5, 3, 7, 1, 9, 4, 2, 1, 6};

        java.util.Set<Integer> s1 = new HashSet<>();
        for (int x : a1) s1.add(x);
        java.util.Set<Integer> s2 = new HashSet<>();
        for (int x : a2) s2.add(x);

        s1.retainAll(s2);

        System.out.println("\n=== (c) Phan tu chung cua hai mang ===");
        System.out.println("Mang 1: " + Arrays.toString(a1));
        System.out.println("Mang 2: " + Arrays.toString(a2));
        System.out.println("Cac phan tu chung: " + s1);
    }


    private static void findMinMax(int[] arr) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : arr) {
            ts.add(x);
        }

        int min = ts.first();
        int max = ts.last();

        System.out.println("\n=== (d) Min & Max sau khi loai trung ===");
        System.out.println("Tap sau khi loai trung (sap xep): " + ts);
        System.out.println("Min = " + min + ", Max = " + max);
    }
}
