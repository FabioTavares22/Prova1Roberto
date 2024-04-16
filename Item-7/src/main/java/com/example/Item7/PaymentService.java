package com.example.Item7;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
	
	private PaymentEntity repo;

	@Autowired
	private PaymentConverter converter;

	@Autowired
	public PaymentService(PaymentRepositorio repo) {
		this.repo = (PaymentEntity) repo;
	}

	public List<PaymentDTO> findAll() {
		return repo.findAll().stream().map(PaymentConverter::toDTO)
				.collect(Collectors.toList());
	}

	public PaymentEntity findById(Integer productCode) {
		Optional<PaymentEntity> obj = repo.findById(productCode);
		PaymentEntity entity = obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: " + productCode, productCode));
		return entity;
	}

	public List<PaymentDTO> findByActive(boolean b) {
		return repo.findByActive(true).stream().map(PaymentConverter::toDTO).collect(Collectors.toList());
	}

	public void createProduct(PaymentDTO product) {
		repo.save(converter.toEntity(product));
	}

	public void updateProduct(PaymentDTO product, Integer code) {
		if (code == null || product == null || !code.equals(product.getCode())) {
			throw new PaymentException("Invalid product code.");
		}
		PaymentEntity existingObj = findById(code);
		updateData(existingObj, product);
		repo.save(existingObj);
	}

	private void updateData(PaymentEntity existingObj, PaymentDTO newObj) {
		existingObj.setproductCode(newObj.getValue());
	}

	public void deleteProduct(Integer code) throws PaymentException {
		if (code == null) {
			throw new PaymentException("Product code can not be null.");
		}
		PaymentEntity obj = findById(code);
		try {
			repo.delete(obj);
		} catch (DataIntegrityViolationException e) {
			throw new PaymentException("Can not delete a Product with dependencies constraints.");
		}
	}

}
