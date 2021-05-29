package br.com.fiap.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioEndPoint {
	private UsuarioDao dao = new UsuarioDao();

	@GET
	public List<Usuario> index() {
		return dao.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Usuario usuario) {
		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			dao.save(usuario);
			return Response.status(Response.Status.CREATED).entity(usuario).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		Usuario usuario = dao.findById(id);
		if (usuario == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(usuario).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Usuario usuario) {		
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if (dao.findById(id) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		usuario.setCodigo(id.intValue());
		try {
			dao.update(usuario);
			return Response.status(Response.Status.OK).entity(usuario).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id, Usuario usuario) {
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if (dao.findById(id) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		usuario.setCodigo(id.intValue());
		try {
			dao.delete(usuario);
			return Response.status(Response.Status.OK).entity(usuario).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
