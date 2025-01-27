package com.mkj.app.entity;

import java.util.List;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetails {

	private long phoneNumber;
	private String email;
	private String fullAddress;
}
