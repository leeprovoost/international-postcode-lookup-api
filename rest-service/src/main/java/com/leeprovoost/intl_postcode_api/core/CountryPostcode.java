package com.leeprovoost.intl_postcode_api.core;

import javax.xml.bind.annotation.XmlRootElement;

import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "CountryPostcode")
public class CountryPostcode {

	private String _id;
	private String countryCode;
	private String postcodeFormat;
	private Integer significantDigits;
	
	@ObjectId
	@JsonProperty("_id")
	public String getId() {
		return _id;
	}
	@ObjectId
	@JsonProperty("_id")
	public void setId(String _id) {
		this._id = _id;
	}
	@JsonProperty("cc")
	public String getCountryCode() {
		return countryCode;
	}
	@JsonProperty("cc")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@JsonProperty("pf")
	public String getPostcodeFormat() {
		return postcodeFormat;
	}
	@JsonProperty("pf")
	public void setPostcodeFormat(String postcodeFormat) {
		this.postcodeFormat = postcodeFormat;
	}
	@JsonProperty("sd")
	public Integer getSignificantDigits() {
		return significantDigits;
	}
	@JsonProperty("sd")
	public void setSignificantDigits(Integer significantDigits) {
		this.significantDigits = significantDigits;
	}
}
