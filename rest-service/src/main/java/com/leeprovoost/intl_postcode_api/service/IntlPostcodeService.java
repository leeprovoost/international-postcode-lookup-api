package com.leeprovoost.intl_postcode_api.service;

import java.util.List;

import com.leeprovoost.intl_postcode_api.core.Country;
import com.leeprovoost.intl_postcode_api.core.CountryPostcode;
import com.leeprovoost.intl_postcode_api.core.ESD;
import com.leeprovoost.intl_postcode_api.db.IntlPostcodeDao;

public class IntlPostcodeService {

    private final IntlPostcodeDao intlPostcodeRepository;
	
    public IntlPostcodeService(IntlPostcodeDao intlPostcodeRepository) {
        this.intlPostcodeRepository = intlPostcodeRepository;
    }

    public List<Country> getCountryList() {
    	return intlPostcodeRepository.getCountryList();
    }
    public List<CountryPostcode> getCountryPostcodeList() {
    	return intlPostcodeRepository.getCountryPostcodeList();
    }
    public List<ESD> getCitiesList(int limit) {
    	return intlPostcodeRepository.getESDList(limit);
    }
    public List<ESD> getCitiesListByCountryCode(String countryCode, int limit) {
        return intlPostcodeRepository.getESDListByCountryCode(countryCode, limit);    	
    }
    public List<ESD> getCitiesListByPostcode(String countryCode, String partialPostcode, int limit) {
        return intlPostcodeRepository.getESDListByPostcode(countryCode, partialPostcode, limit);
    }
    public List<ESD> getCitiesListByCityName(String countryCode, String partialCityName, int limit) {
        return intlPostcodeRepository.getESDListByCityName(countryCode, partialCityName, limit);
    }
    public List<ESD> getCitiesListByCityNameAndPostCode(String countryCode, String partialCityName, String partialPostcode, int limit) {
        return intlPostcodeRepository.getESDListByCityNameAndPostCode(countryCode, partialCityName, partialPostcode, limit);  	
    }
    
}
