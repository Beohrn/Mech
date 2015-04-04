package DAO;

import Domain.Route;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexander on 29.03.2015.
 */
public interface RouteDao {

    public Route create();

    public Route read(int key);

    public void update(Route route);

    public void delete(Route route);
    
    public List<Route> getAll() throws SQLException;

}
