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

    public static void addShip(String[][] coordinates, String shipPart) {
        Scanner scanner = new Scanner(System.in);
        String oneCor = scanner.next().toUpperCase();     //input the coordinates of ship
        String twoCor = scanner.next().toUpperCase();
        int coreOne = Integer.parseInt(oneCor.substring(1));        //transforming second letter input which is number into int
        int coreTwo = Integer.parseInt(twoCor.substring(1));
        char oneCoreChar = oneCor.charAt(0);
        char twoCoreChar = twoCor.charAt(0);
//        int divisionInt = coreTwo - coreOne;
        int divisionChar = twoCoreChar - oneCoreChar;
        int corLetterRow = 0;
        char[] chars = new char[]{',', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == oneCoreChar) {
                corLetterRow = i;
            }
        }
            if (oneCor.charAt(0) == twoCor.charAt(0)) {     //both logic on putting ships are working, now i need to check if input is in  correct length
                for (int j = coreOne; j < coreTwo + 1; j++) {
                    coordinates[0][0] = "";
                    coordinates[corLetterRow][j] = shipPart;
                }
            } else {
                for (int j = oneCoreChar - 64; j < divisionChar + 2; j++) {
                    coordinates[0][0] = "";
                    coordinates[j][coreOne] = shipPart;
                }
            }
        }

    public static void main(String[] args) {
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
        // write an if statement to check if user input ship is 5 blocks long
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
            addShip(coordinates, shipPart);
            display(coordinates);
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
            addShip(coordinates,shipPart);
            display(coordinates);
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
            addShip(coordinates,shipPart);
            display(coordinates);
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
            addShip(coordinates,shipPart);
            display(coordinates);
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
            addShip(coordinates,shipPart);
            display(coordinates);
    }
}
