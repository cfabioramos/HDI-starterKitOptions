package com.hdi.integration.StarterKitOptions.service;

import com.hdi.integration.insurancePolicyDetails.repository.InsurancePolicyDetailsRepository;
import com.progress.open4gl.Open4GLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InsurancePolicyDetailsService {
	
	@Autowired
	private InsurancePolicyDetailsRepository repository;

	public void getInsurancePolicyDetails(String idInsurancePolicy) throws Open4GLException, IOException {
		repository.getInsurancePolicyDetails(idInsurancePolicy);
	}
}
