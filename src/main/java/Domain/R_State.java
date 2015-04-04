package Domain;

import DAO.Identified;

/**
 * Created by Alexander on 29.03.2015.
 */
public class R_State implements Identified<Integer>{

    private Integer id = null;
    private String value;

    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
