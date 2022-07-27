package mailservice;

import java.rmi.RemoteException;
import java.util.Scanner;
import mailservice.MailServerStub.Sending_an_email;
import mailservice.MailServerStub.Reading_all_emails;
import mailservice.MailServerStub.Remove_an_email;
import mailservice.MailServerStub.Deleting_all_received_mails;
import mailservice.MailServerStub.Message;

public class Client {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			Scanner scan= new Scanner(System.in);
			System.out.println("your name");
			String from=scan.next();
			System.out.println("this is your menu ! : ");
			System.out.println("1-sending an email");
			System.out.println("2-reading all emails received");
			System.out.println("3-deleting all received mails");
			System.out.println("4-deleting an email");
			System.out.println("5-Exit");

			MailServerStub ms=new MailServerStub();
			int next=0;
			while(next==0) {
				System.out.println("please make your choice");
				int i=scan.nextInt();
			
			switch(i){
			case 1 : 
				System.out.println("to");
				String to=scan.next();
				System.out.println("subject");
				String subject=scan.next();
				System.out.println("message");
				String message=scan.next();
				Sending_an_email se=new Sending_an_email();
				se.setFrom(from);
				se.setTo(to);
				se.setSubject(subject);
				se.setMessage(message);
				System.out.println(ms.sending_an_email(se).get_return());
				break;
			case 2 :
				Reading_all_emails re=new Reading_all_emails();
				re.setTo(from);
				Message[] m = ms.reading_all_emails(re).get_return();
				for (Message me:m) {
					System.out.println("Message [from=" + me.getFrom() + ", isNew=" + me.get_new() + ", message=" + me.getMessage() + ", subject=" + me.getSubject() + ", to="
							+ me.getTo() + "]");
				}
				break;
			case 3:
				Deleting_all_received_mails de=new Deleting_all_received_mails();
				de.setTo(from);
				System.out.println(ms.deleting_all_received_mails(de).get_return());
				break;
			case 4:
				System.out.println("please enter the id of the email");
				int id=scan.nextInt();
				Remove_an_email ree=new Remove_an_email();
				ree.setId(id);
				ree.setTo(from);
				System.out.println(ms.remove_an_email(ree).get_return());
				break;
			case 5:
				next=1;
				System.out.println("thanks, see you!");
			
			}
			
			}
			scan.close();
			

		}

	}