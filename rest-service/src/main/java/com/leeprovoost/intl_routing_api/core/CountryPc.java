package com.leeprovoost.intl_routing_api.core;

import javax.xml.bind.annotation.XmlRootElement;

import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "CountryPc")
public class CountryPc {

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
	@JsonProperty("a")
	public String getCountryCode() {
		return countryCode;
	}
	@JsonProperty("a")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@JsonProperty("b")
	public String getPostcodeFormat() {
		return postcodeFormat;
	}
	@JsonProperty("b")
	public void setPostcodeFormat(String postcodeFormat) {
		this.postcodeFormat = postcodeFormat;
	}
	@JsonProperty("c")
	public Integer getSignificantDigits() {
		return significantDigits;
	}
	@JsonProperty("c")
	public void setSignificantDigits(Integer significantDigits) {
		this.significantDigits = significantDigits;
	}
}
