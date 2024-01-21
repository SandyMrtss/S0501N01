package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.domain.Sucursal;
import org.thymeleaf.util.StringUtils;

import java.util.*;

public class SucursalDTO {
    private final static List<String> countriesEU = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));
    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    public SucursalDTO() {

    }
    public SucursalDTO(Sucursal sucursal){
        this.pk_SucursalID = sucursal.getPk_SucursalID();
        this.nomSucursal = sucursal.getNomSucursal();
        String pais = sucursal.getPaisSucursal().toLowerCase();
        this.paisSucursal = StringUtils.capitalizeWords(pais);
        this.tipusSucursal = tipusPaisSucursal();
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
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

    private String tipusPaisSucursal() {
        if(isEU(this.paisSucursal)){
            return "EU";
        }
        else {
            return  "Non EU";
        }
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

    private boolean isEU(String country) {
        return countriesEU.contains(country);
    }
}
