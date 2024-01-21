package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.model.services.SucursalService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@CrossOrigin(origins = "http://localhost:9000")
@Controller
@RequestMapping("/sucursal/v1")
public class SucursalController {

    private SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService){
        this.sucursalService = sucursalService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listSucursals", sucursalService.getAllSucursal());
        return "index";
    }

    @GetMapping("")
    public String redirectHomePage(){
        return "redirect:/sucursal/v1/";
    }

    @GetMapping("/getAll")
    public String redirectAll(){
        return "redirect:/sucursal/v1/";
    }
    @GetMapping("/add")
    public String showNewSucursalForm(Model model){
        model.addAttribute("sucursal",  new Sucursal());
        return "new_sucursal";
    }

    @PostMapping("/add")
    public String saveSucursal(@ModelAttribute("sucursal") @Valid Sucursal sucursal, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        Sucursal existing = sucursalService.findByName(sucursal.getNomSucursal());
        if(existing != null){
            bindingResult.reject("nom.duplicated", "Ja existeix una sucursal amb aquest nom");
        }
        if(bindingResult.hasErrors()){
            return "new_sucursal";
        }
        sucursalService.addSucursal(sucursal);
        redirectAttributes.addFlashAttribute("success", "Sucursal afegida correctament");
        return "redirect:/sucursal/v1/add";
    }
    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model){
        Sucursal original = sucursalService.getOneSucursal(id);
        model.addAttribute("sucursal", original);
        return "update_sucursal";
    }
    @PostMapping("/update/{id}")
    public String updateSucursal(@PathVariable(value = "id") Integer id, @ModelAttribute("sucursal") @Valid Sucursal sucursal, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "update_sucursal";
        }
        sucursalService.updateSucursal(sucursal);
        redirectAttributes.addFlashAttribute("success", "Sucursal actualitzada correctament");
        return "redirect:/sucursal/v1/update/{id}";
    }
    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable(value = "id") Integer id, RedirectAttributes redirectAttributes){
        sucursalService.deleteSucursal(id);
        redirectAttributes.addFlashAttribute("deleted", "Sucursal eliminida");
        return "redirect:/sucursal/v1/";
    }
    @GetMapping("/getOne/{id}")
    public String getOneSucursal(@PathVariable(value = "id") Integer id, Model model) {
        Sucursal sucursal = sucursalService.getOneSucursal(id);
        SucursalDTO sucursalDTO = sucursalService.sucursalToDTO(sucursal);
        model.addAttribute("sucursalDTO", sucursalDTO);
        return "show_sucursal";
    }
    @GetMapping("/error")
    public String showErrorPage(){
        return "error";
    }
}