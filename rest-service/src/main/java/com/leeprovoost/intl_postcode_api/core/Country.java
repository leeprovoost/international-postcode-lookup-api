package com.leeprovoost.intl_postcode_api.core;

import javax.xml.bind.annotation.XmlRootElement;

import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "Country")
public class Country {

	private String _id;
	private String countryCode;
	private String countryName;
	private String currencyCode;
	private Boolean usePostcodeFlag;
	
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
	@JsonProperty("cn")
	public String getCountryName() {
		return countryName;
	}
	@JsonProperty("cn")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@JsonProperty("cu")
	public String getCurrencyCode() {
		return currencyCode;
	}
	@JsonProperty("cu")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	@JsonProperty("pf")
	public Boolean getUsePostcodeFlag() {
		return usePostcodeFlag;
	}
	@JsonProperty("pf")
	public void setUsePostcodeFlag(Boolean usePostcodeFlag) {
		this.usePostcodeFlag = usePostcodeFlag;
	}

	
}
