package ir.university.accounting.dao;

import ir.university.accounting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {
    public void addPayment(int projectId,double amount, String date) {

        String sql = "INSERT INTO payments" +
                "(project_id, amount, payment_date)" +
                "VALUES (?, ?, ?)";


    }
}
