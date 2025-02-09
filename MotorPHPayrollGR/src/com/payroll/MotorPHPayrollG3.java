package com.payroll;

import java.util.TreeMap;
import java.util.NavigableMap;

public class MotorPHPayrollG3 {
    public static void main(String[] args) {
        // ------------------------------------------------------------------------------------
        // 🏢 EMPLOYEE & PAYROLL DETAILS
        // ------------------------------------------------------------------------------------
        String EMPID = "7819201";
        String EMPNAME = "Noah Eason Gray";
        String EMPDOB = "2001-05-15";

        int workedHoursWeekly = 40; // Standard DOLE work week (40 hrs)
        double hourlyRate = 117.56; // Already correct hourly rate
        double dailySalary = hourlyRate * 8; // Daily salary for an 8-hour workday

        // Work schedule (Weekly)
        int weeklyWorkDays = 5;
        int[] workTypes = {1, 3, 1, 4, 5}; // Work Type per day
        int[] overtimeHoursPerDay = {2, 0, 3, 4, 2}; // Overtime in hours
        int[] unpaidTimePerDay = {0, 10, 0, 15, 0}; // Late minutes

        // ------------------------------------------------------------------------------------
        // 💰 WEEKLY INCOME, OVERTIME, AND UNPAID DEDUCTIONS
        // ------------------------------------------------------------------------------------
        double grossIncome = 0;
        double totalOvertimePay = 0;
        double totalUnpaidDeductions = 0;

        // Overtime breakdown
        double regularOT = 0;
        double specialHolidayOT = 0;
        double regularHolidayOT = 0;
        double restHolidayOT = 0;

        // Store formatted breakdown output for printing later
        StringBuilder breakdownOutput = new StringBuilder();
        breakdownOutput.append("\n---------------- Overtime & Unpaid Work Hour Deductions Breakdown ----------------\n");
        breakdownOutput.append("Day | Work Type         | OT Hours | OT Rate | OT Pay      | Late Minutes | Late Deduction\n");
        breakdownOutput.append("----------------------------------------------------------------------------------------\n");

        for (int i = 0; i < weeklyWorkDays; i++) {
            int workType = workTypes[i];
            int overtimeHours = overtimeHoursPerDay[i];
            int unpaidMinutes = unpaidTimePerDay[i];

            double dailyIncome = dailySalary;
            double dailyOvertimePay = 0;
            double dailyUnpaidDeduction = (hourlyRate / 60) * unpaidMinutes; // Deduct unpaid time

            // Apply DOLE OT & holiday pay rules
            double overtimeRate;
            String workTypeName;

            switch (workType) {
                case 3: // Special Holiday (130%)
                    dailyIncome *= 1.30;
                    overtimeRate = 1.69;
                    workTypeName = "Special Holiday";
                    specialHolidayOT += overtimeHours * overtimeRate * hourlyRate;
                    break;
                case 4: // Regular Holiday (200%)
                    dailyIncome *= 2;
                    overtimeRate = 2.0;
                    workTypeName = "Regular Holiday";
                    regularHolidayOT += overtimeHours * overtimeRate * hourlyRate;
                    break;
                case 5: // Rest + Holiday (260%)
                    dailyIncome *= 2.6;
                    overtimeRate = 2.6;
                    workTypeName = "Rest + Holiday";
                    restHolidayOT += overtimeHours * overtimeRate * hourlyRate;
                    break;
                default: // Regular Workday
                    overtimeRate = 1.25;
                    workTypeName = "Regular Workday";
                    regularOT += overtimeHours * overtimeRate * hourlyRate;
                    break;
            }

            dailyOvertimePay = overtimeHours * overtimeRate * hourlyRate;

            // Accumulate totals
            totalOvertimePay += dailyOvertimePay;
            totalUnpaidDeductions += dailyUnpaidDeduction;
            grossIncome += (dailyIncome + dailyOvertimePay - dailyUnpaidDeduction);

            // Append formatted breakdown output
            breakdownOutput.append(String.format(" %2d  | %-17s | %8d | %.2f   | PHP %8.2f | %12d | PHP %8.2f%n",
                    i + 1, workTypeName, overtimeHours, overtimeRate, dailyOvertimePay, unpaidMinutes, dailyUnpaidDeduction));
        }

        breakdownOutput.append("----------------------------------------------------------------------------------------\n");

        // ------------------------------------------------------------------------------------
        // 📌 GOVERNMENT DEDUCTIONS (SSS, PhilHealth, Pag-IBIG, BIR Tax)
        // ------------------------------------------------------------------------------------

        // 🔹 SSS CONTRIBUTION (Jan 2025 Table)
        NavigableMap<Double, double[]> sssTable = new TreeMap<>();
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
        double[] sssContribution = sssTable.floorEntry(grossIncome).getValue();
        double govtSSS = sssContribution[1]; // Employee Share
        double employerSSS = sssContribution[0] - govtSSS; // Employer Share

        // 🔹 PAG-IBIG CONTRIBUTION (Deducted Monthly)
        double govtHDMF = Math.min(200, 0.02 * grossIncome);
        double employerHDMF = govtHDMF;

        // 🔹 PHILHEALTH CONTRIBUTION (Deducted Monthly)
        double govtPhilHealth = (grossIncome <= 10000) ? 500 : Math.min(5000, 0.05 * grossIncome);

        // 🔹 BIR WITHHOLDING TAX (DOLE Rates)
        double govtBirTax = 0;
        if (grossIncome > 20832 && grossIncome <= 33333) {
            govtBirTax = 0.20 * (grossIncome - 20833);
        } else if (grossIncome > 33333 && grossIncome <= 66667) {
            govtBirTax = (0.25 * (grossIncome - 33333)) + 2500;
        }

        // ------------------------------------------------------------------------------------
        // 🏁 NET PAY COMPUTATION
        // ------------------------------------------------------------------------------------
        double totalDeductions = govtSSS + govtHDMF + govtPhilHealth + govtBirTax + totalUnpaidDeductions;
        double netPay = grossIncome - totalDeductions;

        // ------------------------------------------------------------------------------------
        // 📢 FINAL PAYROLL REPORT (WEEKLY) - PRINT LAST
        // ------------------------------------------------------------------------------------
        System.out.println("---------------- FINAL PAYROLL REPORT (WEEKLY) ----------------");
        System.out.println(" Employee Number: " + EMPID + " | Name: " + EMPNAME + " | DOB: " + EMPDOB);
        System.out.println("--------------------------------------------------------------");
        System.out.println(" Worked Hours (Per Week): " + workedHoursWeekly + " hours");
        System.out.println(" Gross Weekly Income: PHP " + String.format("%.2f", grossIncome));
        System.out.println(" Net Weekly Income: PHP " + String.format("%.2f", netPay));
        System.out.println("--------------------------------------------------------------");

        // Print Overtime & Unpaid Work Hour Deductions Breakdown
        System.out.println(breakdownOutput.toString());

        System.out.println(" Overtime Pay Earned: PHP " + String.format("%.2f", totalOvertimePay));
        System.out.println(" - Regular Day OT: PHP " + String.format("%.2f", regularOT));
        System.out.println(" - Special Holiday OT: PHP " + String.format("%.2f", specialHolidayOT));
        System.out.println(" - Regular Holiday OT: PHP " + String.format("%.2f", regularHolidayOT));
        System.out.println(" - Rest Day + Holiday OT: PHP " + String.format("%.2f", restHolidayOT));
        System.out.println("--------------------------------------------------------------");
        System.out.println(" Unpaid Work Hour Deductions: PHP " + String.format("%.2f", totalUnpaidDeductions));
        System.out.println("--------------------------------------------------------------");
        System.out.println(" Government Deductions:");
        System.out.println(" - SSS (Employee): PHP " + String.format("%.2f", govtSSS) + " | (Employer): PHP " + String.format("%.2f", employerSSS));
        System.out.println(" - HDMF (Employee): PHP " + String.format("%.2f", govtHDMF) + " | (Employer): PHP " + String.format("%.2f", employerHDMF));
        System.out.println(" - PhilHealth: PHP " + String.format("%.2f", govtPhilHealth));
        System.out.println(" - BIR Tax: PHP " + String.format("%.2f", govtBirTax));
        System.out.println("--------------------------------------------------------------");
    }
}
