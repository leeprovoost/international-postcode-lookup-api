package com.leeprovoost.intl_postcode_api.service;

public class CitiesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CitiesNotFoundException() {
        super(String.format("Cannot find any cities"));
    }
}
