package com.payroll;

public class system {
    public static void main(String[] args) {

        String EMPID;
        String EMPNAME;
        String EMPDOB;
        Integer Worked_hours_weekly;
        Double Daily_Salary;
        Double govt_sss;
        Double govt_philhealth;
        Double govt_hdmf;
        Double govt_birtax;
        Double combined_govt;
        Double gross_income;
        Double net_pay;

        EMPID = "7819201";
        EMPNAME = "Noah Eason Gray";
        EMPDOB = "2001-05-15";
        Worked_hours_weekly = 40;
        Daily_Salary = 117.19;
        gross_income = (Daily_Salary * Worked_hours_weekly);
        govt_sss = (gross_income * 0.05);

        // This will be the computation for HDMF Pag-Ibig Government Benefit Deduction
            govt_hdmf = 0.00;
        if (gross_income >= 1000 && gross_income <= 1500) {
            govt_hdmf = 0.01 * gross_income;
        } else if (gross_income > 1500) {
            govt_hdmf = 0.02 * gross_income;
        } else {
            govt_hdmf = 0.00;
        }
        // This will be the computation for PhilHealth Government Benefit Deduction
        govt_philhealth = 0.00;
        if (gross_income <= 10000) {
            govt_philhealth = 0.03 * gross_income;
        } else if (gross_income >= 10000.01 && gross_income <= 59999.99) {
            govt_philhealth = 0.03 * gross_income;
        } else if (gross_income >= 60000.00) {
            govt_philhealth = 0.03 * gross_income;
        }

        // This will be the computation for BIR Withholding Tax Government Deduction
        govt_birtax = 0.00;
        if (gross_income <= 20832.00) {
            govt_birtax = 0.00;
        } else if (gross_income >= 20833.00 && gross_income <= 33333.00) {
            govt_birtax = 0.20 * (gross_income - 20833);
        } else if (gross_income >= 33333 && gross_income <= 66667) {
            govt_birtax = ((0.25 * (gross_income - 33333)) + 2500);
        } else if (gross_income >= 66667 && gross_income <= 166667) {
            govt_birtax = ((0.30 * (gross_income - 66667)) + 10833);
        } else if (gross_income >= 166667 && gross_income <= 666667) {
            govt_birtax = ((0.32 * (gross_income - 166667)) + 40833.33);
        } else if (gross_income >= 666667) {
            govt_birtax = ((0.35 * (gross_income - 666667)) + 200833.33);
        }


        combined_govt = (govt_sss + govt_philhealth + govt_birtax);
        net_pay = (gross_income - combined_govt);

        System.out.println(" -----------------------------  ");
        System.out.println(("Employee Number: " + EMPID) + " | " +("Employee Name: " + EMPNAME) + " | " + ("Employee Date of Birth: " + EMPDOB));
        System.out.println(" ----------------------------- ");
        System.out.println("Employee Timesheet");
        System.out.println("No. of Hours worked for the week: " + Worked_hours_weekly + " hours");
        System.out.println("Gross Weekly Salary: ₱ " + gross_income) ;
        System.out.println("Govt Deductions: ₱ " + combined_govt);
        System.out.println("Net Weekly Salary: ₱ " + net_pay);
        System.out.println(" -----------------------------  ");
    }
}
