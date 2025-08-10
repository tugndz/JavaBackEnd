package BaitapSetMap;

import java.util.*;

public class MapExercises {
    public static void main(String[] args) {
        String text = "java is fun and java is powerful and java is popular";
        countWordFrequency(text);

        String[] names = {"An", "Binh", "Chi", "An", "Dung", "Binh", "Hoa"};
        checkUniqueAndDuplicateNames(names);
    }


    private static void countWordFrequency(String text) {
        Map<String, Integer> wordCount = new HashMap<>();


        String[] words = text.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase(); // không phân biệt hoa thường
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n=== (a) Dem so lan xuat hien cua tung tu ===");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    private static void checkUniqueAndDuplicateNames(String[] names) {
        Map<String, Integer> nameCount = new HashMap<>();


        for (String name : names) {
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }

        List<String> uniqueNames = new ArrayList<>();
        List<String> duplicateNames = new ArrayList<>();


        for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueNames.add(entry.getKey());
            } else {
                duplicateNames.add(entry.getKey());
            }
        }

        System.out.println("\n=== (b) Kiem tra ten duy nhat va ten trung ===");
        System.out.println("Ten duy nhat: " + uniqueNames);
        System.out.println("Ten trung: " + duplicateNames);
    }
}
