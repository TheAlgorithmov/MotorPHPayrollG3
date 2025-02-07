package com.payroll;

public class system {
    public static void main(String[] args) {

        String EMPID;
        String EMPNAME;
        String EMPDOB;
        int workedHoursWeekly;
        double dailySalary;
        double govtSSS;
        double govtPhilHealth;
        double govtHDMF;
        double govtBirthTax;
        double combinedGovt;
        double grossIncome;
        double netPay;

        EMPID = "7819201";
        EMPNAME = "Noah Eason Gray";
        EMPDOB = "2001-05-15";
        workedHoursWeekly = 40;
        dailySalary = 117.19;
        grossIncome = (dailySalary * workedHoursWeekly);
        govtSSS = (grossIncome * 0.05);

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
        govtBirthTax = 0.00;
        if (grossIncome <= 20832.00) {
            govtBirthTax = 0.00;
        } else if (grossIncome >= 20833.00 && grossIncome <= 33333.00) {
            govtBirthTax = 0.20 * (grossIncome - 20833);
        } else if (grossIncome >= 33333 && grossIncome <= 66667) {
            govtBirthTax = ((0.25 * (grossIncome - 33333)) + 2500);
        } else if (grossIncome >= 66667 && grossIncome <= 166667) {
            govtBirthTax = ((0.30 * (grossIncome - 66667)) + 10833);
        } else if (grossIncome >= 166667 && grossIncome <= 666667) {
            govtBirthTax = ((0.32 * (grossIncome - 166667)) + 40833.33);
        } else if (grossIncome >= 666667) {
            govtBirthTax = ((0.35 * (grossIncome - 666667)) + 200833.33);
        }


        combinedGovt = (govtSSS + govtPhilHealth + govtBirthTax);
        netPay = (grossIncome - combinedGovt);

        System.out.println(" -----------------------------  ");
        System.out.println(("Employee Number: " + EMPID) + " | " +("Employee Name: " + EMPNAME) + " | " + ("Employee Date of Birth: " + EMPDOB));
        System.out.println(" ----------------------------- ");
        System.out.println("Employee Timesheet");
        System.out.println("No. of Hours worked for the week: " + workedHoursWeekly + " hours");
        System.out.println("Gross Weekly Salary: ₱ " + grossIncome) ;
        System.out.println("Govt Deductions: ₱ " + combinedGovt);
        System.out.println("Net Weekly Salary: ₱ " + netPay);
        System.out.println(" -----------------------------  ");
    }
}
