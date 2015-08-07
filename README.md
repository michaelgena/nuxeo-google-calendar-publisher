# nuxeo-google-calendar-publisher
This plugin enables you to publish on Google Calendar through a nuxeo automation operation.

## Build

Assuming [maven](http://maven.apache.org/) (3.2.1) is installed on your system, after downloading the whole repository, execute the following:
```
mvn install
```

## Deploy

Upload the zip file generated (nuxeo-google-calendar-publisher-mp/target/nuxeo-google-calendar-publisher-mp-xxx.zip)
into your local packages and install it.

## Nuxeo Studio

Import the automation operation "Publisher" in your project registry
You will find a new entry under the automation tools:
Notification>Publish on Google Calendar
The operation expects multiple parameters:
-userEmailAddress: the user e-mail to whom an event will be created
-summary: the title of the event
-location: the location of the event
-description: the description of the event
-startDate: the start date of the event (currently only full days events are handled)
-endDate: the end date of the event
-attendeeEmailAddress: e-mail adress of the attendee (currently only one attendee is handled)

## Configuration in the Nuxeo platform

We currently use the OAuth2 authentification mechanism in order to do the publication.
First you need to have a google api access for google calendar with a client ID and Client Secret token. 
If you don't have one you have to create it here: https://console.developers.google.com/

Then you need to add some modification under Administrator>Cloud Services>Service Providers>googledrive
Add/Edit the Client ID and the Client Secret

-d’étendre le périmètre de l'application existante pour google drive (déjà défini dans nuxeo) en lui donnant la possibilité de publier sur Google Calendar (https://console.developers.google.com/project)
-d’étendre également le scope de cette appli en rajoutant https://www.google.com/calendar/feeds/ , dans admin>Cloud Services> Oauth2 Service Providers> googledrive

If you don't have a key or a google account , you can create one at https://console.developers.google.com/

## Important Note

**These features are not part of the Nuxeo Production platform.**

These solutions are provided for inspiration and we encourage customers to use them as code samples and learning resources.

This is a moving project (no API maintenance, no deprecation process, etc.) If any of these solutions are found to be useful for the Nuxeo Platform in general, they will be integrated directly into platform, not maintained here.


## About Nuxeo

Nuxeo provides a modular, extensible Java-based [open source software platform for enterprise content management](http://www.nuxeo.com/en/products/ep) and packaged applications for [document management](http://www.nuxeo.com/en/products/document-management), [digital asset management](http://www.nuxeo.com/en/products/dam) and [case management](http://www.nuxeo.com/en/products/case-management). Designed by developers for developers, the Nuxeo platform offers a modern architecture, a powerful plug-in model and extensive packaging capabilities for building content applications.

More information at <http://www.nuxeo.com/>
