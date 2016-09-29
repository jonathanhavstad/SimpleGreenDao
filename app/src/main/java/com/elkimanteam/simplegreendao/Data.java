package com.elkimanteam.simplegreendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jonathanhavstad on 9/29/16.
 */

@Entity
public class Data {
    private String x;
    private int y;

    @Generated(hash = 147226065)
    public Data(String x, int y) {
        this.x = x;
        this.y = y;
    }

    @Generated(hash = 2135787902)
    public Data() {
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("x: " + x);
        sb.append(" ");
        sb.append("y: " + y);
        return sb.toString();
    }
}
