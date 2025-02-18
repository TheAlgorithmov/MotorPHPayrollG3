package com.payroll;

import java.util.TreeMap;
import java.util.NavigableMap;

public class MotorPHPayrollG3 {
    public static void main(String[] args) {
        // ------------------------------------------------------------------------------------
        // EMPLOYEE & PAYROLL DETAILS
        // ------------------------------------------------------------------------------------
        String EMPID = "10015";
        int workedHoursWeekly = 40; // Standard DOLE work week (40 hrs)
        String EMPNAME = (EmpDB.employeeData.getOrDefault(Integer.valueOf(EMPID), "Employee not found.")); // Employee name based on EMPID, lookup using EmpDB.java class
        String EMPDOB = (EmpDB.empBD.getOrDefault(Integer.valueOf(EMPID), "Employee not found.")); // Employee's Date of Birth based on EMPID, lookup using EmpDB.java class

        double hourlyRate = EmpDB.empTime.getOrDefault(Integer.valueOf(EMPID), 0.0); // Hourly Salary based on MotorPHs salary packages
        double dailySalary = hourlyRate * 8; // Daily salary for an 8-hour workday

        // Work schedule (Weekly)
        int weeklyWorkDays = 5;
        int[] workTypes = {1, 3, 1, 4, 5}; // Work Type per day
        int[] overtimeHoursPerDay = {2, 0, 3, 4, 2}; // Overtime in hours
        int[] unpaidTimePerDay = {0, 10, 0, 15, 0}; // Late minutes

        // ------------------------------------------------------------------------------------
        // WEEKLY INCOME, OVERTIME, AND UNPAID DEDUCTIONS
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
        // GOVERNMENT DEDUCTIONS (SSS, PhilHealth, Pag-IBIG, BIR Tax)
        // ------------------------------------------------------------------------------------

        // SSS CONTRIBUTION (Jan 2024 Table)
        NavigableMap<Double, Double> sssTable = new TreeMap<>();
        sssTable.put(3250.0, 135.00);
        sssTable.put(3750.0, 157.50);
        sssTable.put(4250.0, 180.00);
        sssTable.put(4750.0, 202.50);
        sssTable.put(5250.0, 225.00);
        sssTable.put(5750.0, 247.50);
        sssTable.put(6250.0, 270.00);
        sssTable.put(6750.0, 292.50);
        sssTable.put(7250.0, 315.00);
        sssTable.put(7750.0, 337.50);
        sssTable.put(8250.0, 360.00);
        sssTable.put(8750.0, 382.50);
        sssTable.put(9250.0, 405.00);
        sssTable.put(9750.0, 427.50);
        sssTable.put(10250.0, 450.00);
        sssTable.put(10750.0, 472.50);
        sssTable.put(11250.0, 495.00);
        sssTable.put(11750.0, 517.50);
        sssTable.put(12250.0, 540.00);
        sssTable.put(12750.0, 562.50);
        sssTable.put(13250.0, 585.00);
        sssTable.put(13750.0, 607.50);
        sssTable.put(14250.0, 630.00);
        sssTable.put(14750.0, 652.50);
        sssTable.put(15250.0, 675.00);
        sssTable.put(15750.0, 697.50);
        sssTable.put(16250.0, 720.00);
        sssTable.put(16750.0, 742.50);
        sssTable.put(17250.0, 765.00);
        sssTable.put(17750.0, 787.50);
        sssTable.put(18250.0, 810.00);
        sssTable.put(18750.0, 832.50);
        sssTable.put(19250.0, 855.00);
        sssTable.put(19750.0, 877.50);
        sssTable.put(20250.0, 900.00);
        sssTable.put(24750.0, 1125.00);
        double govtSSS = sssTable.floorEntry(grossIncome).getValue();
  
        // PAG-IBIG CONTRIBUTION (Pro-rated Weekly)
        double monthlyHDMF = (grossIncome <= 1500) ? Math.min(100, 0.01 * grossIncome) : Math.min(100, 0.02 * grossIncome);
        double govtHDMF = monthlyHDMF / 4;

        // PHILHEALTH CONTRIBUTION (Deducted Monthly)
        double monthlyPhilHealth = (grossIncome <= 10000) ? 300 : Math.min(1800, 0.03 * grossIncome);
        double govtPhilHealth = (monthlyPhilHealth / 2) / 4; // Employee share divided by 4 for weekly deduction

        // BIR WITHHOLDING TAX (DOLE Rates)
        double taxableIncome = grossIncome - (govtSSS + monthlyPhilHealth / 2 + monthlyHDMF);
        double govtBirTax = 0;

        if (taxableIncome > 20832 && taxableIncome < 33333) {
            govtBirTax = 0.20 * (taxableIncome - 20833);
        } else if (taxableIncome >= 33333 && taxableIncome < 66667) {
            govtBirTax = 2500 + 0.25 * (taxableIncome - 33333);
        } else if (taxableIncome >= 66667 && taxableIncome < 166667) {
            govtBirTax = 10833 + 0.30 * (taxableIncome - 66667);
        } else if (taxableIncome >= 166667 && taxableIncome < 666667) {
            govtBirTax = 40833.33 + 0.32 * (taxableIncome - 166667);
        } else if (taxableIncome >= 666667) {
            govtBirTax = 200833.33 + 0.35 * (taxableIncome - 666667);
        }


        // ------------------------------------------------------------------------------------
        // NET PAY COMPUTATION
        // ------------------------------------------------------------------------------------
        double totalDeductions = govtSSS + govtHDMF + govtPhilHealth + govtBirTax + totalUnpaidDeductions;
        double netPay = grossIncome - totalDeductions;

        // ------------------------------------------------------------------------------------
        // FINAL PAYROLL REPORT (WEEKLY) - PRINT LAST
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
        System.out.println("SSS Contribution (Employee Share): PHP " + String.format("%.2f", govtSSS));
        System.out.println("Pag-IBIG Contribution: PHP " + String.format("%.2f", govtHDMF));
        System.out.println("PhilHealth Contribution: PHP " + String.format("%.2f", govtPhilHealth));
        System.out.println("BIR Withholding Tax (Weekly): PHP " + String.format("%.2f", govtBirTax));
        System.out.println("--------------------------------------------------------------");
    }
}
