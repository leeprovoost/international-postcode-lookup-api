package com.leeprovoost.intl_postcode_api.core;

import javax.xml.bind.annotation.XmlRootElement;

import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "City")
/**
 * ESDv6
 * @author leeprovoost
 */
public class ESD {

	private String _id;
	private String countryCode;
	private String cityName;
	private String suburbName;
	private String postcode;
	
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
	public String getCityName() {
		return cityName;
	}
	@JsonProperty("b")
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@JsonProperty("c")
	public String getSuburbName() {
		return suburbName;
	}
	@JsonProperty("c")
	public void setSuburbName(String suburbName) {
		this.suburbName = suburbName;
	}
	@JsonProperty("d")
	public String getPostcode() {
		return postcode;
	}
	@JsonProperty("d")
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	
}
