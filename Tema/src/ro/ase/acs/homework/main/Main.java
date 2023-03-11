package ro.ase.acs.homework.main;

import ro.ase.acs.homework.classes.*;
import ro.ase.acs.homework.interfaces.ConnectionCreator;
import ro.ase.acs.homework.interfaces.Inserter;
import ro.ase.acs.homework.interfaces.ObjectReader;
import ro.ase.acs.homework.interfaces.TableCreator;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConnectionCreator connectionCreator = new ConnectionCreatorInSQLite();
        try {
            Connection connection = connectionCreator.createConnection();

            TableCreator tableCreator = new TableCreatorSQLite();
            tableCreator.createData(connection);

            Inserter employeeInserter = new EmployeeInserter();
            employeeInserter.insertData(connection, new Employee(1, "Popescu Ion", "Bucharest", 4000));
            employeeInserter.insertData(connection, new Employee(2, "Ionescu Vasile", "Brasov", 4500));

            ObjectReader employeeReader = new EmployeeReader();
            employeeReader.readData(connection);

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
