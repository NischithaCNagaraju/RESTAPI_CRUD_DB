package com.cmdb.democmdb;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inventory")
public class InventoryResource {
	private InventoryDAO dao = InventoryDAO.getInstance(); 
	
	@POST
	@Path("/post")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void addInventory(Inventory inv) throws SQLException
	{
		dao.add(inv);
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.TEXT_PLAIN)
	public void deleteInvenory(String hostname)
	{
		dao.delete(hostname);
	}
	
	@GET
	@Path("/read")
	@Produces(MediaType.APPLICATION_XML)
	public Response list() {
		
		final GenericEntity<List<Inventory>> entity
        = new GenericEntity<List<Inventory>>(dao.listAll()) {};
        return Response.ok(entity).build();
	}
}
