package mailservice;

import java.util.Scanner;

import mailservice.MailServerStub.Message;
import mailservice.MailServerStub.Reading_all_emails;
import mailservice.MailServerStub.Remove_an_email;

public class Client1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		System.out.println("your name");
		String to=scan.next();
		scan.close();
		MailServerStub ms=new MailServerStub();
		Reading_all_emails re=new Reading_all_emails();
		re.setTo(to);
		Message[] messages = ms.reading_all_emails(re).get_return();
		int count=0;
		for (Message m:messages) {
			if(m.getSubject().toUpperCase().contains("SPAM")) {
				Remove_an_email ree=new Remove_an_email();
				ree.setId(m.getId());
				ree.setTo(to);
				ms.remove_an_email(ree);
				count++;
				
			}
		}
		if (count>0) {
			System.out.println("Spam messages have been deleted successfully!");
		}
		else 
			System.out.println("No Spam messages Found!");

		System.out.println();
		System.out.println("here is the list of your messages:");
		
		Message[] final_messages = ms.reading_all_emails(re).get_return();

		for (Message me:final_messages) {
			System.out.println("Message [from=" + me.getFrom() + ", isNew=" + me.get_new() + ", message=" + me.getMessage() + ", subject=" + me.getSubject() + ", to="
					+ me.getTo() + "]");


		}

	}}