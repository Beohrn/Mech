package DAO;

/**
 * Created by Alexander on 29.03.2015.
 *
 * фабрика объектов для работы с базой данных
 */
public interface DAOFactory<Context> {

    public interface DAOCreator<Context> {
        public GenericDao create(Context context);
    }

    public Context getContext() throws PersistException;

    public GenericDao getDao(Context context, Class dtoClass) throws PersistException;


}
