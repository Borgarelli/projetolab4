package br.gov.sp.fatec.projetolab4.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.projetolab4.entity.Usuario;
import br.gov.sp.fatec.projetolab4.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioControler {
    
    @Autowired
    private SegurancaService sService;

    @GetMapping
    public List<Usuario> litar(){
        return sService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario encontar(@PathVariable Long id){
        return sService.acharUsuario(id);
    }

}
