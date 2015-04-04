package Domain;

import DAO.Identified;

/**
 * Created by Alexander on 29.03.2015.
 */
public class Route implements Identified<Integer> {

    private Integer id = null;
    private String car;
    private int state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
