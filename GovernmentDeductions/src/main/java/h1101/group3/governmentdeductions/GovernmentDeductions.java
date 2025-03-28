/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package h1101.group3.governmentdeductions;

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class GovernmentDeductions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for employee's salary
        System.out.print("Kindly enter your monthly salary: PHP ");
        double salary = input.nextDouble();

        // Compute SSS Contribution
        double sssEmployeeShare = salary * 0.045; // 4.5% of salary
        double sssEmployerShare = salary * 0.09;  // 9% of salary

        if (sssEmployeeShare > 900) sssEmployeeShare = 900; // Max cap
        if (sssEmployerShare > 1800) sssEmployerShare = 1800;

        // Compute Pag-IBIG Contribution
        double pagibigEmployeeShare = (salary <= 1500) ? salary * 0.01 : salary * 0.02;
        double pagibigEmployerShare = salary * 0.02;

        if (pagibigEmployeeShare > 100) pagibigEmployeeShare = 100; // Max cap
        if (pagibigEmployerShare > 100) pagibigEmployerShare = 100;

        // Compute PhilHealth Contribution (Shared 50/50)
        double philhealthTotal = salary * 0.05; // 5% of salary
        double philhealthEmployeeShare = philhealthTotal / 2;
        double philhealthEmployerShare = philhealthTotal / 2;

        // Compute Income Tax (Simplified Bracket)
        double incomeTax = 0;
        if (salary > 25000) {
            incomeTax = salary * 0.20; // 20% tax for simplicity
        } else if (salary > 15000) {
            incomeTax = salary * 0.10;
        }

        // Compute Total Deductions
        double totalDeductions = sssEmployeeShare + pagibigEmployeeShare + philhealthEmployeeShare + incomeTax;
        double netSalary = salary - totalDeductions;

        // Total Salary and Deductions Breakdown
        System.out.println("\nGovernment Deductions Breakdown:");
        System.out.printf("SSS Employee Share: %.2f | Employer Share: %.2f%n", sssEmployeeShare, sssEmployerShare);
        System.out.printf("Pag-IBIG Employee Share: %.2f | Employer Share: %.2f%n", pagibigEmployeeShare, pagibigEmployerShare);
        System.out.printf("PhilHealth Employee Share: %.2f | Employer Share: %.2f%n", philhealthEmployeeShare, philhealthEmployerShare);
        System.out.printf("Income Tax: %.2f%n", incomeTax);
        System.out.println("-----------------------------");
        System.out.printf("Total Deductions: %.2f%n", totalDeductions);
        System.out.printf("Net Salary: PHP %.2f%n", netSalary);

        input.close();
    }
}