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
