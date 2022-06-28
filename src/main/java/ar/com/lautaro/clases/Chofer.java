package ar.com.lautaro.clases;

import java.io.Serializable;
import java.util.Objects;

public class Chofer implements Serializable{

    // Campos
    private String id;
    private String nombre;
    private int numeroCamion;

    // Constructor vacio
    public Chofer() {
    }

    // Constructor 
    public Chofer(String id, String nombre, int numeroCamion) {
        this.id = id;
        this.nombre = nombre;
        this.numeroCamion = numeroCamion;
    }

    // Getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCamion() {
        return numeroCamion;
    }

    public void setNumeroCamion(int numeroCamion) {
        this.numeroCamion = numeroCamion;
    }

    // hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.numeroCamion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chofer other = (Chofer) obj;
        if (this.numeroCamion != other.numeroCamion) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chofer{id= ").append(id);
        sb.append(", nombre= ").append(nombre);
        sb.append(", numero de camion= ").append(numeroCamion);
        sb.append('}');
        return sb.toString();
    }

}
