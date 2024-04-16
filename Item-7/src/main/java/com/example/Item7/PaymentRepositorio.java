package com.example.Item7;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Item7.PaymentEntity;

@Repository
public interface PaymentRepositorio extends JpaRepository<PaymentEntity, Integer> {
	
	public List<PaymentEntity> findByActive(Boolean active);

}
