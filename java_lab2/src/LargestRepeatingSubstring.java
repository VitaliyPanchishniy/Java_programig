import java.util.Arrays;
import java.util.Scanner;

public class LargestRepeatingSubstring {

    // Функція для знаходження найбільшої повторюваної підстроки
    public static String findLargestRepeatingSubstring(String str) {
        int n = str.length();
        String largestRepeatedSubstring = "";

        // Створюється масив для збереження всіх суфіксів
        String[] suffixes = new String[n];

        // Заповнюємо масив суфіксів
        for (int i = 0; i < n; i++) {
            suffixes[i] = str.substring(i, n);
        }

        // Сортуємо суфікси
        Arrays.sort(suffixes);



        // Проходимо по всім сусіднім суфіксам і шукаємо найбільший спільний префікс
        for (int i = 0; i < n - 1; i++) {
            String commonPrefix = findPrefix(suffixes[i], suffixes[i + 1]);
            if (commonPrefix.length() > largestRepeatedSubstring.length()) {
                largestRepeatedSubstring = commonPrefix;
            }
        }

        return largestRepeatedSubstring;
    }

    // Функція для знаходження спільного префікса між двома рядками (тут мені допоміг GPT)
    private static String findPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, minLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String result = findLargestRepeatingSubstring(str);
        System.out.println("Найбільша повторювана підстрока: " + result);
    }
}