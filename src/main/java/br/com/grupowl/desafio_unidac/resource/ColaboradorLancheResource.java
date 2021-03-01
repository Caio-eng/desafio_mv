package br.com.grupowl.desafio_unidac.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.grupowl.desafio_unidac.model.Colaborador;
import br.com.grupowl.desafio_unidac.model.ColaboradorLanche;
import br.com.grupowl.desafio_unidac.model.PedidoLanche;
import br.com.grupowl.desafio_unidac.service.ColaboradorLancheService;
import br.com.grupowl.desafio_unidac.service.ColaboradorService;
import br.com.grupowl.desafio_unidac.service.LancheService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

@Path("/colaborador-lanche")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ColaboradorLancheResource {

	
	@Inject
	ColaboradorLancheService service;
	
	
	
	

	@GET
	public Response listar() {
		List<PedidoLanche> result = service.listar();
		
		return Response.ok(result).build();
	}

	@POST
	public Response criar(ColaboradorLanche colaboradorLanche) {
		System.out.println("Criando colaborador");
		ColaboradorLanche criado;
		try {
			criado = service.criar(colaboradorLanche);
			return Response.status(Status.CREATED).entity(criado).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	
		
	}

//	@PUT
//	public Response atualizar(Colaborador colaborador) {
//		Colaborador atualizado = service.atualizar(colaborador);
//
//		return Response.status(Status.OK).entity(atualizado).build();
//	}
//
//	@DELETE
//	@Path("{id}")
//	public Response delete( @PathParam("id") Long id) {
//		Colaborador deletar = service.deletar(id);
//
//		return Response.status(Status.OK).entity(deletar).build();
//	}
//	
//	@GET
//	@Path("{id}")
//	public Response buscar( @PathParam("id") Long id) {
//		Colaborador buscar = service.buscar(id);
//		if (buscar != null) {
//			return Response.status(Status.OK).entity(buscar).build();
//		}
//		else {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//	}
//
//	@GET
//	@Path("popular/banco")
//	public Response aux() {
//		List<Colaborador> result = new ArrayList();
//		// result.add(service.createColaborador("Poliene de Sena Tomaz",
//		// "04685211600"));
//		// result.add(service.createColaborador("Sarah hosana pereira amaral",
//		// "10777438666"));
//		// result.add(service.createColaborador("Sandra goncalves lara ",
//		// "12104512638"));
//
//		// result.add(service.createColaborador("Maria Beatriz da Cunha Fernandes",
//		// "03473167606"));
//		// result.add(service.createColaborador("Gisele Corbelino Rocha",
//		// "02819282660"));
//		// result.add(service.createColaborador("Rodrigo Menezes de Almeida ",
//		// "54411530678"));
//
//		return Response.ok(result).build();
//	}

}
