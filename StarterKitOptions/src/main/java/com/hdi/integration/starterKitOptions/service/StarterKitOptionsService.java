package com.hdi.integration.starterKitOptions.service;

import com.hdi.integration.starterKitOptions.dto.PDocument;
import com.hdi.integration.starterKitOptions.dto.StarterKitOptions;
import com.hdi.integration.starterKitOptions.repository.StarterKitOptionsRepository;
import com.hdi.integration.starterKitOptions.util.ObjectConverter;
import com.progress.open4gl.Open4GLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StarterKitOptionsService {
	
	@Autowired
	private StarterKitOptionsRepository repository;

	public List<StarterKitOptions> getStarterKitOptions(Long idInsurancePolicy) throws Open4GLException, IOException {
		Map<String, Object> mapRet = repository.getStarterKitOptions(ObjectConverter.getJsonFromObject(new PDocument(idInsurancePolicy)));

		List options = (List)mapRet.get("DadosRetorno");

		if (options!=null && !options.isEmpty()) {
			List<StarterKitOptions> optionsList = new ArrayList<>();
			options.forEach(option ->
					optionsList.add(new StarterKitOptions(
							((Map)option).get("tipSolicitacao"),
							((Map)option).get("desSolicitacao"),
							((Map)option).get("flgMotivo"))));
			return optionsList;
		}
		return null;
	}

}
