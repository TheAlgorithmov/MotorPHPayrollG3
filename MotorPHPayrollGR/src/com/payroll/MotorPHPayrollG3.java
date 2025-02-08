package com.payroll;

import java.util.TreeMap; // This is imported to integrate Treemap in Java
import java.util.NavigableMap; // This is imported to be able to search the nearest values in a TreeMap

public class MotorPHPayrollG3 {
    public static void main(String[] args) {
        // Declaring the variables, but not adding a value yet.
        String EMPID;
        String EMPNAME;
        String EMPDOB;
        int workedHoursWeekly;
        double dailySalary;
        double govtSSS;
        double govtPhilHealth;
        double govtHDMF;
        double govtBirTax;
        double combinedGovt;
        double grossIncome;
        double netPay;

        // Assigning the variables with the values needed.
        EMPID = "7819201";
        EMPNAME = "Noah Eason Gray";
        EMPDOB = "2001-05-15";
        workedHoursWeekly = 80;
        dailySalary = 117.56;

        //Calculation of Gross Income
        grossIncome = (dailySalary * workedHoursWeekly);

        // Below will be the computations of all the deductions such as SSS, Philhealth, HDMF, and BIR Tax.
        // This will be the computation for SSS Government Benefit Deduction
        NavigableMap<Double, Double> sssTable = new TreeMap<>(); // Treemap was utilized instead of hashmap as it is efficient in searching for the closest match for our grossPay
        sssTable.put(0.0, 135.00);
        sssTable.put(3250.0, 157.50);
        sssTable.put(3750.0, 180.00);
        sssTable.put(4250.0, 202.50);
        sssTable.put(4750.0, 225.00);
        sssTable.put(5250.0, 247.50);
        sssTable.put(5750.0, 270.00);
        sssTable.put(6250.0, 292.50);
        sssTable.put(6750.0, 315.00);
        sssTable.put(7250.0, 337.50);
        sssTable.put(7750.0, 360.00);
        sssTable.put(8250.0, 382.50);
        sssTable.put(8750.0, 405.00);
        sssTable.put(9250.0, 427.50);
        sssTable.put(9750.0, 450.00);
        sssTable.put(10250.0, 472.50);
        sssTable.put(10750.0, 495.00);
        sssTable.put(11250.0, 517.50);
        sssTable.put(11750.0, 540.00);
        sssTable.put(12250.0, 562.50);
        sssTable.put(12750.0, 585.00);
        sssTable.put(13250.0, 607.50);
        sssTable.put(13750.0, 630.00);
        sssTable.put(14250.0, 652.50);
        sssTable.put(14750.0, 675.00);
        sssTable.put(15250.0, 697.50);
        sssTable.put(15750.0, 720.00);
        sssTable.put(16250.0, 742.50);
        sssTable.put(16750.0, 765.00);
        sssTable.put(17250.0, 787.50);
        sssTable.put(17750.0, 810.00);
        sssTable.put(18250.0, 832.50);
        sssTable.put(18750.0, 855.00);
        sssTable.put(19250.0, 877.50);
        sssTable.put(19750.0, 900.00);
        sssTable.put(20250.0, 922.50);
        sssTable.put(20750.0, 945.00);
        sssTable.put(21250.0, 967.50);
        sssTable.put(21750.0, 990.00);
        sssTable.put(22250.0, 1012.50);
        sssTable.put(22750.0, 1035.00);
        sssTable.put(23250.0, 1057.50);
        sssTable.put(23750.0, 1080.00);
        sssTable.put(24250.0, 1102.50);
        sssTable.put(24750.0, 1125.00);
        govtSSS = sssTable.floorEntry(grossIncome).getValue(); //Added as a way to find the grossPay's nearest and correct sss deduction from the Treemap

        // This will be the computation for HDMF Pag-Ibig Government Benefit Deduction
        govtHDMF = 0.00;
        if (grossIncome >= 1000 && grossIncome <= 1500) {
            govtHDMF = 0.01 * grossIncome;
        } else if (grossIncome > 1500) {
            govtHDMF = 0.02 * grossIncome;
        } else {
            govtHDMF = 0.00;
        }

        // This will be the computation for PhilHealth Government Benefit Deduction
        govtPhilHealth = 0.00;
        if (grossIncome <= 10000) {
            govtPhilHealth = 0.03 * grossIncome;
        } else if (grossIncome >= 10000.01 && grossIncome <= 59999.99) {
            govtPhilHealth = 0.03 * grossIncome;
        } else if (grossIncome >= 60000.00) {
            govtPhilHealth = 0.03 * grossIncome;
        }

        // This will be the computation for BIR Withholding Tax Government Deduction
        govtBirTax = 0.00;
        if (grossIncome <= 20832.00) {
            govtBirTax = 0.00;
        } else if (grossIncome >= 20833.00 && grossIncome <= 33333.00) {
            govtBirTax = 0.20 * (grossIncome - 20833);
        } else if (grossIncome >= 33333 && grossIncome <= 66667) {
            govtBirTax = ((0.25 * (grossIncome - 33333)) + 2500);
        } else if (grossIncome >= 66667 && grossIncome <= 166667) {
            govtBirTax = ((0.30 * (grossIncome - 66667)) + 10833);
        } else if (grossIncome >= 166667 && grossIncome <= 666667) {
            govtBirTax = ((0.32 * (grossIncome - 166667)) + 40833.33);
        } else if (grossIncome >= 666667) {
            govtBirTax = ((0.35 * (grossIncome - 666667)) + 200833.33);
        }

        // Calculation of Deductions and NetPay
        combinedGovt = (govtSSS + govtHDMF + govtPhilHealth + govtBirTax);
        netPay = (grossIncome - combinedGovt);

        // This will be the output that we will print on the console
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(("Employee Number: " + EMPID) + " | " +("Employee Name: " + EMPNAME) + " | " + ("Employee Date of Birth: " + EMPDOB));
        System.out.println("------------------------------------------------------------------------------------------------------------  ");
        System.out.println("Employee Timesheet");
        System.out.println("No. of Hours worked for the week: " + workedHoursWeekly + " hours");
        System.out.println("Government Deductions: PHP " + String.format("%.2f", combinedGovt)); // the [+ String.format("%.2f"] code was added to minimize the output to 2 decimal places
        System.out.println("Gross Weekly Income: PHP " + String.format("%.2f",grossIncome)) ; // the [+ String.format("%.2f"] code was added to minimize the output to 2 decimal places
        System.out.println("Net Weekly Income: PHP " + String.format("%.2f", netPay)); // the [+ String.format("%.2f"] code was added to minimize the output to 2 decimal places
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Breakdown of Government Deductions");
        System.out.println("SSS Deductions: PHP " + String.format("%.2f", govtSSS)); // the [+ String.format("%.2f"] code was added to minimize the output to 2 decimal places
        System.out.println("HMDF Deductions: PHP " + String.format("%.2f", govtHDMF)); // the [+ String.format("%.2f"] code was added to minimize the output to 2 decimal places
        System.out.println("Philhealth Deductions: PHP " + String.format("%.2f", govtPhilHealth)); // the [+ String.format("%.2f"] code was added to minimize the output to 2 decimal places
        System.out.println("BIR Tax Deductions: PHP " + String.format("%.2f", govtBirTax)); // the [+ String.format("%.2f"] code was added to minimize the output to 2 decimal places
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }
}