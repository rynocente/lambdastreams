package mid;

public class Mailer {
	
	public void from(String address) {
		
	}
	
	public void to(String address) {
		
	}
	
	public void subject(String line) {
		
	}
	
	public void body(String message) {
		
	}
	
	public void send() {
		System.out.println("sending email...");
	}
	
	
	//v.1 mailer
	public static void main(String[] args) {
		
		Mailer mailer = new Mailer();
		mailer.from("admin@gmail.com");
		mailer.to("destiny@gmail.com");
		mailer.subject("notification");
		mailer.body("...hello...");
		mailer.send();
		
		
	}
	
	

}
