/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author efrai
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByIdventas", query = "SELECT v FROM Ventas v WHERE v.idventas = :idventas")
    , @NamedQuery(name = "Ventas.findByFecha", query = "SELECT v FROM Ventas v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Ventas.findByMontototal", query = "SELECT v FROM Ventas v WHERE v.montototal = :montototal")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idventas")
    private Integer idventas;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "montototal")
    private String montototal;
    @JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdcliente;
    @JoinColumn(name = "empleado_dpiEmpleado", referencedColumnName = "dpiEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleadodpiEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventasIdventas")
    private Collection<Ventap> ventapCollection;

    public Ventas() {
    }

    public Ventas(Integer idventas) {
        this.idventas = idventas;
    }

    public Integer getIdventas() {
        return idventas;
    }

    public void setIdventas(Integer idventas) {
        this.idventas = idventas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMontototal() {
        return montototal;
    }

    public void setMontototal(String montototal) {
        this.montototal = montototal;
    }

    public Cliente getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Cliente clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    public Empleado getEmpleadodpiEmpleado() {
        return empleadodpiEmpleado;
    }

    public void setEmpleadodpiEmpleado(Empleado empleadodpiEmpleado) {
        this.empleadodpiEmpleado = empleadodpiEmpleado;
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
        hash += (idventas != null ? idventas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idventas == null && other.idventas != null) || (this.idventas != null && !this.idventas.equals(other.idventas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ventas[ idventas=" + idventas + " ]";
    }
    
}
