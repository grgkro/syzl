package de.stuttgart.syzl.service;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.stuttgart.syzl.entity.Media;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class ConnectivityService {

	public String getPayloadFromURL(String URL) {

		OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(URL).method("GET", null).build();

        try {
            return client.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        
	}
	
}
