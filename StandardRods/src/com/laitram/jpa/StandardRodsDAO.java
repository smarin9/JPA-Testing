package com.laitram.jpa;

import java.sql.SQLException;
import java.util.List;

public interface StandardRodsDAO {
    List<StandardRods> getStandardRods(String seriesInd, String beltStyleInd, String materialInd, String colorInd) throws SQLException;
}
