package com.example.servicereaderjob.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.servicereaderjob.domain.ResponseUser;
import com.example.servicereaderjob.domain.User;

@Component
public class UserReader implements ItemReader<User> {

	private RestTemplate restTemplate = new RestTemplate();
	private int page;

	@Override
	public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO: Implementar leitura
	}

	private List<User> fetchUserDataFromAPI() {
		ResponseEntity<ResponseUser> response = 
				restTemplate.getForEntity(String.format("https://gorest.co.in/public/v1/users?page=%d", page)
						, ResponseUser.class);
		List<User> userData = response.getBody().getData();		
		return userData;
	}
}
