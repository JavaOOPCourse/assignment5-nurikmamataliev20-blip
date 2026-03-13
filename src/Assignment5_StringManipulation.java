import java.sql.Array;
import java.util.*;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор:  ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        // TODO: Подсчитать количество гласных (a, e, i, o, u)
        int count = 0;
        ArrayList<Character> letters= new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(char c: input.toCharArray()){
            if(letters.contains(c)){
                count++;
            }
        }
        System.out.println("Number of  vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Вывести строку в обратном порядке
        String reversed = "";
        ArrayDeque<Character> letters= new ArrayDeque<>();
        for(char c: input.toCharArray()){
            letters.addFirst(c);
        }
        while(!letters.isEmpty()){
            reversed+=letters.poll();
        }
        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Проверить, является ли строка палиндромом (игнорировать регистр)
        boolean isPalindrome = false;
        LinkedList<Character> letters = new LinkedList<>();
        for(char c: input.toLowerCase().toCharArray()){
            letters.add(c);
        }
        while(letters.size()>1){
            if(letters.pollFirst()!=letters.pollLast()){
                isPalindrome=false;
            }else isPalindrome=true;
        }

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        ArrayList<String> words=new ArrayList<>(Arrays.asList(sentence.split("\\s+")));
        // TODO: Подсчитать количество слов в предложении
        int wordCount = 0;
        wordCount=words.size();
        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Удалить все пробелы из строки
        String noSpaces = "";
        for(char c: input.toCharArray()){
            if(c!=' '){
                noSpaces+=c;
            }
        }
        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        ArrayDeque<String> words = new ArrayDeque<>(Arrays.asList(sentence.split(" ")));
        // TODO: Преобразовать первую букву каждого слова в заглавную
        String result = "";
        for(String s: words){
            if(s.length()==0){
                result+=" ";
            }else {
                result += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
            }
        }
        System.out.println(result);
    }
    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Найти символ, который встречается чаще всего
        char mostFrequent = ' ';
        int mostfrequentint=0;
        HashMap<Character, Integer> checker= new HashMap<>();
        for(char c: input.toCharArray()){
            checker.put(c, checker.getOrDefault(c, 0)+1);
        }
        System.out.println(checker);
        for(Map.Entry<Character, Integer> entry: checker.entrySet()){
            Character key=entry.getKey();
            Integer value= entry.getValue();
            if(value>mostfrequentint){
                mostfrequentint=value;
                mostFrequent=key;
            }
        }
        System.out.println("The most frequent character is: " + mostFrequent + " \nfrequent count: "+ mostfrequentint);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine().toLowerCase().replace(" ", "");
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine().toLowerCase().replace(" ", "");

        // TODO: Проверить, являются ли две строки анаграммами (игнорировать пробелы и регистр)
        boolean areAnagrams = false;
        if(str1.length()!=str2.length()){
            System.out.println("No");
            return;
        }
        ArrayList<Character> letters1= new ArrayList<>();
        for(char c: str1.toCharArray()){
            letters1.add(c);
        }
        Collections.sort(letters1);
        ArrayList<Character> letters2= new ArrayList<>();
        for(char c: str2.toCharArray()){
            letters2.add(c);
        }
        Collections.sort(letters2);
        areAnagrams= letters1.equals(letters2);
        System.out.println(areAnagrams ? "Yes" : "No");
    }
}