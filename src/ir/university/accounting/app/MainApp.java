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


        }
    }
}
