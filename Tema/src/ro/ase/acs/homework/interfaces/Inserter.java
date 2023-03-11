package ro.ase.acs.homework.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface Inserter {
    void insertData(Connection connection, Object object) throws SQLException;
}
