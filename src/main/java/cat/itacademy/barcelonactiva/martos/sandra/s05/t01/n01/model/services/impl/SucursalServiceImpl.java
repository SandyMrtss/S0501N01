package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.services.impl;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.services.SucursalService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {

    private SucursalRepository sucursalRepository;

    public SucursalServiceImpl(SucursalRepository sucursalRepository){
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public Sucursal findByName(String nom_sucursal){
        return sucursalRepository.findByNomSucursal(nom_sucursal);
    }
    @Override
    public void addSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public void updateSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public void deleteSucursal(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if(sucursal.isPresent()){
            sucursalRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Sucursal getOneSucursal(Integer id) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if(sucursal.isPresent()){
            return sucursal.get();
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<SucursalDTO> getAllSucursal() {
        List<SucursalDTO> allSucursalDTO = new ArrayList<>();
        sucursalRepository.findAll().forEach(s-> allSucursalDTO.add(sucursalToDTO(s)));
        return allSucursalDTO;
    }

    @Override
    public SucursalDTO sucursalToDTO(Sucursal sucursal){
        return new SucursalDTO(sucursal);
    }

}