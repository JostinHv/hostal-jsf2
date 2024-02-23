package domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Cuenta {

    @Id
    @Column(name = "id")
    private int ID;

    @Column(name = "usuario")
    private String user;

    @Column(name = "pass")
    private String pass;

    public Cuenta() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int idCuenta) {
        this.ID = idCuenta;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}