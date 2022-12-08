package Day2.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class MainClassTwo {

    public static String getWhatThePlayerChose(String input) {

        String result = "";

        if (input.equalsIgnoreCase("a")) {
            result = "rock";
        } else if (input.equalsIgnoreCase("b")) {
            result = "paper";

        } else if (input.equalsIgnoreCase("c")) {

            result = "scissor";
        }
        return result;
    }

    public static String getWhatYouNeed(String input) {
        String result = "";

        if (input.equalsIgnoreCase("x")) {

            result = "lose";

        } else if (input.equalsIgnoreCase("y")) {
            result = "draw";

        } else if (input.equalsIgnoreCase("z")) {
            result = "won";

        }
        return result;

    }

    public static String getWhatYouNeedToChoose(String opponentInput, String whatYouNeed) {
        String result = "";

        Map<String, String> ruleMap = new HashMap<String, String>();
        ruleMap.put("rock", "paper");
        ruleMap.put("scissor", "rock");
        ruleMap.put("paper", "scissor");

        if (whatYouNeed.equalsIgnoreCase("won")) {

            result = ruleMap.get(opponentInput);

        }

        else if (whatYouNeed.equalsIgnoreCase("lose")) {

            for (Entry<String, String> entry : ruleMap.entrySet()) {

                if (entry.getValue().equalsIgnoreCase(opponentInput)) {
                    result = entry.getKey();
                }

            }

        }

        else if (whatYouNeed.equalsIgnoreCase("draw")) {

            result = opponentInput;
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
        } else if (opponentInput.equalsIgnoreCase(ruleMap.get(myInput))) {
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
            String whatYouNeed = getWhatYouNeed(inputLineArray[1]);
            String myInput = getWhatYouNeedToChoose(opponentInput, whatYouNeed);
            int pointsOfRound = outcomeOfRound(opponentInput, myInput);
            totalPoints = totalPoints + pointsOfRound;

        }

        System.out.println(totalPoints);

        sc.close();
    }

}
