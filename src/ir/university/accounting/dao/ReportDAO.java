package ir.university.accounting.dao;

import ir.university.accounting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReportDAO {
    private double getSum(String table, int projectId)throws Exception {

        String sql = "SELECT COALESCE(SUM(amount),0) FROM" +
                table + " WHERE project_id=?";


    }
}
