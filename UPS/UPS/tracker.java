/**
 * written by Evan Scales
 */
import java.util.Scanner;
public class tracker {
    private static trackerManager trackerManager = new trackerManager();
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
    

        loadData();
        printData();
        determinePlane();
        
        keyboard.close();
    }
    public static void loadData(){
        System.out.println("Hello again! plz enter a file");
        String fileName = keyboard.nextLine();
        trackerManager.readFile(fileName);
        String input1 = "phil.txt";
        String input2 = "louis.txt";
        trackerManager.readPhil(input1);
        trackerManager.readLouis(input2);

    }
    public static void printData() {
        trackerManager.printFile();
    }
    public static void determinePlane() {
        trackerManager.getPlane();
    }
}