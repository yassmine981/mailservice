package mailservice;

import java.util.Scanner;

import mailservice.MailServerStub.Message;
import mailservice.MailServerStub.Reading_all_emails;
import mailservice.MailServerStub.Remove_an_email;
import mailservice.MailServerStub.Sending_an_email;

public class Client2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		System.out.println("your name");
		String to=scan.next();
		System.out.println("your particular sender");
		String from=scan.next();
		scan.close();
		MailServerStub ms=new MailServerStub();
		Reading_all_emails re = new Reading_all_emails();
		re.setTo(to);
		Message[] messages = ms.reading_all_emails(re).get_return();
		for (Message m:messages) {
			if(m.getFrom().equals(from)) 
			{
				Sending_an_email se=new Sending_an_email();
				se.setFrom(to);
				se.setTo(from);
				se.setSubject("re-"+m.getSubject());
				se.setMessage("well received");
				ms.sending_an_email(se);
			}
			else
			{
				Remove_an_email ree=new Remove_an_email();
				ree.setId(m.getId());
				ree.setTo(to);
				ms.remove_an_email(ree);
			}
				
		}
		Message[] final_messages = ms.reading_all_emails(re).get_return();
		for (Message me:final_messages) {
			System.out.println("Message [from=" + me.getFrom() + ", isNew=" + me.get_new() + ", message=" + me.getMessage() + ", subject=" + me.getSubject() + ", to="
					+ me.getTo() + "]");

		}

	}

}
