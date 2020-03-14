package com.kirty.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.kirty.restws.model.Patients;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/patientservice")
public interface PatientService {
	@Path("/patients")
	@GET
	List<Patients>  getallpatients();
	
	@Path("/patients/{id}")
	@GET
	Patients getpatient(@PathParam(value = "id") long id);
	
	@Path("/patients")
	@POST
	Response createPatient(Patients patient);
	
	@Path("/patients")
	@PUT
	Response updatePatient(Patients patient);
	
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam(value="id") long id);
}
