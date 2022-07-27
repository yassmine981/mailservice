package mailservice;

public class Message implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5008693115958121533L;
	private String message;
    private String from;
    private String to;
    private String subject;
    private int id;
    
    public int getId() {
		return id;
	}



	public boolean isNew() {
		return isNew;
	}



	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	private boolean isNew;
 
    public Message(int id,String fromp, String top, String subjectp,String messagep){
		this.from=fromp;
		this.to=top;
		this.message=messagep;
		this.subject=subjectp;
		this.id=id;
		}
 
    public String getTo(){
    	return to;
    }
    public String getFrom(){
    	return from;
    }
    public String getMessage(){
    	return message;
    }
    public void setTo(String top){
    	to=top;
    }
    public void setFrom(String fromp){
    	from=fromp;
    }

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [from=" + from + ", isNew=" + isNew + ", message=" + message + ", subject=" + subject + ", to="
				+ to + "]";
	}
    
     
}