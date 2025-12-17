package ir.university.accounting.dao;

import ir.university.accounting.util.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;


public class ExpenseDAO {
    public void addExpense(int projectId, String desc,double amount, String date) {


        String sql = "INSERT INTO expenses " +
                "(project_id, description, amount, expense_date) " +
                "VALUES (?, ?, ?, ?)";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,projectId);
            preparedStatement.setString(2,desc);
            preparedStatement.setDouble(3,amount);
            preparedStatement.setDate(4, Date.valueOf(date));

            preparedStatement.executeUpdate();
            System.out.println(" Expense added✅");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
