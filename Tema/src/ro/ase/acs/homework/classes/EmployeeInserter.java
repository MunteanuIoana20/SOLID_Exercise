package ro.ase.acs.homework.classes;

import ro.ase.acs.homework.interfaces.Inserter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeInserter implements Inserter {
    @Override
    public void insertData(Connection connection, Object object) throws SQLException {

        String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertWithParams);

        preparedStatement.setInt(1, ((Employee) object).getId());
        preparedStatement.setString(2, ((Employee) object).getName());
        preparedStatement.setString(3, ((Employee) object).getAddress());
        preparedStatement.setDouble(4, ((Employee) object).getSalary());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();

    }
}
