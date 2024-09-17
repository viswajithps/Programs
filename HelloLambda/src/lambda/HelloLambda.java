package lambda;

public class HelloLambda {

	/*
	 * public String handleRequest() { return "Hello AWS Lambda!!!!"; }
	 */
	
	public String handleRequest(String name) {
		return "Hello AWS Lambda! "+name;
	}
}
