package br.com.grupowl.desafio_unidac.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
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
import javax.ws.rs.core.Response.Status;

import br.com.grupowl.desafio_unidac.model.Colaborador;
import br.com.grupowl.desafio_unidac.model.Lanche;
import br.com.grupowl.desafio_unidac.service.LancheService;

@Path("/lanche")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LancheResource {

	@Inject
	LancheService service;

	@GET
	public Response listar() {
		List<Lanche> result = service.listar();
		return Response.ok(result).build();
	}
	
	@POST
	public Response criar(Lanche lanche) {
		System.out.println("Criando lanche");
		Lanche criado = service.criar(lanche);
		

		return Response.status(Status.CREATED).entity(criado).build();
	}
	
	@PUT
	public Response atualizar(Lanche lanche) {
		Lanche atualizado = service.atualizar(lanche);

		return Response.status(Status.OK).entity(atualizado).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete( @PathParam("id") Long id) {
		Lanche deletar = service.deletar(id);

		return Response.status(Status.OK).entity(deletar).build();
	}
	
	@GET
	@Path("{id}")
	public Response buscar( @PathParam("id") Long id) {
		Lanche buscar = service.buscar(id);
		if (buscar != null) {
			return Response.status(Status.OK).entity(buscar).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Path("popular/banco")
	public Response aux() {
		List<Lanche> result = new ArrayList();
		

		return Response.ok(result).build();
	}
	
	


}
