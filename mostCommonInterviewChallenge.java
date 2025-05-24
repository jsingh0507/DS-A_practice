//Palindrome Check
public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
    
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam")); // true
        System.out.println(isPalindrome("hello")); // false
    }
}

// factorial recursion
public class Factorial {
    public static int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    }
}

//Fibionacci sequence (recursion)
public class Fibonacci {
    public static int fibonacci(int n) {
        return (n <= 1) ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6)); // 8
    }
}

//Reverse a string 
public class ReverseInteger {
    public static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1234)); // 4321
    }
}

//Largest in an Array 
public class LargestInArray {
    public static int findLargest(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 5, 8, 20, 15};
        System.out.println(findLargest(numbers)); // 20
    }
}

//Check If number is prime
public class PrimeCheck {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(7));  // true
        System.out.println(isPrime(10)); // false
    }
}

//remove duplicate from array

import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 4, 4, 5};
        System.out.println(Arrays.toString(removeDuplicates(numbers))); // [1, 2, 3, 4, 5]
    }
}

//Check anagram
import java.util.Arrays;

public class AnagramCheck {
    public static boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // true
    }
}

//Swap Variables

public class SwapVariables {
    public static void main(String[] args) {
        int a = 5, b = 10;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a: " + a + ", b: " + b);
    }
}

// Array intersection

public class ArrayIntersection {
    public static int[] findIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        // Add all elements of arr1 to set1
        for (int num : arr1) {
            set1.add(num);
        }

        // Check which elements of arr2 exist in set1
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        System.out.println("Intersection: " + Arrays.toString(findIntersection(arr1, arr2))); // [3, 4, 5]
    }
}

// First non repeating character
public class FirstNonRepeatingChar {
    public static char firstUniqueChar(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        // Count occurrences of each character
        for (char ch : str.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // Find the first non-repeating character
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '_'; // If no unique character found
    }

    public static void main(String[] args) {
        System.out.println("First non-repeating character: " + firstUniqueChar("swiss")); // 'w'
    }
}

// BInary search implementation
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11};
        System.out.println("Index of 7: " + binarySearch(numbers, 7)); // 3
        System.out.println("Index of 4: " + binarySearch(numbers, 4)); // -1
    }
}

//Longest common prefix 
public class LongestCommonPrefix {
    public static String findPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // Start with the first string

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // Reduce prefix
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] words = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + findPrefix(words)); // "fl"
    }
}

// Linked List ex
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // Loop detected
            }
        }
        return false; // No cycle
    }

    public static void main(String[] args) {
        // Example: Create a linked list with a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // Creates a cycle

        System.out.println("Has Cycle: " + hasCycle(head)); // true
    }
}

// Merge sort 

public class MergeSortedArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[] mergedArray = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Merge both arrays in sorted order
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < m) {
            mergedArray[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < n) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        System.out.println("Merged Sorted Array: " + Arrays.toString(mergeArrays(arr1, arr2)));
        // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}

public class StringRotationCheck {
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String temp = s1 + s1; // Concatenate string to itself
        return temp.contains(s2); // Check if s2 is substring of temp
    }

    public static void main(String[] args) {
        System.out.println(areRotations("abcd", "cdab")); // true
        System.out.println(areRotations("abcd", "acbd")); // false
    }
}

public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b); // Euclidean Algorithm
    }

    public static void main(String[] args) {
        System.out.println("GCD of 54 and 24: " + gcd(54, 24)); // 6
    }
}

public class CheckSortedArray {
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4};
        System.out.println(isSorted(arr1)); // true
        System.out.println(isSorted(arr2)); // false
    }
}

import java.util.HashSet;

public class FindPairsWithSum {
    public static void findPairs(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                System.out.println("(" + complement + ", " + num + ")");
            }
            set.add(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 2, 3, 5};
        findPairs(arr, 7); // (4,3), (6,1), (5,2)
    }
}

import java.util.HashSet;

public class FirstRepeatingElement {
    public static int findFirstRepeating(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) return num;
            seen.add(num);
        }
        return -1; // Return -1 if no repeating element found
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        System.out.println("First Repeating Element: " + findFirstRepeating(arr)); // 3
    }
}

import java.util.HashSet;

public class FindAllDuplicates {
    public static void findDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicates: " + duplicates);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 3, 1, 5};
        findDuplicates(arr); // [1, 3]
    }
}

public class CountVowels {
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "Interview Prep";
        System.out.println("Vowel Count: " + countVowels(input)); // Output: 5
    }
}

public class FibonacciSeries {
    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        printFibonacci(10); // 0 1 1 2 3 5 8 13 21 34
    }
}

public class ArmstrongNumber {
    public static boolean isArmstrong(int num) {
        int original = num, sum = 0;
        int digits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153)); // true
        System.out.println(isArmstrong(123)); // false
    }
}


import java.util.HashMap;

public class MaxCharFrequency {
    public static char getMaxChar(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        char maxChar = ' ';
        int max = 0;
        for (char ch : freq.keySet()) {
            if (freq.get(ch) > max) {
                max = freq.get(ch);
                maxChar = ch;
            }
        }
        return maxChar;
    }

