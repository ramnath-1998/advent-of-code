package Day2.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {

    public static String getWhatThePlayerChose(String input) {

        String result = "";

        if (input.equalsIgnoreCase("a") || input.equalsIgnoreCase("x")) {
            result = "rock";
        } else if (input.equalsIgnoreCase("b") || input.equalsIgnoreCase("y")) {
            result = "paper";

        } else if (input.equalsIgnoreCase("c") || input.equalsIgnoreCase("z")) {

            result = "scissor";
        }
        return result;
    }

    public static int outcomeOfRound(String opponentInput, String myInput) {

        Map<String, String> ruleMap = new HashMap<String, String>();
        ruleMap.put("rock", "paper");
        ruleMap.put("scissor", "rock");
        ruleMap.put("paper", "scissor");
        
        String result = "";
        int points = 0;

        if (myInput.equals("rock")) {
            points = points + 1;
        }

        else if (myInput.equals("paper")) {
            points = points + 2;
        }

        else if (myInput.equals("scissor")) {
            points = points + 3;
        }

        if (opponentInput.equalsIgnoreCase(myInput)) {
            result = "draw";
        }
        else if (opponentInput.equalsIgnoreCase(ruleMap.get(myInput))) {
            result = "lose";
        } else {
            result = "won";
        }

        if (result.equals("won")) {

            points = points + 6;

        } else if (result.equals("lose")) {

            points = points + 0;
        } else if (result.equals("draw")) {

            points = points + 3;
        }

        return points;

    }

    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("//home//ramnath//advent-of-code//Day2//input.txt");

        Scanner sc = new Scanner(inputFile);

        int totalPoints = 0;
        while (sc.hasNextLine()) {
            String inputLine = sc.nextLine();
            String[] inputLineArray = inputLine.split(" ");
            String opponentInput = getWhatThePlayerChose(inputLineArray[0]);
            String myInput = getWhatThePlayerChose(inputLineArray[1]);
            int pointsOfRound = outcomeOfRound(opponentInput, myInput);
            totalPoints = totalPoints + pointsOfRound;

        }

        System.out.println(totalPoints);

        sc.close();
    }

}
