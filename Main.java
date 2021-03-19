package battleship;

import java.util.Scanner;


public class Main {

    public static void display(String[][] x) {      //method to display board
        for (String[] strings : x) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] coordinates = new String[11][11];
        String s = "~";
        String shipPart = "O";
        String[] sitsNum = new String[] {",","1","2","3","4","5","6","7","8","9","10"};
        String[] sitsLetter = new String[] {",","A","B","C","D","E","F","G","H","I","J"};
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                coordinates[i][j] = s;
                coordinates[0][j] = sitsNum[j];
                coordinates[i][0] = sitsLetter[i];
                coordinates[0][0] = "";
            }
        }
        display(coordinates);
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        String oneCor = scanner.next();
        String twoCor = scanner.next();
        int coreOne = Integer.parseInt(oneCor.substring(1));
        int coreTwo = Integer.parseInt(twoCor.substring(1));
        int division = coreTwo - coreOne;
        if (oneCor.charAt(0) == twoCor.charAt(0)) {
                for (int j = coreOne; j < coreTwo; j++) {
                    coordinates[0][0] = "";
                    coordinates[/*there should be an letter row to write "O" there */][j] = shipPart;
                }
        }
        display(coordinates);
    }
}
