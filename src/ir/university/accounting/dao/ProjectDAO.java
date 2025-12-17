package ir.university.accounting.dao;



public class ProjectDAO {
    public void addProject(String name,String employer,String start,String end,double amount) {

        String sql =" INSERT INTO projects" +
                "(project_name, employer, start_date, end_date, contract_amount)" +
        "VALUES(?,?,?,?,?)";


    }
}
