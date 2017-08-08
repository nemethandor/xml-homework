package com.foldik.xml.homework.xml.homework;

import com.foldik.xml.homework.xml.homework.avgCalc.StAXAvgCalc;
import com.foldik.xml.homework.xml.homework.invalid.InvalidRectangle;
import com.foldik.xml.homework.xml.homework.reader.DomReader;
import com.foldik.xml.homework.xml.homework.reader.StAXReader;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        boolean exit = false;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                DomReader domReader = new DomReader();
                InvalidRectangle invalidRectangle = new InvalidRectangle();

                System.out.println("\nChoose a task by typing a number:\n" +
                        "0 - EXIT \n" +
                        "1 - DOM Reader \n" +
                        "2 - Average calculation by DOM reader \n" +
                        "3 - stAX Reader \n" +
                        "4 - Average calculation by stAX reader \n" +
                        "5 - Total number of invalid lines\n" +
                        "6 - Total number of invalid lines with details\n");

                int input = Integer.parseInt(scanner.next());

                switch (input) {
                    case 0:
                        System.out.println("Good Bye!");
                        exit = true;
                        break;
                    case 1:
                        System.out.println("\n>>> TASK 1/1 <<< ");
                        System.out.println("Rectangle objects: ");
                        domReader.getListOfElementsByTag();
                        break;
                    case 2:
                        System.out.println("\n >>> TASK 1/2 <<< ");
                        System.out.println(domReader.calculateAVG("Rectangle", "Width"));
                        System.out.println(domReader.calculateAVG("Rectangle", "Height"));
                        System.out.println(domReader.calculateAVG("Rectangle", "X"));
                        System.out.println(domReader.calculateAVG("Rectangle", "Y"));
                        break;
                    case 3:
                        StAXReader stAXReader = new StAXReader();
                        System.out.println("\n >>> TASK 2/1 <<< ");
                        stAXReader.readDocument();
                        break;
                    case 4:
                        StAXAvgCalc stAXAvgCalc = new StAXAvgCalc();
                        System.out.println("\n >>> TASK 2/2 <<< ");
                        System.out.println(stAXAvgCalc.calculateAVG("Rectangle", "Width"));
                        System.out.println(stAXAvgCalc.calculateAVG("Rectangle", "Height"));
                        System.out.println(stAXAvgCalc.calculateAVG("Rectangle", "X"));
                        System.out.println(stAXAvgCalc.calculateAVG("Rectangle", "Y"));
                        break;
                    case 5:
                        System.out.println("\n >>> TASK 3/1 <<< ");
                        invalidRectangle.countInvalid();
                        break;
                    case 6:
                        System.out.println("\n>>> TASK 3/2 <<< ");
                        invalidRectangle.invalidDetails();
                        break;
                    default:
                        System.out.println("Invalid input.");
                }


            } catch (NumberFormatException ex) {
                System.out.println("Please give me number.");
            }
        } while (exit == false);

////        Feladat 1/1
//        DomReader domReader = new DomReader();
//        System.out.println(">>> TASK 1/1 <<< ");
//        System.out.println("Rectangle objects: ");
//        domReader.getListOfElementsByTag();
////        Feladat 1/2
//        System.out.println("\n\n >>> TASK 1/2 <<< ");
//        System.out.println(domReader.calculateAVG("Rectangle", "Width"));
//        System.out.println(domReader.calculateAVG("Rectangle", "Height"));
//        System.out.println(domReader.calculateAVG("Rectangle", "X"));
//        System.out.println(domReader.calculateAVG("Rectangle", "Y"));

////        Feladat 2/1
//        System.out.println("\n\n >>> TASK 2/1 <<< ");
//        StAXReader stAXReader= new StAXReader();
//        stAXReader.readDocument();
////        Feladat 2/2
//        StAXAvgCalc stAXAvgCalc = new StAXAvgCalc();
//        System.out.println("\n\n >>> TASK 2/2 <<< ");
//        System.out.println(stAXAvgCalc.calculateAVG("Rectangle","Width"));
//        System.out.println(stAXAvgCalc.calculateAVG("Rectangle","Height"));
//        System.out.println(stAXAvgCalc.calculateAVG("Rectangle","X"));
//        System.out.println(stAXAvgCalc.calculateAVG("Rectangle","Y"));

////        Feladat 3/1
//        System.out.println("\n\n >>> TASK 3/1 <<< ");
//        InvalidRectangle invalidRectangle = new InvalidRectangle();
//        invalidRectangle.countInvalid();
////        Feladat 3/2
//        System.out.println("\n\n >>> TASK 3/2 <<< ");
//        invalidRectangle.invalidDetails();

    }
}
