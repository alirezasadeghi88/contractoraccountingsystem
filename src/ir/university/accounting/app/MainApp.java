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







    }
}
