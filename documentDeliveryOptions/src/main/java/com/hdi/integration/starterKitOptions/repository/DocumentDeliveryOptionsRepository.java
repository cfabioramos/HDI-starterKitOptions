package com.hdi.integration.starterKitOptions.repository;

import com.hdi.integration.starterKitOptions.exception.BusinnesException;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.javaproxy.Connection;
import com.progress.open4gl.javaproxy.OpenAppObject;
import com.progress.open4gl.javaproxy.ParamArray;
import com.progress.open4gl.javaproxy.ParamArrayMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Map;

@Repository
public class DocumentDeliveryOptionsRepository {

	@Value("${URI_PROGRESS}")
	private String URI_PROGRESS;
	
	private static String PROC_NAME = "msvc_lst_material_impresso.p";
	
	public Map<String, Object> findOptionsByDocument(String jsonDocumentObject) throws Open4GLException, IOException {

		Connection progressConnection = null;

		try{
			progressConnection = new Connection(URI_PROGRESS, "", "", "");
			progressConnection.setSessionModel(1);
			OpenAppObject openAppObject = new OpenAppObject(progressConnection, "");

			ParamArray parameters = new ParamArray(2);
			parameters.addLongchar(0, jsonDocumentObject, ParamArrayMode.INPUT);
			parameters.addLongchar(1, "", ParamArrayMode.OUTPUT);

			openAppObject.runProc(PROC_NAME, parameters);

			String ttDadosRetornoMatImp = (String) parameters.getOutputParameter(1);
			// String messageError = (String) parameters.getOutputParameter(MESSAGE_ERROR.getCode());
			// boolean hasError = (boolean) parameters.getOutputParameter(HAS_ERROR.getCode());

			System.out.println(ttDadosRetornoMatImp);

	//		if(hasError) {
	//			throw new BusinnesException(messageError);
	//		}

			return (new GsonJsonParser()).parseMap(ttDadosRetornoMatImp);

		}catch (Exception e) {
			e.printStackTrace();
			throw new BusinnesException(e.getMessage());
		}
		finally {
			progressConnection.finalize();
		}
	}
}
