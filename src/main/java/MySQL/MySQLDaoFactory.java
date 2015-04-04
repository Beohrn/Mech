package MySQL;

import DAO.DAOFactory;
import DAO.GenericDao;
import DAO.PersistException;
import Domain.R_State;
import Domain.Route;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander on 30.03.2015.
 */
public class MySQLDaoFactory implements DAOFactory<Connection> {

    private String login = "root";
    private String password = "1234";
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String driver = "com.mysql.jdbc.Driver";
    private Map<Class, DAOCreator> creators;

    @Override
    public Connection getContext() throws PersistException {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) throws PersistException {
        DAOCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("DAO object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }

    public MySQLDaoFactory() {
        try {
            Class.forName(driver);//register driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DAOCreator>();

        creators.put(R_State.class, new DAOCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySQLR_StateDAO(connection);
            }
        });

        creators.put(Route.class, new DAOCreator<Connection>() {


            @Override
            public GenericDao create(Connection connection) {
                return new MySQLRouteDAO(connection);
            }
        });
    }
}
