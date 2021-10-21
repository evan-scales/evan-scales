/**
 * written by Evan Scales
 */
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class trackerManager {
    private static final String DELIM = ",";
    private static final int FIELD_AMT = 5;
    private static final int FIELD_AMT2 = 2;
    private HashMap<Integer, Package> pMap;
    private HashMap<String, Integer> ppMap;
    private HashMap<Integer, Package> pPlane;
    private HashMap<Integer, Package> lPlane;
    private HashMap<String, Integer> lMap;

    public trackerManager() {
        pMap = new HashMap<Integer, Package>();
        ppMap = new HashMap<String, Integer>();
        pPlane = new HashMap<Integer, Package>();
        lPlane = new HashMap<Integer, Package>();
        lMap = new HashMap<String, Integer>();

    }
    public void readPhil(String fileName) {
        try {
            ppMap = new HashMap<String, Integer>();
            Scanner fileScanner = new Scanner(new FileInputStream(fileName));
            while (fileScanner.hasNextLine()) {
                String fileLine = fileScanner.nextLine();
                String [] splitLines = fileLine.split(DELIM);
                if (splitLines.length == FIELD_AMT2) {
                    // 0(Key), 1(Value))
                    String key = splitLines[0];
                    int val = Integer.parseInt(splitLines[1]);
                    ppMap.put(key, val);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readLouis(String fileName) {
        try {
            lMap = new HashMap<String, Integer>();
            Scanner fileScanner = new Scanner(new FileInputStream(fileName));
            while (fileScanner.hasNextLine()) {
                String fileLine = fileScanner.nextLine();
                String [] splitLines = fileLine.split(DELIM);
                if (splitLines.length == FIELD_AMT2) {
                    // 0(Key), 1(Value))
                    String key = splitLines[0];
                    int val = Integer.parseInt(splitLines[1]);
                    lMap.put(key, val);
                }
            }
            System.out.println(lMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void readFile(String fileName) {
        try {
            // Clears map before reading in new file
            pMap = new HashMap<Integer, Package>();
            Scanner fileScanner = new Scanner(new FileInputStream(fileName));
            while (fileScanner.hasNextLine()) {
                String fileLine = fileScanner.nextLine();
                String [] splitLines = fileLine.split(DELIM);
                if(splitLines.length == FIELD_AMT){
                    // 0(Key), Package(1(zipcode), 2(weight), 3(volume), 4(hazmat))
                    int key = Integer.parseInt(splitLines[0]);
                    // Package variables
                    int nZ = Integer.parseInt(splitLines[1]);
                    int nW = Integer.parseInt(splitLines[2]);
                    int nV = Integer.parseInt(splitLines[3]);
                    int nH = Integer.parseInt(splitLines[4]);
                    Package p = new Package(nZ, nW, nV, nH, key);
                    pMap.put(key, p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printFile() {
        System.out.println(pMap);
    }

    public void getPlane() {
        for (Package value : pMap.values()) {
            if (ppMap.containsValue(value.getZipcode()))
                pPlane.put(value.getID(), value);
            else
                lPlane.put(value.getID(), value);
        }
        System.out.println("Packages going on philly plane");
        System.out.println(pPlane);
        System.out.println("-----------------------------------");
        System.out.println("Packages going on Louis plane");
        System.out.println(lPlane);
        System.out.println("-----------------------------------");
    }
}