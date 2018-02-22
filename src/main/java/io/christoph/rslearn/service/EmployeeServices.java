package io.christoph.rslearn.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.christoph.rslearn.model.Employee;

@Path("/employee")
public class EmployeeServices {
	
	//only hardcode add list employee
	private static List<Employee> list = new ArrayList<>();
	static {
		list.add(new Employee(101, "Christian", "Valdez", 27));
		list.add(new Employee(102, "Stephanie", "Calderon", 26));
		list.add(new Employee(103, "Kathe", "Ascencio", 29));
	}
	
	@GET
	@Path("/bylist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getByListEmployee(){
		return list;
	}
	
	@GET
	@Path("/listallow")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeList()
	{
		return Response
					.status(200)
					.header("Access-Control-Allow-Origin", "*")
		            //.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
		            //.header("Access-Control-Allow-Credentials", "true")
		            //.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
		            //.header("Access-Control-Max-Age", "1209600")
					.entity(list)
					.build();
	}

}
