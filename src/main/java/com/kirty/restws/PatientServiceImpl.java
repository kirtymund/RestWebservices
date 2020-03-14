package com.kirty.restws;
import java.util.*;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.kirty.restws.model.Patients;

@Service
public class PatientServiceImpl implements PatientService {
 
	Map<Long, Patients> patients = new HashMap<Long, Patients>();
	long currentid = 123;
	public PatientServiceImpl() {
		init();
	}
	
	void init() {
		Patients patient = new Patients();
		patient.setID(currentid);
		patient.setName("John");
		patients.put(patient.getID(), patient);
	}


	public List<Patients> getallpatients() {
		Collection<Patients> result = patients.values();
		List<Patients> response = new ArrayList<Patients>(result);
		return response;
	}

	
	public Patients getpatient(long id) {
		Patients response = patients.get(id);
		return response;
	}


	public Response createPatient(Patients patient) {
		patient.setID(++currentid);
		patients.put(patient.getID(),patient);
		return Response.ok(patient).build();
	}


	public Response updatePatient(Patients patient) {
		Response response;
		Patients currentPatient = patients.get(patient.getID());
		if(currentPatient != null) {
			patients.put(patient.getID(), patient);
			response = Response.ok().build();
		}
		else {
			response = Response.notModified().build();
		}
		return response;
	}


	public Response deletePatient(long id) {
		Response response;
		if(patients.containsKey(id)) {
			Patients value = patients.remove(id);
			response = Response.ok("value").build();
		}
		else {
			response = Response.notModified().build();
		}
		return response;
	}
	
}
