package com.training.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("quick")
public class QuickStart {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		return "You get Configured JERSEY Property-Harshit";
	}
}
