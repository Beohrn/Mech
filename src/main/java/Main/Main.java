package Main;

import DAO.DAOFactory;
import DAO.GenericDao;
import DAO.PersistException;
import Domain.R_State;
import MySQL.MySQLDaoFactory;
import MySQL.MySQLR_StateDAO;

import java.sql.Connection;

/**
 * Created by Alexander on 30.03.2015.
 */
public class Main {

    public static void main(String[] args) throws PersistException {
        DAOFactory factory = new MySQLDaoFactory();
        Connection connection = (Connection) factory.getContext();
        GenericDao dao = factory.getDao(connection, R_State.class);







    }
}
