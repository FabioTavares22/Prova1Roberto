package com.example.Item7;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentDTO {

	private Integer productCode;
	private Integer paymentDate;
	private Integer dueDate;
	private float value;
	private String paymentType;
	//@JsonIgnore
	private boolean active;
}
