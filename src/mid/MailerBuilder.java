package mid;

public class MailerBuilder {
	
	public MailerBuilder from(String address) {
		return this;
	}
	
	public MailerBuilder to(String address) {
		return this;
	}
	
	public MailerBuilder subject(String line) {
		return this;
	}
	
	public MailerBuilder body(String message) {
		return this;
	}
	
	public void send() {
		System.out.println("sending email...");
	}
	

	//v.2 mailer
	public static void main(String[] args) {
		
		new MailerBuilder()
			.from("admin@gmail.com")
			.to("destiny@gmail.com")
			.subject("notification")
			.body("...hello...")
			.send();
		

	}

}
