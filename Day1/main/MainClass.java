package Day1.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainClass {

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

        System.out.println(Collections.max(calorieList));


        sc.close();
    }

}
