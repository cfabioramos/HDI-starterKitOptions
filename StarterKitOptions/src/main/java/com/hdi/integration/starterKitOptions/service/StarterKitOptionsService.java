package com.hdi.integration.starterKitOptions.service;

import com.hdi.integration.starterKitOptions.dto.Document;
import com.hdi.integration.starterKitOptions.repository.StarterKitOptionsRepository;
import com.hdi.integration.starterKitOptions.util.ObjectConverter;
import com.progress.open4gl.Open4GLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StarterKitOptionsService {
	
	@Autowired
	private StarterKitOptionsRepository repository;

	public void getStarterKitOptions(String idInsurancePolicy) throws Open4GLException, IOException {
		repository.getStarterKitOptions(ObjectConverter.getJsonFromObject(new Document(idInsurancePolicy)));
	}

}
