package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="sucursals", uniqueConstraints = @UniqueConstraint(columnNames = "nomSucursal"))
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_SucursalID;
    @Column(nullable = false)
    @Size(min = 4, max = 40, message = "{Size.Sucursal.nomSucursal}")
    @NotBlank(message = "{NotBlank.Sucursal.nomSucursal}")
    private String nomSucursal;
    @Column(nullable = false)
    @NotBlank(message = "{NotBlank.Sucursal.paisSucursal}")
    private String paisSucursal;

    public Sucursal() {

    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

}
