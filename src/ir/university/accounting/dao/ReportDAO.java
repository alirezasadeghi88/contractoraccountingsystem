package ir.university.accounting.dao;

import ir.university.accounting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDAO {
    private double getSum(String table, int projectId)throws Exception {

        String sql = "SELECT COALESCE(SUM(amount),0) FROM" +
                table + " WHERE project_id=?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,projectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                return resultSet.getDouble(1);
        }
        return 0;
    }

    public void printReport(int projectId) {

        try {
            double expenses = getSum("expenses",projectId);
            double payments = getSum("payments", projectId);

            System.out.println("====== Financial Report ======");
            System.out.println("Total Expenses: " + expenses);
            System.out.println("Total Payments: " + payments);
            System.out.println("Profit / Loss: " + (payments -expenses));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
