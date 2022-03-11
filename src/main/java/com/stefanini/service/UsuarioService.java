package com.stefanini.service;

import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    public UsuarioDTO pegaUsuarioPorID(Long idUsuario) {
        return usuarioRepository.pegarUsuarioPorID(idUsuario);
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        if (Objects.nonNull(usuarioDTO.getIdUsuario())) {
            throw new RuntimeException("Erro ao cadastrar usuario informe o ID");
        }
        return usuarioRepository.criarUsuario(usuarioDTO);
    }

    public UsuarioDTO alterUsuario(UsuarioDTO usuarioDTO) {
        if (!Objects.nonNull(usuarioDTO.getIdUsuario())) {
            throw new RuntimeException("Ao alterar mande um ID");
        }

        if (!usuarioDTO.getSenha().isEmpty()) {
            // Criptografando a senha caso for nova.
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);
        }

        return usuarioRepository.alterarUsuario(usuarioDTO);

    }

    public void excluirUsuario(Long idUsuario) {
        usuarioRepository.excluirUsuario(idUsuario);
    }

    //Outros endPoints.

    public List<UsuarioDTO> listarAniversariantesDoMes(){
        return usuarioRepository.listarAniversariantesDoMes();

    }

    public List<UsuarioDTO> listarInicialDoNome(String inicial){
        return usuarioRepository.listarInicialNome(inicial);
    }   
}
