package com.payroll;
import java.util.TreeMap;
import java.util.NavigableMap;

public class EmpDB {
    // Make employeeData accessible from other classes
    public static final NavigableMap<Integer, String> employeeData = new TreeMap<>();

    // Employee ID to Birthday mapping
    public static final NavigableMap<Integer, String> empBD = new TreeMap<>();

    // Employee ID to Birthday mapping
    public static final NavigableMap<Integer, Double> empTime = new TreeMap<>();

    static {
        // Add employees to the TreeMap
        employeeData.put(10001, "Manuel III Garcia");
        employeeData.put(10002, "Antonio Lim");
        employeeData.put(10003, "Bianca Sofia Aquino");
        employeeData.put(10004, "Isabella Reyes");
        employeeData.put(10005, "Eduard Hernandez");
        employeeData.put(10006, "Andrea Mae Villanueva");
        employeeData.put(10007, "Brad San Jose");
        employeeData.put(10008, "Alice Romualdez");
        employeeData.put(10009, "Rosie Atienza");
        employeeData.put(10010, "Roderick Alvaro");
        employeeData.put(10011, "Anthony Salcedo");
        employeeData.put(10012, "Josie Lopez");
        employeeData.put(10013, "Martha Farala");
        employeeData.put(10014, "Leila Martinez");
        employeeData.put(10015, "Fredrick Romualdez");
        employeeData.put(10016, "Christian Mata");
        employeeData.put(10017, "Selena De Leon");
        employeeData.put(10018, "Allison San Jose");
        employeeData.put(10019, "Cydney Rosario");
        employeeData.put(10020, "Mark Bautista");
        employeeData.put(10021, "Darlene Lazaro");
        employeeData.put(10022, "Kolby Delos Santos");
        employeeData.put(10023, "Vella Santos");
        employeeData.put(10024, "Tomas Del Rosario");
        employeeData.put(10025, "Jacklyn Tolentino");
        employeeData.put(10026, "Percival Gutierrez");
        employeeData.put(10027, "Garfield Manalaysay");
        employeeData.put(10028, "Lizeth Villegas");
        employeeData.put(10029, "Carol Ramos");
        employeeData.put(10030, "Emelia Maceda");
        employeeData.put(10031, "Delia Aguilar");
        employeeData.put(10032, "John Rafael Castro");
        employeeData.put(10033, "Carlos Ian Martinez");
        employeeData.put(10034, "Beatriz Santos");

        // Add birthdays to the TreeMap
        empBD.put(10001, "10/11/1983");
        empBD.put(10002, "06/19/1988");
        empBD.put(10003, "08/04/1989");
        empBD.put(10004, "06/16/1994");
        empBD.put(10005, "09/23/1989");
        empBD.put(10006, "02/14/1988");
        empBD.put(10007, "03/15/1996");
        empBD.put(10008, "05/14/1992");
        empBD.put(10009, "09/24/1948");
        empBD.put(10010, "03/30/1988");
        empBD.put(10011, "09/14/1993");
        empBD.put(10012, "01/14/1987");
        empBD.put(10013, "01/11/1942");
        empBD.put(10014, "07/11/1970");
        empBD.put(10015, "03/10/1985");
        empBD.put(10016, "10/21/1987");
        empBD.put(10017, "02/20/1975");
        empBD.put(10018, "06/24/1986");
        empBD.put(10019, "10/06/1996");
        empBD.put(10020, "02/12/1991");
        empBD.put(10021, "11/25/1985");
        empBD.put(10022, "02/26/1980");
        empBD.put(10023, "12/31/1983");
        empBD.put(10024, "12/18/1978");
        empBD.put(10025, "05/19/1984");
        empBD.put(10026, "12/18/1970");
        empBD.put(10027, "08/28/1986");
        empBD.put(10028, "12/12/1981");
        empBD.put(10029, "08/20/1978");
        empBD.put(10030, "04/14/1973");
        empBD.put(10031, "01/27/1989");
        empBD.put(10032, "02/09/1992");
        empBD.put(10033, "11/16/1990");
        empBD.put(10034, "08/07/1990");

// Add hourly rates to empTime TreeMap
        empTime.put(10001, 535.71);
        empTime.put(10002, 357.14);
        empTime.put(10003, 357.14);
        empTime.put(10004, 357.14);
        empTime.put(10005, 313.51);
        empTime.put(10006, 313.51);
        empTime.put(10007, 255.80);
        empTime.put(10008, 133.93);
        empTime.put(10009, 133.93);
        empTime.put(10010, 313.51);
        empTime.put(10011, 302.53);
        empTime.put(10012, 229.02);
        empTime.put(10013, 142.86);
        empTime.put(10014, 142.86);
        empTime.put(10015, 318.45);
        empTime.put(10016, 255.80);
        empTime.put(10017, 249.11);
        empTime.put(10018, 133.93);
        empTime.put(10019, 133.93);
        empTime.put(10020, 138.39);
        empTime.put(10021, 138.39);
        empTime.put(10022, 142.86);
        empTime.put(10023, 133.93);
        empTime.put(10024, 133.93);
        empTime.put(10025, 142.86);
        empTime.put(10026, 147.32);
        empTime.put(10027, 147.32);
        empTime.put(10028, 142.86);
        empTime.put(10029, 133.93);
        empTime.put(10030, 133.93);
        empTime.put(10031, 133.93);
        empTime.put(10032, 313.51);
        empTime.put(10033, 313.51);
        empTime.put(10034, 313.51);
    }
}
