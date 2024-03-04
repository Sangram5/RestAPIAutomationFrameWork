package apiEndPoints;

public class Routes {

	//Maintain all module urls 
	
	/*POST	https://petstore.swagger.io/v2/user
GET	https://petstore.swagger.io/v2/user/{username}
PUT	https://petstore.swagger.io/v2/user/{username}
DELETE	https://petstore.swagger.io/v2/user/{username}
*/

	public static String base_Url="https://petstore.swagger.io/v2";
	
	//User Module Urls
	public static String post_Url=base_Url + "/user";
	
	public static String get_Url=base_Url + "/user/{username}";
	
	public static String put_Url=base_Url + "/user/{username}";
	
	public static String delete_Url=base_Url + "/user/{username}";
	
	//Pet module urls
	
}
