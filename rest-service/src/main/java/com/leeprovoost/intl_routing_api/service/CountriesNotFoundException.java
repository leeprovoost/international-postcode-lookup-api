package com.leeprovoost.intl_routing_api.service;

public class CountriesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CountriesNotFoundException() {
        super(String.format("Cannot find any countries"));
    }
}
