package be.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import be.web.ContextUtil;

public class NotificationUtil {
	
	/** erase all message*/
	public static void reset(){	
		HttpSession httpSession = ContextUtil.getHttpSession();
		
		httpSession.setAttribute("notifications",null);
		httpSession.setAttribute("errors",null);
	}

	/** Sets a message string to be displayed by the next JSP in the Notification bar */
	public static void addNotificationMessage(String notification){
	    
	    HttpSession httpSession = ContextUtil.getHttpSession();
	       
	    @SuppressWarnings("unchecked")
		List<Notification> notifications=(List<Notification>) httpSession.getAttribute("notifications");
	    
	    if(notifications==null){
	    	notifications = new ArrayList<Notification>();
	    }
    	notifications.add(new Notification(notification,Status.NOTICE));
	    
		httpSession.setAttribute("notifications",notifications);
	}
	
	/** Sets a error string to be displayed by the next JSP in the Notification bar */
	public static void addErrorMessage(String notification){
	    
	    HttpSession httpSession = ContextUtil.getHttpSession();
	       
	    @SuppressWarnings("unchecked")
		List<Notification> errors=(List<Notification>) httpSession.getAttribute("errors");
	    
	    if(errors==null){
	    	errors = new ArrayList<Notification>();
	    }
    	errors.add(new Notification(notification,Status.ERROR));
	    
		httpSession.setAttribute("errors",errors);
	}
	
	
	public enum Status{
		
		ERROR("Error"),
		NOTICE("Notice");
	
		String name;
		Status(String name){
			this.name=name;
		}

		public String getName(){
			return name;
		}
		
	}
	
	
	static public class  Notification{
		
		String text;
		Status status;
		
		public Notification (String text,Status status){
			this.text=text;
			this.status=status;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Notification [text=" + text + ", status=" + status + "]";
		}
		
		
	}
	
	
}
