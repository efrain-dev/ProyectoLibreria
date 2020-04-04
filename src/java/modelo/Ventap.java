/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author efrai
 */
@Entity
@Table(name = "ventap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventap.findAll", query = "SELECT v FROM Ventap v")
    , @NamedQuery(name = "Ventap.findByIdventap", query = "SELECT v FROM Ventap v WHERE v.idventap = :idventap")
    , @NamedQuery(name = "Ventap.findByCantidad", query = "SELECT v FROM Ventap v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Ventap.findByPrecioVental", query = "SELECT v FROM Ventap v WHERE v.precioVental = :precioVental")})
public class Ventap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idventap")
    private Integer idventap;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @Size(max = 45)
    @Column(name = "precioVental")
    private String precioVental;
    @JoinColumn(name = "productos_idproductos", referencedColumnName = "idproductos")
    @ManyToOne(optional = false)
    private Productos productosIdproductos;
    @JoinColumn(name = "ventas_idventas", referencedColumnName = "idventas")
    @ManyToOne(optional = false)
    private Ventas ventasIdventas;

    public Ventap() {
    }

    public Ventap(Integer idventap) {
        this.idventap = idventap;
    }

    public Integer getIdventap() {
        return idventap;
    }

    public void setIdventap(Integer idventap) {
        this.idventap = idventap;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioVental() {
        return precioVental;
    }

    public void setPrecioVental(String precioVental) {
        this.precioVental = precioVental;
    }

    public Productos getProductosIdproductos() {
        return productosIdproductos;
    }

    public void setProductosIdproductos(Productos productosIdproductos) {
        this.productosIdproductos = productosIdproductos;
    }

    public Ventas getVentasIdventas() {
        return ventasIdventas;
    }

    public void setVentasIdventas(Ventas ventasIdventas) {
        this.ventasIdventas = ventasIdventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventap != null ? idventap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventap)) {
            return false;
        }
        Ventap other = (Ventap) object;
        if ((this.idventap == null && other.idventap != null) || (this.idventap != null && !this.idventap.equals(other.idventap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ventap[ idventap=" + idventap + " ]";
    }
    
}
