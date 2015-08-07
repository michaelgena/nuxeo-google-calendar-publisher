package org.nuxeo.google.calendar;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;

public class CalendarPubTest {

	public static void main(String[] args) {
		String emailAddress = "758445320891-febap1fub3bqns19gu2g953ot6fplamt@developer.gserviceaccount.com";
		JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
		HttpTransport httpTransport;
		try {
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			GoogleCredential credential = new GoogleCredential.Builder()
				    .setTransport(httpTransport)
				    .setJsonFactory(JSON_FACTORY)
				    .setServiceAccountId(emailAddress)
				    .setServiceAccountPrivateKeyFromP12File(new File("/Users/mgena/Documents/workspace/nuxeo-google-calendar-publisher/src/main/resources/nuxeo-google-calendar-pub-1c814ee29b74.p12"))
				    .setServiceAccountScopes(Collections.singleton(CalendarScopes.CALENDAR))
				    .build();
	    	// Initialize Calendar service with valid OAuth credentials
	    	
	    	Calendar service = new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
	    	    .setApplicationName("nuxeo-google-calendar-pub").build();
	    	  	
	    	Event event = new Event()
	    		    .setSummary("Michael Gena is out of office")
	    		    .setLocation("800 Howard St., San Francisco, CA 94103")
	    		    .setDescription("Time for some vacation.");

	    		DateTime startDateTime = new DateTime("2015-08-05T09:00:00-07:00");
	    		EventDateTime start = new EventDateTime()
	    		    .setDateTime(startDateTime)
	    		    .setTimeZone("America/Los_Angeles");
	    		event.setStart(start);

	    		DateTime endDateTime = new DateTime("2015-08-15T17:00:00-07:00");
	    		EventDateTime end = new EventDateTime()
	    		    .setDateTime(endDateTime)
	    		    .setTimeZone("America/Los_Angeles");
	    		event.setEnd(end);

	    		EventAttendee[] attendees = new EventAttendee[] {
	    		    new EventAttendee().setEmail("mgena@nuxeo.com")
	    		};
	    		event.setAttendees(Arrays.asList(attendees));

	    		String calendarId = "primary";
	    		event = service.events().insert(calendarId, event).execute();	    	
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
