package Day1.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainClassTwo {

    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("//home//ramnath//advent-of-code//Day1//input.txt");

        Scanner sc = new Scanner(inputFile);

        ArrayList<Integer> calorieList = new ArrayList<Integer>();

        int calorieDaySum = 0;
        while (sc.hasNextLine()) {
            String inputLine = sc.nextLine();
            if (inputLine.equals("")) {
                calorieList.add(calorieDaySum);
                calorieDaySum = 0;

            } else {
                calorieDaySum = calorieDaySum + Integer.parseInt(inputLine);
            }

        }
        Collections.sort(calorieList, Collections.reverseOrder());

        int count = 3;
        int sum = 0;

        for (int i = 0; i < count; i++) {

            sum = sum + calorieList.get(i);

        }

        System.out.println(sum);

        sc.close();
    }

}
