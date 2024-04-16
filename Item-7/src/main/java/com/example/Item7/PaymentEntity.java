package com.example.Item7;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Getter
@Setter
@ToString

public class PaymentEntity {
	
	public class ProductEntity implements Serializable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer productCode;
		private Integer paymentDate;
		private Integer dueDate;
		private float value;
		private String paymentType;
		private boolean active;
	}

	public Collection<PaymentDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<PaymentDTO> findByActive(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<PaymentEntity> findById(Integer productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(PaymentEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(PaymentEntity obj) {
		// TODO Auto-generated method stub
		
	}
		

}
