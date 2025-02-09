package com.payroll;

import java.util.TreeMap; // This is imported to integrate Treemap in Java
import java.util.NavigableMap; // This is imported to be able to search the nearest values in a TreeMap

public class MotorPHPayrollG3 {
    public static void main(String[] args) {
        // Declaring variables
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

        // Assigning values
        EMPID = "7819201";
        EMPNAME = "Noah Eason Gray";
        EMPDOB = "2001-05-15";
        workedHoursWeekly = 80;
        dailySalary = 117.56;

        // Work schedule for 10 days
        int biWeeklyWorkDays = 10;
        int[] workTypes = {1, 1, 3, 1, 1, 4, 1, 1, 5, 1}; // 1=Regular, 3=Special Holiday, 4=Regular Holiday, 5=Rest+Holiday
        int[] overtimeHoursPerDay = {2, 1, 0, 3, 0, 4, 2, 1, 0, 2}; // OT per day

        // Calculate Gross Income dynamically
        grossIncome = 0;
        for (int i = 0; i < biWeeklyWorkDays; i++) {
            int workType = workTypes[i];
            int overtimeHours = overtimeHoursPerDay[i];
            double dailyIncome = dailySalary * 8;
            double dailyOvertimePay;

            // Apply holiday pay rules
            if (workType == 4) { // Regular Holiday
                dailyIncome = (8 * dailySalary) * 2;
            } else if (workType == 3) { // Special Holiday
                dailyIncome *= 1.30;
            }

            // Determine overtime rate
            double dailyOvertimeRate; // Default regular day OT
            dailyOvertimeRate = switch (workType) {
                case 2 -> 1.3;
                case 3 -> (overtimeHours > 8) ? 1.69 : 1.3;
                case 4 -> (overtimeHours > 8) ? 2.6 : 2.0;
                case 5 -> (overtimeHours > 8) ? 3.38 : 2.6;
                default -> 1.25;
            }; // Default rate for regular workdays
            // Calculate OT pay for the day
            dailyOvertimePay = dailySalary * dailyOvertimeRate * overtimeHours;

            // Add daily pay and OT pay to total gross income
            grossIncome += (dailyIncome + dailyOvertimePay);
        }

        // This will be the computation for SSS Government Benefit Deduction - Effective Jan 2025
        NavigableMap<Double, double[]> sssTable = new TreeMap<>(); // Treemap was utilized instead of hashmap as it is efficient in searching for the closest match for our grossPay
        sssTable.put(5250.0, new double[]{560, 275});
        sssTable.put(5750.0, new double[]{610, 300});
        sssTable.put(6250.0, new double[]{660, 325});
        sssTable.put(6750.0, new double[]{710, 350});
        sssTable.put(7250.0, new double[]{760, 375});
        sssTable.put(7750.0, new double[]{810, 400});
        sssTable.put(8250.0, new double[]{860, 425});
        sssTable.put(8750.0, new double[]{910, 450});
        sssTable.put(9250.0, new double[]{960, 475});
        sssTable.put(9750.0, new double[]{1010, 500});
        sssTable.put(10250.0, new double[]{1060, 525});
        sssTable.put(10750.0, new double[]{1110, 550});
        sssTable.put(11250.0, new double[]{1160, 575});
        sssTable.put(11750.0, new double[]{1210, 600});
        sssTable.put(12250.0, new double[]{1260, 625});
        sssTable.put(12750.0, new double[]{1310, 650});
        sssTable.put(13250.0, new double[]{1360, 675});
        sssTable.put(13750.0, new double[]{1410, 700});
        sssTable.put(14250.0, new double[]{1460, 725});
        sssTable.put(14750.0, new double[]{1530, 750});
        sssTable.put(15250.0, new double[]{1580, 775});
        sssTable.put(15750.0, new double[]{1630, 800});
        sssTable.put(16250.0, new double[]{1680, 825});
        sssTable.put(16750.0, new double[]{1730, 850});
        sssTable.put(17250.0, new double[]{1780, 875});
        sssTable.put(17750.0, new double[]{1830, 900});
        sssTable.put(18250.0, new double[]{1880, 925});
        sssTable.put(18750.0, new double[]{1930, 950});
        sssTable.put(19250.0, new double[]{1980, 975});
        sssTable.put(19750.0, new double[]{2030, 1000});
        sssTable.put(20250.0, new double[]{2080, 1025});
        sssTable.put(20750.0, new double[]{2130, 1050});
        sssTable.put(21250.0, new double[]{2180, 1075});
        sssTable.put(21750.0, new double[]{2230, 1100});
        sssTable.put(22250.0, new double[]{2280, 1125});
        sssTable.put(22750.0, new double[]{2330, 1150});
        sssTable.put(23250.0, new double[]{2380, 1175});
        sssTable.put(23750.0, new double[]{2430, 1200});
        sssTable.put(24250.0, new double[]{2480, 1225});
        sssTable.put(24750.0, new double[]{2530, 1250});
        sssTable.put(25250.0, new double[]{2580, 1275});
        sssTable.put(25750.0, new double[]{2630, 1300});
        sssTable.put(26250.0, new double[]{2680, 1325});
        sssTable.put(26750.0, new double[]{2730, 1350});
        sssTable.put(27250.0, new double[]{2780, 1375});
        sssTable.put(27750.0, new double[]{2830, 1400});
        sssTable.put(28250.0, new double[]{2880, 1425});
        sssTable.put(28750.0, new double[]{2930, 1450});
        sssTable.put(29250.0, new double[]{2980, 1475});
        sssTable.put(29750.0, new double[]{3030, 1500});
        sssTable.put(30250.0, new double[]{3080, 1525});
        sssTable.put(30750.0, new double[]{3130, 1550});
        sssTable.put(31250.0, new double[]{3180, 1575});
        sssTable.put(31750.0, new double[]{3230, 1600});
        sssTable.put(32250.0, new double[]{3280, 1625});
        sssTable.put(32750.0, new double[]{3330, 1650});
        sssTable.put(33250.0, new double[]{3380, 1675});
        sssTable.put(33750.0, new double[]{3430, 1700});
        sssTable.put(34250.0, new double[]{3480, 1725});
        sssTable.put(34750.0, new double[]{3530, 1750});

        // Get the correct SSS deduction
        double[] sssContribution = sssTable.floorEntry(grossIncome).getValue();
        govtSSS = sssContribution[1]; // Only employee share is deducted

        // HDMF (Pag-IBIG) Computation
        govtHDMF = 0.00;
        if (grossIncome >= 1000 && grossIncome <= 1500) {
            govtHDMF = 0.01 * grossIncome;
        } else if (grossIncome > 1500) {
            govtHDMF = 0.02 * grossIncome;
        }

        // PhilHealth Computation
        govtPhilHealth = 0.00;
        if (grossIncome <= 10000) {
            govtPhilHealth = 0.03 * grossIncome;
        } else if (grossIncome > 10000 && grossIncome <= 59999.99) {
            govtPhilHealth = 0.03 * grossIncome;
        } else if (grossIncome >= 60000.00) {
            govtPhilHealth = 0.03 * grossIncome;
        }

        // BIR Withholding Tax Computation
        govtBirTax = 0;
        if (grossIncome > 20832 && grossIncome <= 33333) {
            govtBirTax = 0.20 * (grossIncome - 20833);
        } else if (grossIncome > 33333 && grossIncome <= 66667) {
            govtBirTax = (0.25 * (grossIncome - 33333)) + 2500;
        } else if (grossIncome > 66667 && grossIncome <= 166667) {
            govtBirTax = (0.30 * (grossIncome - 66667)) + 10833;
        } else if (grossIncome > 166667 && grossIncome <= 666667) {
            govtBirTax = (0.32 * (grossIncome - 166667)) + 40833.33;
        } else if (grossIncome > 666667) {
            govtBirTax = (0.35 * (grossIncome - 666667)) + 200833.33;
        }

        // Compute Net Pay
        combinedGovt = (govtSSS + govtHDMF + govtPhilHealth + govtBirTax);
        netPay = (grossIncome - combinedGovt);

        // Console Output
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(("Employee Number: " + EMPID) + " | " + ("Employee Name: " + EMPNAME) + " | " + ("Employee Date of Birth: " + EMPDOB));
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Employee Timesheet");
        System.out.println("No. of Hours worked for the week: " + workedHoursWeekly + " hours");
        System.out.println("Government Deductions: PHP " + String.format("%.2f", combinedGovt));
        System.out.println("Gross Bi-Weekly Income: PHP " + String.format("%.2f", grossIncome));
        System.out.println("Net Bi-Weekly Income: PHP " + String.format("%.2f", netPay));
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Breakdown of Government Deductions");
        System.out.println("SSS Deductions: PHP " + String.format("%.2f", govtSSS));
        System.out.println("HDMF Deductions: PHP " + String.format("%.2f", govtHDMF));
        System.out.println("PhilHealth Deductions: PHP " + String.format("%.2f", govtPhilHealth));
        System.out.println("BIR Tax Deductions: PHP " + String.format("%.2f", govtBirTax));
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }
}
