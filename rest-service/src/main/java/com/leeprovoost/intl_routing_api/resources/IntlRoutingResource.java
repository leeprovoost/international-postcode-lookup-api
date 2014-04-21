package com.leeprovoost.intl_routing_api.resources;

import java.util.List;

import com.leeprovoost.intl_routing_api.core.Country;
import com.leeprovoost.intl_routing_api.core.ESD;
import com.leeprovoost.intl_routing_api.service.CitiesNotFoundException;
import com.leeprovoost.intl_routing_api.service.CountriesNotFoundException;
import com.leeprovoost.intl_routing_api.service.IntlRoutingService;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/intl-routing-api")
@Api(value = "/intl-routing-api", description = "DHL International Routing API")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IntlRoutingResource {

    private IntlRoutingService intlRoutingService;

    public IntlRoutingResource(IntlRoutingService intlRoutingService) {
        this.intlRoutingService = intlRoutingService;
    }

    @GET
    @Path("/countries/")
    @ApiOperation(
    		value = "Get a list of countries",
    		notes = "<p><strong>Service Name</strong>: getCountries (internal)</p>", 
            response = Country.class)
    @ApiResponses(value = {
    		  @ApiResponse(code = 200, message = "List of countries"),
    		  @ApiResponse(code = 404, message = "No countries found") 
    		})
    public Response getCountry() {	 	
        try {
            List<Country> countryList = intlRoutingService.getCountryList();
            return Response.ok(countryList).build();
        } catch (CountriesNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("/cities/")
    @ApiOperation(
    		value = "Get a list of cities for a given country, (partial) postcode and/or (partial) city name",
    		notes = "<p><strong>Service Name</strong>: getCities (internal)</p>", 
            response = ESD.class)
    @ApiResponses(value = {
    		  @ApiResponse(code = 200, message = "List of cities"),
    		  @ApiResponse(code = 404, message = "No cities found") 
    		})
    public Response getESDListByPostcode(
    		@ApiParam(value = "Country Code (optional)", required = false, allowMultiple = false) @QueryParam("country") String countryCode,
    		@ApiParam(value = "Postcode, can be partial. e.g. SW will give you SW1, SW2, etc. (optional)", required = false, allowMultiple = false) @QueryParam("postcode") String partialPostcode,
    		@ApiParam(value = "City Name (optional)", required = false, allowMultiple = false) @QueryParam("city") String partialCityName,
    		@ApiParam(value = "Limit results (optional)", required = false, allowMultiple = false) @QueryParam("limit") Integer limitResults) {	 	
        try {
        	List<ESD> esdList;
        	int limit = 25;
        	if (limitResults != null) {
        		limit = limitResults;
        	}
        	if (countryCode != null) {
        		// Country code + Post code
        		if (partialPostcode != null && partialCityName == null) {
        			esdList = intlRoutingService.getCitiesListByPostcode(countryCode, partialPostcode, limit);
        		// Country code + City name
        		} else if (partialPostcode == null && partialCityName != null){
        			esdList = intlRoutingService.getCitiesListByCityName(countryCode, partialCityName, limit);
        		// Country code + City name + Post code
        		} else if (partialPostcode != null && partialCityName != null) {
        			esdList = intlRoutingService.getCitiesListByCityNameAndPostCode(countryCode, partialCityName, partialPostcode, limit);
        		// Country code
        		} else {
        			esdList = intlRoutingService.getCitiesListByCountryCode(countryCode, limit);
        		}
        	} else {
        		esdList = intlRoutingService.getCitiesList(limit);
        	}
            return Response.ok(esdList).build();
        } catch (CitiesNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
