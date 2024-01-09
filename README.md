import java.util.*;

public class frequencycheck {

    public static void main(String[] args) {
        // Example text input (replace with your text)
        String text = "Your input text goes here.";

        Map<Character, Integer> charFrequency = getCharacterFrequency(text);
        Map<String, Integer> wordFrequency = getWordFrequency(text);

        int totalCharFrequency = charFrequency.values().stream().mapToInt(Integer::intValue).sum();
        int totalWordFrequency = wordFrequency.values().stream().mapToInt(Integer::intValue).sum();

        // Get top and least frequent characters
        List<Map.Entry<Character, Integer>> topChar = getTopAndLeastFrequent(charFrequency, 9, true);
        List<Map.Entry<Character, Integer>> leastChar = getTopAndLeastFrequent(charFrequency, 9, false);

        // Get top and least frequent words
        List<Map.Entry<String, Integer>> topWord = getTopAndLeastFrequent(wordFrequency, 9, true);
        List<Map.Entry<String, Integer>> leastWord = getTopAndLeastFrequent(wordFrequency, 9, false);

        // Print results
        System.out.println("Total frequency of characters: " + totalCharFrequency);
        System.out.println("Total frequency of words: " + totalWordFrequency);

        System.out.println("\nTop 9 frequent characters:");
        printEntries(topChar);

        System.out.println("\nLeast 9 frequent characters:");
        printEntries(leastChar);

        System.out.println("\nTop 9 frequent words:");
        printEntries(topWord);

        System.out.println("\nLeast 9 frequent words:");
        printEntries(leastWord);
    }

    private static Map<Character, Integer> getCharacterFrequency(String text) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : text.toCharArray()) {
            if(c!=' '&&c!='.'&&c!=',')
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);

        }
        return charFrequency;
    }

    private static Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = text.toLowerCase().split("\\W+");
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }

    private static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> getTopAndLeastFrequent(
            Map<K, V> map, int count, boolean isTop) {
        List<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());

        entries.sort(isTop ? Map.Entry.comparingByValue(Comparator.reverseOrder())
                : Map.Entry.comparingByValue());

        return entries.subList(0, Math.min(count, entries.size()));
    }

    private static <K, V> void printEntries(List<Map.Entry<K, V>> entries) {
        for (Map.Entry<K, V> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}








import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String FILE_PATH = "employee_data.txt";

    static {
        try {
            FileHandler fileHandler = new FileHandler("employee_log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error setting up logging", e);
        }
    }

    public static void main(String[] args) {
        Main ems = new Main();

        // Add new employee
//        ems.addEmployee(1, "Rushi", 1000);

        // Get list of all employees
//        ems.getAllEmployees();

        // Update employee
        ems.updateEmployee(1, "UpdatedRushi", 2500);

        // Get list of all employees after update
        ems.getAllEmployees();

        // Delete employee
//        ems.deleteEmployee(1);

        // Get list of all employees after delete
//        ems.getAllEmployees();
    }

    public void addEmployee(int employeeId, String employeeName, int salary) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.println(employeeId + ", " + employeeName + ", " + salary);
            LOGGER.info("Added employee: " + employeeId + ", " + employeeName + ", " + salary);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error adding employee", e);
        }
    }

    public void deleteEmployee(int employeeId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(employeeId + ", ")) {
                    writer.println(line);
                } else {
                    LOGGER.info("Deleted employee: " + line);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error deleting employee", e);
        }

        // Rename the temporary file to the original file
        new File(FILE_PATH).renameTo(new File(FILE_PATH));
    }

    public void updateEmployee(int employeeId, String newEmployeeName, int newSalary) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(employeeId + ", ")) {
                    writer.println(employeeId + ", " + newEmployeeName + ", " + newSalary);
                    LOGGER.info("Updated employee: " + employeeId + ", " + newEmployeeName + ", " + newSalary);
                } else {
                    writer.println(line);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error updating employee", e);
        }

        // Rename the temporary file to the original file
        new File(FILE_PATH ).renameTo(new File(FILE_PATH));
    }


    public void getAllEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("List of all employees:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error getting all employees", e);
        }
    }
}









public class test {
    public static boolean isPalindrome(int num) {
        String numStr = Integer.toString(num);
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

    public static int[] closestPalindrome(int n) {
        int lowerPalindrome = n - 1;
        int upperPalindrome = n + 1;

        while (!isPalindrome(lowerPalindrome)) {
            lowerPalindrome--;
        }

        while (!isPalindrome(upperPalindrome)) {
            upperPalindrome++;
        }

        // Calculate distances
        int distanceLower = n - lowerPalindrome;
        int distanceUpper = upperPalindrome - n;

        // Check for ties
        if (distanceLower == distanceUpper) {
            int closestAverage = (lowerPalindrome + upperPalindrome) / 2;
            return new int[]{closestAverage, distanceLower};
        } else if (distanceLower < distanceUpper) {
            return new int[]{lowerPalindrome, distanceLower};
        } else {
            return new int[]{upperPalindrome, distanceUpper};
        }
    }

    public static void main(String[] args) {
        int inputNum = 89;
        int[] result = closestPalindrome(inputNum);
        System.out.println("Input: " + inputNum);
        System.out.println("Output: " + result[0]);
        System.out.println("Distance: " + result[1]);
    }
}










import java.util.Stack;

public class test2 {
    public static String removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    result.setCharAt(i, '*');
                }
            }
        }

        while (!stack.isEmpty()) {
            result.setCharAt(stack.pop(), '*');
        }

        return result.toString().replaceAll("\\*", "");
    }

    public static void main(String[] args) {
        String input = ")123(abc))412";
        String output = removeInvalidParentheses(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}









import java.util.Arrays;

public class MirrorInverse {

    public static void main(String[] args) {
        int[] inputArray = {3, 4, 2, 0, 1};

        // Check if the array is mirror inverse
        if (isMirrorInverse(inputArray)) {
            System.out.println("Yes");
            
            // Find the inverse array
            int[] inverseArray = getInverseArray(inputArray);

            // Find the 3rd smallest and 3rd largest elements in the inverse array
            int thirdSmallest = inverseArray[2];
            int thirdLargest = inverseArray[inverseArray.length - 3];

            System.out.println("3rd smallest element: " + thirdSmallest);
            System.out.println("3rd largest element: " + thirdLargest);
        } else {
            System.out.println("No");
        }
    }

    // Function to check if the array is mirror inverse
    private static boolean isMirrorInverse(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[arr[i]] != i) {
                return false;
            }
        }
        return true;
    }

    // Function to get the inverse of the array
    private static int[] getInverseArray(int[] arr) {
        int n = arr.length;
        int[] inverseArray = new int[n];

        for (int i = 0; i < n; i++) {
            inverseArray[arr[i]] = i;
        }

        return inverseArray;
    }
}

