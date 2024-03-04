package apiEndPoints;

import static io.restassured.RestAssured.given;

import apiPayload.UserPaylod;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	//Here create methods for the user module every request ie.GET,POST,PUT etc
	
	public static Response createUser(UserPaylod payLoad) {
		
		Response response= given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payLoad)
		.when()
		.post(Routes.post_Url);
		
		return response;
		
	}
	
public static Response GetUser(String userName) {
		
		Response response= given()
		.accept(ContentType.JSON)
		
		.pathParam("username", userName)
		.when()
		.get(Routes.get_Url);
		
		return response;
		
	}
	
public static Response UpdateUser(String userName,UserPaylod payLoad) {
	
	Response response= given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.pathParam("username", userName)
	.body(payLoad)
	.when()
	.put(Routes.put_Url);
	
	return response;
	
}

public static Response DeleteUser(String userName) {
	
	Response response= given()
	.accept(ContentType.JSON)
	
	.pathParam("username", userName)
	.when()
	.delete(Routes.delete_Url);
	
	return response;
	
}

}
