package com.jsf.service.OpenPay;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class TestOpenPay {
	public static void main(String[] args) {
		try {

		Client cliente = Client.create();
	cliente.addFilter(new HTTPBasicAuthFilter("sk_baecf471d8cd4f3cad0528436d028236", ""));
	//	WebResource webResource = cliente
		//		.resource("https://sandbox-api.openpay.mx/v1/mexcviwsqt2snzeylcy5/customers/aphgqy9pq5wnnduvjobe");
		WebResource webResource= cliente.resource("https://sandbox-api.openpay.mx/v1/mexcviwsqt2snzeylcy5/customers/a7bvqrp1jd4enwnrwanr/charges");
		String input = "{\"method\":\"bank_account\",\"amount\":\"180\",\"description\":\"compra tplink\"}";

		//ClientResponse response=webResource.accept("application/json").get(ClientResponse.class);
		ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, input);
		
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
		
		
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
		
	} catch (Exception e) {

		e.printStackTrace();

	  }

	}

}
