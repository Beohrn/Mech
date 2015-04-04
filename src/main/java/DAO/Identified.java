package DAO;

import java.io.Serializable;

/**
 * Created by Alexander on 29.03.2015.
 *
 * Интерфейс идентифицируемых объектов.
 *
 */
public interface Identified<PK extends Serializable> {

    /** Возвращает идентификатор объекта */
    public PK getId();


}
