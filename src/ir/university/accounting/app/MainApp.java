package ir.university.accounting.app;

import ir.university.accounting.dao.ExpenseDAO;
import ir.university.accounting.dao.PaymentDAO;
import ir.university.accounting.dao.ProjectDAO;
import ir.university.accounting.dao.ReportDAO;

import java.util.Properties;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProjectDAO projectDAO = new ProjectDAO();
        ExpenseDAO expenseDAO = new ExpenseDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        ReportDAO reportDAO = new ReportDAO();

        while (true){
            System.out.println("""
                ==============================
                Contractor Accounting System
                ==============================
                1. Add Project
                2. Add Expense
                3. Add Payment
                4. Project Financial Report
                5. Exit
                Choose:
                """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

                case 1 ->{
                    System.out.print("Project Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Employer: ");
                    String employer = scanner.nextLine();

                    System.out.print("start: ");
                    String start = scanner.nextLine();

                    System.out.print("Start Date (YYYY-MM-DD)");
                    String end = scanner.nextLine();

                    System.out.print("Contract Amount: ");
                    double amount = scanner.nextDouble();

                    projectDAO.addProject(name, employer, start, end,amount);
                }

                case 2 ->{
                    System.out.print("Project ID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Description: ");
                    String desc = scanner.nextLine();

                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    expenseDAO.addExpense(pid, desc, amt, date);
                }

                case 3 ->{
                    System.out.print("Project ID: ");
                    int pid = scanner.nextInt();

                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    paymentDAO.addPayment(pid, amt, date);
                }

                case 4 ->{
                    System.out.print("Project ID: ");
                    int pid = scanner.nextInt();
                    reportDAO.printReport(pid);
                }

                case 5 ->{
                    System.out.print("👋 Exit");
                    System.exit(0);
                }
            }
        }
    }
}
