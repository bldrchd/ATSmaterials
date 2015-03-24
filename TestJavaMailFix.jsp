<%@ page import="javax.mail.Session, java.util.Properties, javax.naming.InitialContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception</title>
</head>
<body>
<%
	try{
		Session m_Session;
		Properties props;
		Properties jndiProperties = new Properties();
		jndiProperties.put("domain", "true");
		InitialContext ctx = new InitialContext(jndiProperties);
		out.println("Looking up for javax.mail.Session...</br>" );
		m_Session = (Session) ctx.lookup("java:comp/env/mail/MailSession");
	
		try {
			m_Session.getProperties().setProperty("mail.smtp.auth", "true");
		} catch(UnsupportedOperationException uoe){ 
			out.println("Exception during setProperty() operation. " + uoe.getMessage());
		}
		
		try{
			m_Session.getProperties().put("test", "test-put");
		} catch(UnsupportedOperationException uoe){ 
			out.println("Exception during put() operation. " + uoe.getMessage());
		}
	
	} catch (javax.naming.NamingException e) {
		out.println(e.getMessage());
	}
%>
</body>
</html>
