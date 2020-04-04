/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author efrai
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdproductos", query = "SELECT p FROM Productos p WHERE p.idproductos = :idproductos")
    , @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Productos.findByDespcripcion", query = "SELECT p FROM Productos p WHERE p.despcripcion = :despcripcion")
    , @NamedQuery(name = "Productos.findByCantidad", query = "SELECT p FROM Productos p WHERE p.cantidad = :cantidad")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproductos")
    private Integer idproductos;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "despcripcion")
    private String despcripcion;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosIdproductos")
    private Collection<Marca> marcaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosIdproductos")
    private Collection<Ventap> ventapCollection;

    public Productos() {
    }

    public Productos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    public Integer getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDespcripcion() {
        return despcripcion;
    }

    public void setDespcripcion(String despcripcion) {
        this.despcripcion = despcripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public Collection<Marca> getMarcaCollection() {
        return marcaCollection;
    }

    public void setMarcaCollection(Collection<Marca> marcaCollection) {
        this.marcaCollection = marcaCollection;
    }

    @XmlTransient
    public Collection<Ventap> getVentapCollection() {
        return ventapCollection;
    }

    public void setVentapCollection(Collection<Ventap> ventapCollection) {
        this.ventapCollection = ventapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductos != null ? idproductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idproductos == null && other.idproductos != null) || (this.idproductos != null && !this.idproductos.equals(other.idproductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Productos[ idproductos=" + idproductos + " ]";
    }
    
}
