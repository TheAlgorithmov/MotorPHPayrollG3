/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package h1101.group3.pagibigcontribution;

/**
 *
 * @author HP
 */
import java.util.Scanner;

public class PagibigContribution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for employee's salary
        System.out.print("Enter your monthly salary: ");
        double salary = input.nextDouble();

        // Pag-IBIG contribution computation
        double employeeShare;
        double employerShare;
        
        if (salary <= 1500) {
            employeeShare = salary * 0.01; // 1% for salaries ≤ ₱1,500
        } else {
            employeeShare = salary * 0.02; // 2% for salaries > ₱1,500
        }

        employerShare = salary * 0.02; // Employer share is always 2%

        // Apply the contribution cap of ₱100
        if (employeeShare > 100) {
            employeeShare = 100;
        }
        if (employerShare > 100) {
            employerShare = 100;
        }

        double totalContribution = employeeShare + employerShare;

        // Display results
        System.out.println("\nPag-IBIG Contribution Breakdown:");
        System.out.printf("Employee Share: %.2f%n", employeeShare);
        System.out.printf("Employer Share: %.2f%n", employerShare);
        System.out.printf("Total Contribution: %.2f%n", totalContribution);

        input.close();
    }
}
