package ir.university.accounting.dao;

import ir.university.accounting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExpenseDAO {
    public void addExpense(int projectId,String desc,double amount, String date) {

        String sql = "INSERT INTO expenses" +
                "(project_id, description, amount, expense_date)" +
                "VALUES(?,?,?,?";



    }
}
