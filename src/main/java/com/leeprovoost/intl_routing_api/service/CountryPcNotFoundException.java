package com.leeprovoost.intl_routing_api.service;

public class CountryPcNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CountryPcNotFoundException(String id) {
        super(String.format("Cannot find country postcode with id %s", id));
    }
}
