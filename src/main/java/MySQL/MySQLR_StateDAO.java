package MySQL;

import DAO.AbstractJDBCDao;
import DAO.PersistException;
import Domain.R_State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexander on 30.03.2015.
 */
public class MySQLR_StateDAO extends AbstractJDBCDao<R_State, Integer> {

    private class PersistR_State extends R_State {
        public void setId(int id) {
            super.setId(id);
        }
    }

    public MySQLR_StateDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT idState_type, value FROM R_State;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO R_State VALUES (?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE R_State SET value = ? WHERE idSate_type = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM R_State WHERE idState_type = ?;";
    }

    @Override
    protected List<R_State> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<R_State> result = new LinkedList<R_State>();
        try {
            while (rs.next()) {
                PersistR_State r_state = new PersistR_State();
                r_state.setId(rs.getInt("idState_type"));
                r_state.setValue(rs.getString("Value"));
                result.add(r_state);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, R_State object) throws PersistException {
        try {
            statement.setInt(1, 3);
            statement.setString(2, "dfds");
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, R_State object) throws PersistException {
        try {
            statement.setString(1, object.getValue());
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public R_State create() throws PersistException {
        R_State r_state = new R_State();
        return persist(r_state);
    }


}
