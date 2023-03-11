package ro.ase.acs.homework.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface TableCreator {
    void createData(Connection connection) throws SQLException;

}
