package com.hdi.integration.starterKitOptions.repository;

import com.hdi.integration.starterKitOptions.exception.BusinnesException;
import com.progress.open4gl.Open4GLException;
import com.progress.open4gl.javaproxy.Connection;
import com.progress.open4gl.javaproxy.OpenAppObject;
import com.progress.open4gl.javaproxy.ParamArray;
import com.progress.open4gl.javaproxy.ParamArrayMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class StarterKitOptionsRepository {

	@Value("${URI_PROGRESS}")
	private String URI_PROGRESS;
	
	private static String PROC_NAME = "msvc_lst_material_impresso.p";
	
	public void getStarterKitOptions(String jsonDocumentObject) throws Open4GLException, IOException {

		Connection progressConnection = null;

		try{
			progressConnection = new Connection(URI_PROGRESS, "", "", "");
			progressConnection.setSessionModel(1);
			OpenAppObject openAppObject = new OpenAppObject(progressConnection, "");

			ParamArray parameters = new ParamArray(1);
			parameters.addCharacter(0, jsonDocumentObject, ParamArrayMode.INPUT);
			openAppObject.runProc(PROC_NAME, parameters);

			String lSaidaDetApol = (String) parameters.getOutputParameter(1);
			// String messageError = (String) parameters.getOutputParameter(MESSAGE_ERROR.getCode());
			// boolean hasError = (boolean) parameters.getOutputParameter(HAS_ERROR.getCode());

			System.out.println(lSaidaDetApol);

	//		if(hasError) {
	//			connection.finalize();
	//			throw new BusinnesException(messageError);
	//		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new BusinnesException(e.getMessage());
		}
		finally {
			progressConnection.finalize();
		}
	}
}
