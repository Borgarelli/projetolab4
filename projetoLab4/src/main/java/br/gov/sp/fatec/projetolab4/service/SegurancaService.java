package br.gov.sp.fatec.projetolab4.service;

import br.gov.sp.fatec.projetolab4.entity.Usuario;

import java.util.List;

public interface SegurancaService {
    
    public Usuario criarUsuario(Usuario usuario);
    public Usuario criarUsuario(String nome, String senha);
    public List<Usuario> listarUsuarios();
    public Usuario acharUsuario(Long id);

}
