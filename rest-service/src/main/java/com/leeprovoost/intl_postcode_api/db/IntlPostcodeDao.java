package com.leeprovoost.intl_postcode_api.db;

import java.util.List;
import java.util.regex.Pattern;

import com.leeprovoost.intl_postcode_api.core.Country;
import com.leeprovoost.intl_postcode_api.core.CountryPostcode;
import com.leeprovoost.intl_postcode_api.core.ESD;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

import org.mongojack.JacksonDBCollection;

public class IntlPostcodeDao {

	public static final String COLLECTION_NAME_ESD = "intl_postcode_api_ESD";
	public static final String COLLECTION_NAME_country = "intl_postcode_api_country";
	public static final String COLLECTION_NAME_countrypc = "intl_postcode_api_countrypc";
	
    private JacksonDBCollection<ESD, String> ESDCollection;
    private JacksonDBCollection<Country, String> countryCollection;
    private JacksonDBCollection<CountryPostcode, String> countryPostcodeCollection;

    public IntlPostcodeDao(DB mongoDB) {
        final DBCollection dbESD = mongoDB.getCollection(COLLECTION_NAME_ESD);
        dbESD.ensureIndex(new BasicDBObject("a", 1));
        final DBCollection dbCountry = mongoDB.getCollection(COLLECTION_NAME_country);
        final DBCollection dbCountryPc = mongoDB.getCollection(COLLECTION_NAME_countrypc);
        this.ESDCollection = JacksonDBCollection.wrap(dbESD, ESD.class, String.class);
        this.countryCollection = JacksonDBCollection.wrap(dbCountry, Country.class, String.class);
        this.countryPostcodeCollection = JacksonDBCollection.wrap(dbCountryPc, CountryPostcode.class, String.class);
    }

    public void drop() {
    	ESDCollection.drop();
    	countryCollection.drop();
    	countryPostcodeCollection.drop();
    }

    /**
     * Get list of all countries
     * @return List<Country>
     */
    public List<Country> getCountryList() {
    	return countryCollection.find().toArray();
    }
    
    /**
     * Get list of all country postcode formatting rules
     * @return List<CountryPostcode>
     */
    public List<CountryPostcode> getCountryPostcodeList() {
    	return countryPostcodeCollection.find().toArray();
    }
    
    /**
     * Get list of ESD objects. Be mindful of adding a document limit, e.g. 25, to avoid that you are bringing the database down.
     * @param limit
     * @return List<ESD>
     */
    public List<ESD> getESDList(int limit) {
    	
    	return ESDCollection.find().limit(limit).toArray();
    }
    /**
     * Get list of ESD objects for a given country code (e.g. GB, BE).
     * @param countryCode
     * @param limit
     * @return List<ESD>
     */
    public List<ESD> getESDListByCountryCode(String countryCode, int limit) {
    	
    	DBObject query = QueryBuilder.start("a").in(new String[] {countryCode.toUpperCase()}).get();
    	return ESDCollection.find(query).limit(limit).toArray();
    }
    /**
     * Get list of ESD objects for a given country code and (partial) post code.
     * @param countryCode
     * @param partialPostcode
     * @param limit
     * @return List<ESD>
     * 
     * TODO Implement post code ranges
     */
    public List<ESD> getESDListByPostcode(String countryCode, String partialPostcode, int limit) {
    	
    	Pattern pattern = Pattern.compile("^" + partialPostcode.toUpperCase());
    	DBObject query = QueryBuilder.start().and(
					QueryBuilder.start("a").in(new String[] {countryCode.toUpperCase()}).get(),
					QueryBuilder.start("d").regex(pattern).get()
				).get();

    	return ESDCollection.find(query).limit(limit).toArray();
    }
    /**
     * Get list of ESD objects for a given country code and (partial) city name.
     * @param countryCode
     * @param partialCityName
     * @param limit
     * @return List<ESD>
     */
    public List<ESD> getESDListByCityName(String countryCode, String partialCityName, int limit) {
    	    	
    	Pattern pattern = Pattern.compile("^" + partialCityName.toUpperCase());
    	DBObject query = QueryBuilder.start().and(
    						QueryBuilder.start("a").in(new String[] {countryCode.toUpperCase()}).get(),
    						QueryBuilder.start("b").regex(pattern).get()
    					).get();
    	return ESDCollection.find(query).limit(limit).toArray();
    }
    /**
     * Get list of ESD objects for a given country code, (partial) city name and (partial) post code.
     * @param countryCode
     * @param partialCityName
     * @param partialPostCode
     * @param limit
     * @return List<ESD>
     * 
     * TODO Implement post code as integers and post code ranges
     */
    public List<ESD> getESDListByCityNameAndPostCode(String countryCode, String partialCityName, String partialPostCode, int limit) {
    	
    	Pattern cityPattern = Pattern.compile("^" + partialCityName.toUpperCase());
    	Pattern postcodePattern = Pattern.compile("^" + partialPostCode.toUpperCase());
    	DBObject query = QueryBuilder.start().and(
    						QueryBuilder.start("a").in(new String[] {countryCode.toUpperCase()}).get(),
    						QueryBuilder.start("b").regex(cityPattern).get(),
    						QueryBuilder.start("d").regex(postcodePattern).get()
    					).get();
    	return ESDCollection.find(query).limit(limit).toArray();
    }
    
}
