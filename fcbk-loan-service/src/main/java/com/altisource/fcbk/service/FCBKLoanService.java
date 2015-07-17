package com.altisource.fcbk.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.altisource.fcbk.domain.Loan;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/")
public interface FCBKLoanService {

	@GET
	@Path("/getLoanDetails/{loanId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiParam(name = "Method to get loan details for given loan Id")
	public Loan getLoanDetails(
			@ApiParam(value = "loanId", required = true) @PathParam("loanId") String loanId);


	@GET
	@Path("/getFullLoanDetails/{loanId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiParam(name = "Method to all the fields in json format for given loan Id")
	public Loan getFullLoanDetails(
			@ApiParam(value = "loanId", required = true) @PathParam("loanId") String loanId);

}