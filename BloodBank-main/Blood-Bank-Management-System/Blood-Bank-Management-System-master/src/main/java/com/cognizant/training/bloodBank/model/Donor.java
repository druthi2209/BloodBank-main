package com.cognizant.training.bloodBank.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name="donor")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long donor_id;
	@NotNull
	@Size(min=3, max=10)
	private String name;
	@NotNull
	@Size(min=10, max=10)
	private String contact_number;
	@NotNull
	private String address;
	@NotNull
	private String location;
	@NotNull
	private String blood_group;
	@NotNull
	private String gender;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Size(min=5, max=10)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@NotNull
	private int age;

	@ManyToOne
	@JoinColumn(name="bloodBankId", referencedColumnName="bloodBankId")
	private BloodBank bloodBank;

	@JsonIgnore
	@OneToMany(mappedBy="donor",fetch=FetchType.EAGER)
	private Set<Authority> authorities;

	public Long getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(Long donor_id) {
		this.donor_id = donor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BloodBank getBloodBank() {
		return bloodBank;
	}

	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}
	
	

}
