package com.stefanini.resources;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.service.UsuarioService;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;
    // CRUD.

    @GET
    public Response listarUsuarios() {
        List<UsuarioDTO> listarUsuarios = usuarioService.listarUsuarios();
        return Response.status(Response.Status.OK).entity(listarUsuarios).build();
    }

    @GET
    @Path("/{idUsuario}")
    public Response pegarUsuarioPorID(@PathParam("idUsuario") Long idUsuario) {
        // UsuarioDTO usuarioDTO = usuarioService.pegaUsuarioPorID(idUsuario);
        return Response.status(Response.Status.OK).entity(usuarioService.pegaUsuarioPorID(idUsuario)).build();
    }

    @POST
    public Response criarUsuario(UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.CREATED).entity(usuarioService.criarUsuario(usuarioDTO)).build();

    }

    @PUT
    public Response alterarUsuario(@Valid UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.OK).entity(usuarioService.alterUsuario(usuarioDTO)).build();
    }

    @DELETE
    @Path("/{idUsuario}")
    public Response excluirUsuario(@PathParam("idUsuario") Long idUsuario){
        usuarioService.excluirUsuario(idUsuario);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("/aniversariantes")
    public Response pegarMes(){
        return Response.status(Response.Status.OK).entity(usuarioService.listarAniversariantesDoMes()).build();

    }

    @GET
    @Path ("/inicial/{inicial}")
    public Response listarInicialDoNome(@PathParam("inicial") String inicial){
        return Response.status(Response.Status.OK).entity(usuarioService.listarInicialDoNome(inicial)).build();
    }
}
