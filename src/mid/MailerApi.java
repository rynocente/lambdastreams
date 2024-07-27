package mid;

import java.util.function.Consumer;

public class MailerApi {
	
	private MailerApi() {
		
	}
	
	public MailerApi from(String address) {
		return this;
	}
	
	public MailerApi to(String address) {
		return this;
	}
	
	public MailerApi subject(String line) {
		return this;
	}
	
	public MailerApi body(String message) {
		return this;
	}
	
	public static void send(final Consumer<MailerApi> block) {
		final MailerApi mailer = new MailerApi();
		block.accept(mailer);
		System.out.println("sending email...");
	}	
	
	
	
	//v.3 mailer
	public static void main(String[] args) {
		
		MailerApi.send(mailer -> mailer
								.from("admin@gmail.com")
								.to("destiny@gmail.com")
								.subject("notification")
								.body("...hello..."));
		

	}

}
