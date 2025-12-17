package ir.university.accounting.dao;

import ir.university.accounting.util.DBConnection;
import java.sql.*;

public class ReportDAO {

    private double getExpensesSum(int projectId) throws Exception {
        String sql = "SELECT COALESCE(SUM(amount),0) FROM expenses WHERE project_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        }
        return 0;
    }

    private double getPaymentsSum(int projectId) throws Exception {
        String sql = "SELECT COALESCE(SUM(amount),0) FROM payments WHERE project_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        }
        return 0;
    }

    private double getContractAmount(int projectId) throws Exception {
        String sql = "SELECT contract_amount FROM projects WHERE project_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        }
        return 0;
    }

    public void printReport(int projectId) {
        try {
            double expenses = getExpensesSum(projectId);
            double payments = getPaymentsSum(projectId);
            double contractAmount = getContractAmount(projectId);

            System.out.println("====== Financial Report ======");
            System.out.println("Contract Amount: " + contractAmount);
            System.out.println("Total Expenses: " + expenses);
            System.out.println("Total Payments: " + payments);
            System.out.println("Profit / Loss: " + (payments - expenses));
            System.out.println("Progress (%): " +
                    (contractAmount > 0 ? (payments / contractAmount) * 100 : 0) + "%");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}