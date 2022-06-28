package ar.com.lautaro.clases;

import java.io.Serializable;
import java.util.Objects;

public class Transportes implements Serializable{

    // Campos
    private String contenido;
    private String proveedor;
    private String idChofer;

    // Constructor vacio
    public Transportes() {
    }

    // Constructor
    public Transportes(String contenido, String proveedor, String idChofer) {
        this.contenido = contenido;
        this.proveedor = proveedor;
        this.idChofer = idChofer;
    }

    // getter y setter
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(String idChofer) {
        this.idChofer = idChofer;
    }

    // hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idChofer);
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
        final Transportes other = (Transportes) obj;
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.proveedor, other.proveedor)) {
            return false;
        }
        if (!Objects.equals(this.idChofer, other.idChofer)) {
            return false;
        }
        return true;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transportes{Contenido= ").append(contenido);
        sb.append(", Proveedor= ").append(proveedor);
        sb.append(", id Chofer= ").append(idChofer);
        sb.append('}');
        return sb.toString();
    }

}
