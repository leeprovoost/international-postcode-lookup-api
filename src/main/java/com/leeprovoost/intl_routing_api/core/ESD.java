package com.leeprovoost.intl_routing_api.core;

import javax.xml.bind.annotation.XmlRootElement;

import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "ESD")
/**
 * ESDv6
 * @author leeprovoost
 */
public class ESD {

	private String _id;
	private String countryCode;
	private String countryDivisionCode;
	private String countryDivisionName;
	private String serviceAreaCode;
	private String cityName;
	private String suburbName;
	private String postcodeFrom;
	private String postcodeTo;
	private String postalLocationType;
	private String distanceFromFacility;
	private String facilityIdentifier;
	private String facilityTypeCode;
	private String facilityNetworkTypeCode;
	
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
	public String getCountryDivisionCode() {
		return countryDivisionCode;
	}
	@JsonProperty("b")
	public void setCountryDivisionCode(String countryDivisionCode) {
		this.countryDivisionCode = countryDivisionCode;
	}
	@JsonProperty("c")
	public String getCountryDivisionName() {
		return countryDivisionName;
	}
	@JsonProperty("c")
	public void setCountryDivisionName(String countryDivisionName) {
		this.countryDivisionName = countryDivisionName;
	}
	@JsonProperty("d")
	public String getServiceAreaCode() {
		return serviceAreaCode;
	}
	@JsonProperty("d")
	public void setServiceAreaCode(String serviceAreaCode) {
		this.serviceAreaCode = serviceAreaCode;
	}
	@JsonProperty("e")
	public String getCityName() {
		return cityName;
	}
	@JsonProperty("e")
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@JsonProperty("f")
	public String getSuburbName() {
		return suburbName;
	}
	@JsonProperty("f")
	public void setSuburbName(String suburbName) {
		this.suburbName = suburbName;
	}
	@JsonProperty("g")
	public String getPostcodeFrom() {
		return postcodeFrom;
	}
	@JsonProperty("g")
	public void setPostcodeFrom(String postcodeFrom) {
		this.postcodeFrom = postcodeFrom;
	}
	@JsonProperty("h")
	public String getPostcodeTo() {
		return postcodeTo;
	}
	@JsonProperty("h")
	public void setPostcodeTo(String postcodeTo) {
		this.postcodeTo = postcodeTo;
	}
	@JsonProperty("i")
	public String getPostalLocationType() {
		return postalLocationType;
	}
	@JsonProperty("i")
	public void setPostalLocationType(String postalLocationType) {
		this.postalLocationType = postalLocationType;
	}
	@JsonProperty("j")
	public String getDistanceFromFacility() {
		return distanceFromFacility;
	}
	@JsonProperty("j")
	public void setDistanceFromFacility(String distanceFromFacility) {
		this.distanceFromFacility = distanceFromFacility;
	}
	@JsonProperty("k")
	public String getFacilityIdentifier() {
		return facilityIdentifier;
	}
	@JsonProperty("k")
	public void setFacilityIdentifier(String facilityIdentifier) {
		this.facilityIdentifier = facilityIdentifier;
	}
	@JsonProperty("l")
	public String getFacilityTypeCode() {
		return facilityTypeCode;
	}
	@JsonProperty("l")
	public void setFacilityTypeCode(String facilityTypeCode) {
		this.facilityTypeCode = facilityTypeCode;
	}
	@JsonProperty("m")
	public String getFacilityNetworkTypeCode() {
		return facilityNetworkTypeCode;
	}
	@JsonProperty("m")
	public void setFacilityNetworkTypeCode(String facilityNetworkTypeCode) {
		this.facilityNetworkTypeCode = facilityNetworkTypeCode;
	}
	
}
