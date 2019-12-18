/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.auter.patrol;

import java.sql.Date;

/**
 *
 * @author drobles
 */
public class SensorGpioTO {
    int id;
    int value;
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SensorGpio{" + "id=" + id + ", value=" + value + ", date=" + date + '}';
    }
    
}
