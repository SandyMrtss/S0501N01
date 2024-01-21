package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface SucursalService {
    public void addSucursal(Sucursal sucursal);
    public void updateSucursal(Sucursal sucursal);
    public void deleteSucursal(Integer id);
    public Sucursal getOneSucursal(Integer id);
    public List<SucursalDTO> getAllSucursal();
    public SucursalDTO sucursalToDTO(Sucursal sucursal);
    public Sucursal findByName(String nomSucursal);
}
