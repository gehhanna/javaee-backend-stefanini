package com.stefanini.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.entity.UsuarioEntity;

public class UsuarioDTO {

    private Long idUsuario;
    
    @Size(max = 50)
    @NotEmpty(message = "nome não pode ser nulo")
    private String nome;

    @NotEmpty(message = "login não pode ser nulo")
    @Size(min = 5, max = 20)
    private String login;

    @NotEmpty(message = "email não pode ser nulo")
    @Email
    @Size(min = 10)
    private String email;

    @NotEmpty(message = "senha não pode ser nulo")
    @Size(min = 4, max = 10)
    private String senha;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeNascimento;

    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    private LocalDateTime dataDeCriacao;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    private LocalDateTime dataDeAtualizacao;

    // Construtores.
    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.idUsuario = usuarioEntity.getIdUsuario();
        this.nome = usuarioEntity.getNome();
        this.login = usuarioEntity.getLogin();
        this.senha = usuarioEntity.getSenha();
        this.email = usuarioEntity.getEmail();
        this.dataDeNascimento = usuarioEntity.getDataDeNascimento();
        this.dataDeCriacao = usuarioEntity.getDataDeCriacao();
        this.dataDeAtualizacao = usuarioEntity.getDataDeAtualizacao();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public LocalDateTime getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(LocalDateTime dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

}