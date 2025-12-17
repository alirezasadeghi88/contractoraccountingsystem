package ir.university.accounting.dao;


import ir.university.accounting.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProjectDAO {
    public void addProject(String name,String employer,String start,String end,double amount) {

        String sql =" INSERT INTO projects" +
                "(project_name, employer, start_date, end_date, contract_amount)" +
        "VALUES(?,?,?,?,?)";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,employer);
            preparedStatement.setDate(3,java.sql.Date.valueOf(start));
            preparedStatement.setDate(4,java.sql.Date.valueOf(end));
            preparedStatement.setDouble(5,amount);

            preparedStatement.executeUpdate();
            System.out.println(" Project added successfully✅ ");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
