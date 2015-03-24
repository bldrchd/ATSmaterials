package com.sap.ats.tests.webcontainer.nw05.webcontainer.response.headers;

import com.sap.ats.Test;
import com.sap.ats.tests.webcontainer.util.AbstractTest;

/*
 * Tests request a servlet or jsp with "Connection: close" and without .gzip .
 *
 * @author Asya Chakarova
 */

public class ContentLengthHeaderOnConnectionCloseTest extends AbstractTest implements Test {

	public ContentLengthHeaderOnConnectionCloseTest() {
		requests = new String[] 
				{ "GET /startPage HTTP/1.1\r\n"
				+ "Accept: */*\r\n" + "Connection: close\r\n"
				+ "Host: localhost:50000\r\n\r\n" };

		statusLines = new String[]
				{ "HTTP/1.1 200 OK" };

		responseHeaders = new String[][] { 
				{ "connection: close",
				"content-length: @" } 
		};

		responseHeadersNotContain = new String[][] { 
				{ "content-encoding: gzip" }
		};
		
		responseBodiesToContain = new String[][] {
				{"<body>",
				"</body>"}
		};
}

	public int prepare() {
		return super.A_init();
	}

	public int C_requests() {
		return super.requests();
	}
}