    public static void main(String[] args) {
        System.out.println("Max occurring char: " + getMaxChar("aabccccddbbb")); // b
    }
}

public class PerfectNumber {
    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfect(28)); // true
        System.out.println(isPerfect(12)); // false
    }
}

public class OnlyDigitsCheck {
    public static boolean containsOnlyDigits(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input1 = "123456";
        String input2 = "123a56";

        System.out.println(input1 + " contains only digits? " + containsOnlyDigits(input1)); // true
        System.out.println(input2 + " contains only digits? " + containsOnlyDigits(input2)); // false
    }
}

public class SumOfDigits {
    public static int sumDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Sum of digits: " + sumDigits(1234)); // 10
    }
}

public class EvenOddCheck {
    public static String checkEvenOdd(int num) {
        return (num & 1) == 0 ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        System.out.println("5 is " + checkEvenOdd(5)); // Odd
        System.out.println("10 is " + checkEvenOdd(10)); // Even
    }
}

public class WordCount {
    public static int countWords(String str) {
        if (str == null || str.isEmpty()) return 0;
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        String sentence = "Java is an object oriented language";
        System.out.println("Word count: " + countWords(sentence)); // 6
    }
}

public class ReverseEachWord {
    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String input = "hello world java";
        System.out.println("Reversed: " + reverseWords(input)); // "olleh dlrow avaj"
    }
}

public class StringToInt {
    public static int stringToInt(String str) {
        int num = 0;
        for (char ch : str.toCharArray()) {
            num = num * 10 + (ch - '0');
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("Converted: " + stringToInt("1234")); // 1234
    }
}

public class LongestWordLength {
    public static int longestWordLength(String sentence) {
        String[] words = sentence.split(" ");
        int maxLen = 0;
        for (String word : words) {
            if (word.length() > maxLen) {
                maxLen = word.length();
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String sentence = "Java is powerful and elegant";
        System.out.println("Longest word length: " + longestWordLength(sentence)); // 8
    }
}

public class CapitalizeWords {
    public static String capitalizeEachWord(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1))
                  .append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String input = "java is fun";
        System.out.println("Capitalized: " + capitalizeEachWord(input)); // "Java Is Fun"
    }
}
public class RemoveSpaces {
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        String input = " Java   is   awesome ";
        System.out.println("Without spaces: " + removeSpaces(input)); // "Javaisawesome"
    }
}

import java.util.HashMap;

public class WordFrequency {
    public static void countWords(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");
        HashMap<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies: " + freqMap);
    }

    public static void main(String[] args) {
        String text = "Java is great and Java is fast";
        countWords(text);
        // Output: {java=2, is=2, great=1, and=1, fast=1}
    }
}

public class PowerCalculation {
    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("2^5 = " + power(2, 5)); // 32
    }
}

public class DigitCounter {
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Number of digits: " + countDigits(987654)); // 6
    }
}

import java.util.Arrays;

public class MinMaxInArray {
    public static void findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println("Min: " + min + ", Max: " + max);
    }

    public static void main(String[] args) {
        int[] numbers = {45, 2, 9, 18, 91, 3};
        findMinMax(numbers); // Min: 2, Max: 91
    }
}

public class PalindromeNumber {
    public static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;

        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println("121 is palindrome? " + isPalindrome(121)); // true
        System.out.println("123 is palindrome? " + isPalindrome(123)); // false
    }
}

import java.util.HashSet;

public class FirstDuplicate {
    public static int findFirstDuplicate(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num)) {
                return num; // First duplicate found
            }
            seen.add(num);
        }

        return -1; // No duplicates found
    }

    public static void main(String[] args) {
        int[] numbers = {3, 5, 4, 2, 3, 6, 7};
        System.out.println("First duplicate: " + findFirstDuplicate(numbers)); // 3
    }
}

public class PrimeNumbersInRange {
    public static void printPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        printPrimes(50); // Outputs all prime numbers ≤ 50
    }
}

public class SumOfArray {
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};
        System.out.println("Sum of array: " + sumArray(numbers)); // 100
    }
}

public class SwapStrings {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";

        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());

        System.out.println("a: " + a); // World
        System.out.println("b: " + b); // Hello
    }
}

public class RemoveDuplicateChars {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[256]; // ASCII size

        for (char ch : str.toCharArray()) {
            if (!seen[ch]) {
                sb.append(ch);
                seen[ch] = true;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("programming")); // "progamin"
    }
}

public class SecondSmallest {
    public static int findSecondSmallest(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < first) {
                second = first;
                first = num;
            } else if (num < second && num != first) {
                second = num;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 1, 4, 2};
        System.out.println("Second smallest: " + findSecondSmallest(arr)); // 2
    }
}


import java.util.HashSet;

public class MissingCharacters {
    public static void printMissing(String str1, String str2) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : str2.toCharArray()) {
            set.add(ch);
        }

        for (char ch : str1.toCharArray()) {
            if (!set.contains(ch)) {
                System.out.print(ch + " ");
            }
        }
    }

    public static void main(String[] args) {
        printMissing("abcdefg", "abc"); // Output: d e f g
    }
}


