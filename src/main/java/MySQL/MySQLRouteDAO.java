package MySQL;

import DAO.AbstractJDBCDao;
import DAO.PersistException;
import Domain.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexander on 30.03.2015.
 */
public class MySQLRouteDAO extends AbstractJDBCDao<Route, Integer> {

    private class PersistRoute extends Route {
        public void setId(int id) {
            super.setId(id);
        }
    }
    @Override
    public String getSelectQuery() {
        return "SELECT idRoute, Car, State FROM Route;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Route VALUES (?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Route SET Car = ?, State = ? WHERE idRoute = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Route WHERE idRoute = ?;";
    }

    @Override
    public Route create() throws PersistException {
        Route route = new Route();
        return persist(route);
    }

    @Override
    protected List<Route> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Route> result = new LinkedList<Route>();
        try {
            while (rs.next()) {
                PersistRoute route = new PersistRoute();
                route.setId(rs.getInt("idRoute"));
                route.setCar(rs.getString("Car"));
                route.setState(rs.getInt("State"));
                result.add(route);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Route object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getCar());
            statement.setInt(3, object.getState());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Route object) throws PersistException {
        try {
            statement.setString(1, object.getCar());
            statement.setInt(2, object.getState());
            statement.setInt(3, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    public MySQLRouteDAO(Connection connection) {
        super(connection);
    }

}
