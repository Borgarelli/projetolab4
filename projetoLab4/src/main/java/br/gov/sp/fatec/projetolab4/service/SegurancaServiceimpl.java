package br.gov.sp.fatec.projetolab4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projetolab4.entity.Usuario;
import br.gov.sp.fatec.projetolab4.repository.UsuarioRepository;

@Service
public class SegurancaServiceimpl implements SegurancaService{

    @Autowired
    private UsuarioRepository uRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        if(usuario.getNome() == null || usuario.getNome().trim().isEmpty() || usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()){
            throw new IllegalArgumentException("Nome ou senha em branco");
        }else{
            return uRepository.save(usuario);
        }
    }

    @Override
    public Usuario criarUsuario(String nome, String senha) {
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setSenha(senha);
        return criarUsuario(u);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return uRepository.findAll();
    }

    @Override
    public Usuario acharUsuario(Long id) {
        Optional<Usuario> usuop = uRepository.findById(id);
        if(usuop.isEmpty()){
            throw new IllegalArgumentException("Id inválido");
        }else{
            return usuop.get();
        }
    }
    


}
