package com.foldik.xml.homework.xml.homework;

import com.foldik.xml.homework.xml.homework.reader.DomReader;
import com.foldik.xml.homework.xml.homework.reader.StAXReader;

public class App {

    public static void main(String[] args) throws Exception {

        DomReader domReader = new DomReader();

//        Feladat 1/1
        System.out.println(">>> TASK 1/1 <<< ");
        System.out.println("Rectangle objects: ");
        domReader.getListOfElementsByTag();
//        Feladat 1/2
        System.out.println("\n\n >>> TASK 1/2 <<< ");
        System.out.println(domReader.calculateAVG("Rectangle", "Width"));
        System.out.println(domReader.calculateAVG("Rectangle", "Height"));
        System.out.println(domReader.calculateAVG("Rectangle", "X"));
        System.out.println(domReader.calculateAVG("Rectangle", "Y"));

//        StAXReader stAXReader= new StAXReader();
//
//        stAXReader.readDocument();

    }
}
