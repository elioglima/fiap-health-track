package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserAddressModel extends Commons {
	private int userId;
	private String zipCode;
	private String address;
	private int addressNR;
	private String district;
	private String city;
	private String state;
	private String unit;
	private String complement;
	
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.userId = result.getInt("user_id");
			this.address = result.getString("address");
			this.zipCode = result.getString("zip_code");
			this.addressNR = result.getInt("address_nr");
			this.complement = result.getString("complement");
			this.district = result.getString("district");
			this.city = result.getString("city");
			this.state = result.getString("state");
			this.unit = result.getString("unit");
			this.atCreate = result.getDate("at_create");
			this.atUpdate = result.getDate("at_update");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void clear() {
		this.address = " ";
		this.zipCode = " ";
		this.addressNR = 0;
		this.complement = " ";
		this.district = " ";
		this.city = " ";
		this.state = " ";
		this.unit = " ";
	}
	
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getNumber() {
		return this.addressNR;
	}

	public void setNumber(int addressNR) {
		this.addressNR = addressNR;
	}
	
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Date getAtCreate() {
		return this.atCreate;
	}
	
	public Date getAtUpdate() {
		return this.atUpdate;
	}
	
	public String getComplement() {
		return this.complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}