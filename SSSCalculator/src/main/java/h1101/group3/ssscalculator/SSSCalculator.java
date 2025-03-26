/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package h1101.group3.ssscalculator;

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class SSSCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for employee's salary
        System.out.print("Enter your monthly salary: ");
        double salary = input.nextDouble();

        // Variables for SSS contribution
        float employeeShare = 0;
        float employerShare = 0;

        // Compute SSS Contribution based on salary range
        if (salary < 4000) {
            System.out.println("No SSS deduction for salaries below 4,000.");
        } else if (salary <= 4999) {
            employeeShare = 180;
            employerShare = 360;
        } else if (salary <= 5999) {
            employeeShare = 225;
            employerShare = 450;
        } else if (salary <= 10999) {
            employeeShare = 450;
            employerShare = 900;
        } else if (salary >= 20000) {
            employeeShare = 900;
            employerShare = 1800;
        }

        // Compute total contribution
        float totalContribution = employeeShare + employerShare;

        // Display results
        System.out.println("\nSSS Contribution Breakdown:");
        System.out.println("Employee Share: " + employeeShare);
        System.out.println("Employer Share: " + employerShare);
        System.out.println("Total Contribution: " + totalContribution);
        
        input.close();
    }
}