public class SumEvenNumbers {
    public static int sumEven(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 8, 9, 12};
        System.out.println("Sum of even numbers: " + sumEven(nums)); // 22
    }
}

public class LeapYear {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println("2024 is leap year? " + isLeapYear(2024)); // true
        System.out.println("2100 is leap year? " + isLeapYear(2100)); // false
    }
}

import java.util.Arrays;

public class ReverseArray {
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        reverse(numbers);
        System.out.println("Reversed array: " + Arrays.toString(numbers)); // [5, 4, 3, 2, 1]
    }
}

public class VowelConsonantCount {
    public static void count(String input) {
        int vowels = 0, consonants = 0;
        input = input.toLowerCase();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        count("Java Programming"); // Vowels: 5, Consonants: 9
    }
}

public class DecimalToBinary {
    public static String convertToBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public static void main(String[] args) {
        System.out.println("Binary of 25: " + convertToBinary(25)); // 11001
    }
}

public class BinaryToDecimal {
    public static int convertToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static void main(String[] args) {
        System.out.println("Decimal of 11001: " + convertToDecimal("11001")); // 25
    }
}


public class ReplaceSpaces {
    public static String replaceSpaces(String str) {
        return str.trim().replaceAll("\\s+", "-");
    }

    public static void main(String[] args) {
        String input = "  Java is awesome  ";
        System.out.println("Updated string: " + replaceSpaces(input)); // "Java-is-awesome"
    }
}

public class EqualArrays {
    public static boolean areEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {4, 3, 2, 1};
        System.out.println("Arrays equal? " + areEqual(a, b)); // true
    }
}

public class StarPattern {
    public static void printTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printTriangle(5);
    }
}

public class CharTypeCount {
    public static void countTypes(String str) {
        int digits = 0, letters = 0, specials = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) digits++;
            else if (Character.isLetter(ch)) letters++;
            else specials++;
        }

        System.out.println("Letters: " + letters);
        System.out.println("Digits: " + digits);
        System.out.println("Specials: " + specials);
    }

    public static void main(String[] args) {
        countTypes("Java123@#2024");
    }
}

public class PalindromeWords {
    public static void findPalindromes(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");

        System.out.println("Palindromes in sentence:");
        for (String word : words) {
            if (isPalindrome(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    public static void main(String[] args) {
        findPalindromes("Madam racecar level java pop");
    }
}

public class GCDArray {
    public static int findGCD(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] numbers = {24, 60, 36};
        System.out.println("GCD of array: " + findGCD(numbers)); // 12
    }
}

public class FirstNonRepeatedChar {
    public static char firstNonRepeated(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // Return the first character with count 1
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '_'; // Indicates no unique character found
    }

    public static void main(String[] args) {
        String input = "swiss";
        System.out.println("First non-repeated character: " + firstNonRepeated(input)); // Output: w
    }
}

public class FibonacciArray {
    public static int[] generateFibonacci(int n) {
        int[] fib = new int[n];
        if (n >= 1) fib[0] = 0;
        if (n >= 2) fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci: " + Arrays.toString(generateFibonacci(10)));
    }
}
public class ProductOfArray {
    public static int product(int[] arr) {
        int result = 1;
        for (int num : arr) {
            result *= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        System.out.println("Product: " + product(nums)); // 24
    }
}
public class CommonElements {
    public static void findCommon(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) set.add(num);

        System.out.print("Common elements: ");
        for (int num : arr2) {
            if (set.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5};
        int[] b = {2, 3, 5, 6};
        findCommon(a, b); // 3 5
    }
}
public class WordsEndingInVowel {
    public static int countWordsEndingInVowel(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                char lastChar = word.charAt(word.length() - 1);
                if ("aeiou".indexOf(lastChar) != -1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String sentence = "Hello I am a software engineer";
        System.out.println("Words ending in vowel: " + countWordsEndingInVowel(sentence)); // 3
    }
}
public class SumOfSquares {
    public static int sumSquares(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Sum of squares: " + sumSquares(123)); // 14
    }
}
public class RightAlignedTriangle {
    public static void printRightAligned(int n) {
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= i; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printRightAligned(5);
    }
}
public class IterativeFactorial {
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5)); // 120
    }
}
public class LargestWord {
    public static String findLargest(String sentence) {
        String[] words = sentence.split("\\s+");
        String largest = "";

        for (String word : words) {
            if (word.length() > largest.length()) {
                largest = word;
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        System.out.println("Largest word: " + findLargest("Java is beautiful and powerful")); // beautiful
    }
}

public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static void main(String[] args) {
        System.out.println("16 is perfect square? " + isPerfectSquare(16)); // true
        System.out.println("20 is perfect square? " + isPerfectSquare(20)); // false
    }
}

public class TitleCaseConverter {
    public static String toTitleCase(String input) {
        String[] words = input.toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toTitleCase("java is amazing")); // Java Is Amazing
    }
}

public class ReverseNumber {
    public static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println("Reversed: " + reverse(1234)); // 4321
    }
}

public class CharacterCount {
    public static int countChar(String str, char target) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == target) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Count of 'a': " + countChar("Java programming", 'a')); // 3
    }
}
