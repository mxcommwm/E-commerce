package mx.com.mwm.service.Openpay;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class CargoBanco {
private String metodo;
private int monto;
private String descripcion;
private String clienteName;
private String lastName;
private String numberPhone;
private String email;

	
public String getMetodo() {
	return metodo;
}


public void setMetodo(String metodo) {
	this.metodo = metodo;
}


public int getMonto() {
	return monto;
}


public void setMonto(int monto) {
	this.monto = monto;
}


public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


public String getClienteName() {
	return clienteName;
}


public void setClienteName(String clienteName) {
	this.clienteName = clienteName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getNumberPhone() {
	return numberPhone;
}


public void setNumberPhone(String numberPhone) {
	this.numberPhone = numberPhone;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public void cargoB (String metodo,int monto,String descripcion, String clienteName,String lastName,String numberPhone,String email) {
	String url="https://sandbox-api.openpay.mx/v1/mexcviwsqt2snzeylcy5/charges";
	try {		
	
	Client cliente = Client.create();
cliente.addFilter(new HTTPBasicAuthFilter("sk_baecf471d8cd4f3cad0528436d028236",""));

WebResource webResource= cliente.resource(url);
String input ="{\"method\" : \""+metodo+"\",\r\n" + 
		"   \"amount\" : "+monto+",\r\n" + 
		"   \"currency\" : \"MXN\",\r\n" + 
		"   \"description\" : \""+descripcion+"\",\r\n" +  
		"   \"customer\" : {\r\n" + 
		"        \"name\" : \""+clienteName+"\",\r\n" + 
		"        \"last_name\" : \""+lastName+"\",\r\n" + 
		"        \"phone_number\" : \""+numberPhone+"\",\r\n" + 
		"        \"email\" : \""+email+"\"\r\n" + 
		"   }\r\n" + 
		"}";

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
