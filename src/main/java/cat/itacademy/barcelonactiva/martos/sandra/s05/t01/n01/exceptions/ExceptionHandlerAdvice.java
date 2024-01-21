package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n01.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNotFoundException(EntityNotFoundException ex, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("notFoundError", "No s'ha trobat cap sucursal");
        return "redirect:/sucursal/v1/";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/sucursal/v1/error";
    }
}
