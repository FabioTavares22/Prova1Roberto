package com.example.Item7;

import org.springframework.stereotype.Component;

import com.example.Item7.PaymentDTO;
import com.example.Item7.PaymentEntity;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class PaymentConverter {
	
	public static PaymentDTO toDTO(PaymentEntity payment) {
		return new PaymentDTO(
				payment.getName(), payment.getName(),
				payment.getPrice(), payment.isActive());
	}
	
	public PaymentEntity toEntity(PaymentDTO pay) {
		System.out.println("toEntity: " + pay);
		return new PaymentEntity(pay.getProductCode(), pay.getPaymentType(),
				pay.getDueDate(), pay.getPaymentDate(), pay.getValue(), pay.isActive());
	}

}


