package com.leeprovoost.intl_routing_api.service;

import java.util.List;

import com.leeprovoost.intl_routing_api.core.Country;
import com.leeprovoost.intl_routing_api.core.ESD;
import com.leeprovoost.intl_routing_api.repository.IntlRoutingRepository;

public class IntlRoutingService {

    private final IntlRoutingRepository intlRoutingRepository;
	
    public IntlRoutingService(IntlRoutingRepository intlRoutingRepository) {
        this.intlRoutingRepository = intlRoutingRepository;
    }

    public List<Country> getCountryList() {
    	return intlRoutingRepository.getCountryList();
    }
    public List<ESD> getCitiesList(int limit) {
    	return intlRoutingRepository.getESDList(limit);
    }
    public List<ESD> getCitiesListByCountryCode(String countryCode, int limit) {
        return intlRoutingRepository.getESDListByCountryCode(countryCode, limit);    	
    }
    public List<ESD> getCitiesListByPostcode(String countryCode, String partialPostcode, int limit) {
        return intlRoutingRepository.getESDListByPostcode(countryCode, partialPostcode, limit);
    }
    public List<ESD> getCitiesListByCityName(String countryCode, String partialCityName, int limit) {
        return intlRoutingRepository.getESDListByCityName(countryCode, partialCityName, limit);
    }
    public List<ESD> getCitiesListByCityNameAndPostCode(String countryCode, String partialCityName, String partialPostcode, int limit) {
        return intlRoutingRepository.getESDListByCityNameAndPostCode(countryCode, partialCityName, partialPostcode, limit);  	
    }
    
}
