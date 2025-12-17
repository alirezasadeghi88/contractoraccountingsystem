package ir.university.accounting.dao;

import ir.university.accounting.util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class PaymentDAO {
    public void addPayment(int projectId,double amount, String date) {

        String sql = "INSERT INTO payments" +
                "(project_id, amount, payment_date)" +
                "VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1,projectId);
            preparedStatement.setDouble(2,amount);
            preparedStatement.setDate(3, Date.valueOf(date));

            preparedStatement.executeUpdate();
            System.out.println(" Payment added✅");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
