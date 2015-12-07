package org.archfirst.template.services;

import java.util.List;

import org.archfirst.template.domain.Account;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class AccountService {
	
	private final Client client;
	
	public AccountService() {
		// Create Jersey client
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		client = Client.create(clientConfig);
	}

	public Account createAccount(Account account) {
        WebResource resource = client.resource(Constants.API  + "/accounts");
        ClientResponse response = resource.type("application/json").post(ClientResponse.class, account);
        return response.getEntity(Account.class);
	}

	public Account updateAccount(Account account) {
        WebResource resource = client.resource(Constants.API  + "/accounts/" + account.getId());
        ClientResponse response = resource.type("application/json").put(ClientResponse.class, account);
        return response.getEntity(Account.class);
	}

	public Account getAccount(int id) throws NotFoundException {
        WebResource resource = client.resource(Constants.API  + "/accounts/" + id);
        ClientResponse response = resource.type("application/json").get(ClientResponse.class);
        if (response.getStatus() == 404) {
        	throw new NotFoundException();
        }
        return response.getEntity(Account.class);
	}

	public List<Account> getAccounts() {
        WebResource resource = client.resource(Constants.API  + "/accounts");
        return resource.type("application/json")
        		.get(new GenericType<List<Account>>(){});
	}

	public void deleteAccount(int id) {
        WebResource resource = client.resource(Constants.API  + "/accounts/" + id);
        resource.type("application/json").delete(ClientResponse.class);
	}
}
