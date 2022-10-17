package com.ronaldalfonso.app.users.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ronaldalfonso.app.users.models.dto.*;
import com.sun.xml.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;

@Service
public class ExternalService {

    public ServiceResponse encodeDES(String param) {
        Date dateStart = new Date();
        ServiceResponse response = new ServiceResponse();
        RestTemplate restTemplate = new RestTemplate();
        RegisterCount registerCount = new RegisterCount();
        String urlBase = "https://my.api.mockaroo.com/test-tecnico/search/";
        String keyApi = "ionix123456";
        String encryptedRut;

        try {
            DESKeySpec keySpec = new DESKeySpec(keyApi.getBytes("UTF8"));
            SecretKeyFactory desFact = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = desFact.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cleartext = param.getBytes("UTF8");
            byte[] enc = cipher.doFinal(cleartext);
            enc = BASE64EncoderStream.encode(enc);
            encryptedRut = new String(enc);
        } catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException |
                 NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-Key", "f2f719e0");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        String url = urlBase + encryptedRut;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseExternal responseExternal;
        try {
            responseExternal = objectMapper.readValue(responseEntity.getBody(), ResponseExternal.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        List<Items> itemsList = responseExternal.getResult().getItems();
        String count = String.valueOf(itemsList.size());
        registerCount.setRegisterCount(count);

        Date dateEnd = new Date();
        response.setResult(registerCount);
        response.setResponseCode(ServiceResponse.OK);
        response.setDescription(ServiceResponse.STATUS_SUCCESS);
        response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));

        return response;
    }

}
