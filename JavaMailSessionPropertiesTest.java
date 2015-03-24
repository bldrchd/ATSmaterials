ackage com.sap.ats.tests.webcontainer.nw04.javamail;

import java.io.*;

import com.sap.ats.Test;
import com.sap.ats.tests.webcontainer.util.AbstractTest;

/*
 * Test must receive UnsupportedOperationException when running the JSP.
 * After creating another JavaMailSession, unil.Properties can be edited. 
 */

public class JavaMailSessionPropertiesTest extends AbstractTest implements Test{
		
	/*public JavaMailSessionPropertiesTest(){
		 requests = new String[]{
				 //TODO
				 "GET \"java:comp/env/mail/MailSession\" HTTP/1.0\r\n" +
				 "host:localhost\r\n"
		};
		responseBodiesToContain = new String[][]{
				{
					"<head>",
					"<html>",
					"javax.mail.Session@",
					"</head>",
					"</html>"
				}
		};
	}*/
	//requests:
	//"GET http://host:55/app1/index1.jsp HTTP/1.0\r\n" +
    //"Connection: Keep-Alive\r\n\r\n"
	public int A_init(){
		
	  return super.A_init();
	  }
	
	public int B_deploy() {
		  //TODO
		    return super.B_deploy();
		  }
	
	public int E_requests() {
		    requests = new String[]{
		      "GET http://localhost/JavaMailSessionPropertiesTest/TestJavaMailFix.jsp HTTP/1.0\r\n" 
		    };
		    responseBodiesToContain = new String[][]{
		    		{
		    			 "<html>",
						 "Exception during setProperty() operation. ",
						 "</html>"
		    		}
		    };
		    return super.requests();
	 }
	
	public int G_requests() {
		    requests = new String[]{
		      "GET http://localhost/JavaMailSessionPropertiesTest/TestJavaMailFix.jsp HTTP/1.0\r\n" 
		    };
		    responseBodiesToContain = new String[][]{
		    		{
		    			 "<html>",
						 "Exception during put() operation. ",
						 "</html>"
		    		}
		    };
		    return super.requests();
	 }
	 public int F_request(){
		 requests = new String[]{
				 "GET http://localhost/MailSession/JavaMailSessionProperties2.jsp HTTP/1.0\r\n"
		 };
		 responseBodiesToContain = new String[][]{
				 {
					 "<html>",
					 "Passed. ",
					 "</html>"
				 }
		 };
		 return super.requests();
	 }
}
