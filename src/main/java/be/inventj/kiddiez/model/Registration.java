package be.inventj.kiddiez.model;

import java.util.Date;

public class Registration {

    private Date in;
    private Date out;

    private Kid kid;

    public Date getIn() {
        return in;
    }

    public void setIn(Date in) {
        this.in = in;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

    public Kid getKid() {
        return kid;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }
}
