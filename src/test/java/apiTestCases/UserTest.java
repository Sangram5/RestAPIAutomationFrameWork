package apiTestCases;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import apiEndPoints.UserEndPoints;
import apiPayload.UserPaylod;
import io.restassured.response.Response;

public class UserTest {

	//To generate the test data to create the object of faker
	
	Faker faker;
	
	//Then create the object of class which call want to send the data
	//Create object of logger
	public static Logger logger;
	
	
	UserPaylod userPayload;
	@BeforeClass
	public void generateTestData() {
		faker=new Faker();
		userPayload =new UserPaylod();
		//Here set the fake data using reference of that class where you set the data
		//Here use the of HashCode for generate the random data
		
		userPayload.setId(faker.hashCode());
		userPayload.setUsername(faker.name().username());
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger=LogManager.getLogger("RestAssuredAutomationFrameWork");
		
	}
	@Test(priority = 1)
	public void testCreateUser() {
		Response response= UserEndPoints.createUser(userPayload);
		System.out.println("Create User Data");

		//log the response
		response.then().log().all();
		//Validate the response code
		
		Assert.assertEquals(response.getStatusCode(), 200 ,"Check for the status Code.");
		logger.info("Create User");
		
	}
	
	@Test(priority = 2)
	public void testGetUserData() {
		Response response= UserEndPoints.GetUser(this.userPayload.getUsername());
		System.out.println("Get  User Data");
		//log the response
		response.then().log().all();
		//Validate the response code
		
		Assert.assertEquals(response.getStatusCode(), 200 ,"Check for the status Code.");
		logger.info("Get User Data executed.");
		
	}
	@Test(priority = 3)
	public void testUpdateUser() {
		
		
		
		  userPayload.setFirstName(faker.name().firstName());
		   Response response=UserEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload); 
		  
		
           response.then().log().all();
		  System.out.println("Updaate User Data");
		  
		  
		  Assert.assertEquals(response.getStatusCode(),200,"Check for the status Code.");
		  
		  System.out.println("After udate data");
		  Response responseafterUpdate=UserEndPoints.GetUser(this.userPayload.getUsername()); 
		  responseafterUpdate.then().log().all();
		 
		
		  logger.info("Update User executed.");
		  
		 

	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		//To change the only first name 
		userPayload.setFirstName(faker.name().firstName());
		Response response= UserEndPoints.DeleteUser(this.userPayload.getUsername());
		System.out.println("Delete User Data");

		//log the response
		response.then().log().all();
		//Validate the response code
		
		Assert.assertEquals(response.getStatusCode(), 200 ,"Check for the status Code.");
		logger.info("Delete User executed.");
	}
	
}
