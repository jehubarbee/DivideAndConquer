import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bruteforce {
    public static void main(String[] args) throws Exception {

        // list of days and prices
        // let i = days amd j = price
        int firstInt = 0;
        String csvFile = "";
        // finds the number of days
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            if ((line = br.readLine()) != null) {
                // provess the first line
                String[] values = line.split(",");

                // parse the number
                if (values.length > 0) {
                    try {
                        firstInt = Integer.parseInt(values[0]);
                        System.out.println("Total days: " + firstInt);
                    } catch (NumberFormatException e) {
                        System.err.println("First value is not an integer.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] p = { 5, 6, 4, 3, 2 };
        int total_amount_days = p.length;
        int j = 0;
        int k = 1;
        int profit = 0;
        int loss = 0;
        int n = firstInt;
        int arraySize = n;
        int columnNumber = 2;

        List<Integer> integerList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean firstLine = true; // skips to the first line
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // skip
                }
                String[] values = line.split(",");
                if (values.length > columnNumber) {
                    try {
                        int intValue = Integer.parseInt(values[columnNumber]);
                        integerList.add(intValue);
                    } catch (NumberFormatException e) {

                    }
                }

                // parse the number
                if (values.length > 0) {
                    try {
                        firstInt = Integer.parseInt(values[0]);
                        System.out.println("Total days: " + firstInt);
                    } catch (NumberFormatException e) {
                        System.err.println("First value is not an integer.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ensure we have enough ints to fill the array
        if (integerList.size() >= arraySize) {
            Integer[] integerArray = new Integer[arraySize];
            for (int i = 0; i < arraySize; i++) {
                integerArray[i] = integerList.get(i + 1);
                // start from the second integer
            }
            for (int num : integerArray) {
                System.out.println(num);
            }
        } else {
            System.err.println("Not enough integers in the csv file to fill the array.");
        }
        // let k and j be days
        // j has to come before k because its the buy day
        int[] Max_list = new int[n - 1];
        int[] min_list = new int[n - 1];

        if ((0 <= j) && (j < k) && (k <= n - 1)) {
            // go through the list and store
            for (j = 0; j == n - 1; j++) {
                for (k = j + 1; k == n; k++) {
                    Max_list[j] = p[k] - p[j];
                    min_list[j] = p[k] - p[j];
                }
                for (int i = 0; i < n - 1; i++) {
                    int largest = 0;
                    if (Max_list[i] > largest)
                        largest = Max_list[i];
                }
            }
        }
    }
}
