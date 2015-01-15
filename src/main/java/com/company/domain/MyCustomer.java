package com.company.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by RepCamp on 14/01/15.
 */
public class MyCustomer {

    //My ERP or CRM customer to be uploaded

    private String code; //required
    private String vat_number;
    private String fiscal_name;
    private String comercial_name; //required
    private String telephone;
    private String telephone_2;
    private String email;
    private String address;
    private String address_2;
    private String city;
    private String zip;
    private String state;
    private String country;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String description;
    private BigDecimal discount;
    private String payment_method;
    private Short status;
    private String pricelist;
    private List<String> reps;
    private String language;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVat_number() {
        return vat_number;
    }

    public void setVat_number(String vat_number) {
        this.vat_number = vat_number;
    }

    public String getFiscal_name() {
        return fiscal_name;
    }

    public void setFiscal_name(String fiscal_name) {
        this.fiscal_name = fiscal_name;
    }

    public String getComercial_name() {
        return comercial_name;
    }

    public void setComercial_name(String comercial_name) {
        this.comercial_name = comercial_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone_2() {
        return telephone_2;
    }

    public void setTelephone_2(String telephone_2) {
        this.telephone_2 = telephone_2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPricelist() {
        return pricelist;
    }

    public void setPricelist(String pricelist) {
        this.pricelist = pricelist;
    }

    public List<String> getReps() {
        return reps;
    }

    public void setReps(List<String> reps) {
        this.reps = reps;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
