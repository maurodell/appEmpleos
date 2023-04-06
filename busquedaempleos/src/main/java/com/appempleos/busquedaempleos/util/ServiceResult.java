package com.appempleos.busquedaempleos.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceResult {
    public List<String> VALIDATION_BLOKING = new ArrayList<>();
    public List<String> VALIDATION_MILD = new ArrayList<>();
    public List<String> EXCEPTION = new ArrayList<>();

    public Integer ERROR_NUMBER = null;
    public Object RESPONSE_DATA = null;

    public HashMap<String, Object> getResponse(){
        HashMap<String, Object> response = new HashMap<>();
        if(EXCEPTION.isEmpty()){
            if(!VALIDATION_BLOKING.isEmpty()){
                response.put("validationBloking", VALIDATION_BLOKING);
                response.put("errorNumber", ERROR_NUMBER);
            }else if (!VALIDATION_BLOKING.isEmpty()){
                response.put("validationMild", VALIDATION_MILD);
                response.put("responseData", RESPONSE_DATA);
            }else{
                response.put("responseData", RESPONSE_DATA);
            }
        }else{
            response.put("exception", EXCEPTION);
        }
        return response;
    }
}
