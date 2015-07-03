package com.altisource.eim.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.altisource.eim.domain.Response;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/")
@WebService(name = "EIMDataService", targetNamespace = "ws.altisource.com/EIM/EIMDataService")
public interface EIMDataService {

	@POST
	@Path("/getForeClosureLoanDetails/{loanId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@WebResult(name = "response")
	public Response getForeClosureLoanDetails(
			@WebParam(name = "loanId") @ApiParam(value = "loanId", required = true) String loanId);

	@GET
	@Path("/getSingleLoanDetails/{loanId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@WebResult(name = "loanClosureDetails")
	public Response getSingleLoanDetails(
			@WebParam(name = "loanId") @PathParam("loanId") String loanId);

	@POST
	@Path("/getMultipleLoanDetails/{loanIds}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@WebResult(name = "response")
	public Response getMultipleLoanDetails(
			@WebParam(name = "loanIds") @ApiParam(value = "loanIds", required = true) List<String> loanIds);
}
