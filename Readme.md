GAEqB
=====

This is a web app developed as a POC for implementing a website using Google App Engine (GAE) and integrating with Quickbooks (using Quick Book web connector).

An overview of this web application is blogged at :
  (TODO insert blog link)
  
NOTE
=====

-  This is a POC code, hence does not follow strict conventions/methodologies. Code has been developed
just to prove the solution works.

- in the war/WEB-INF/appengine-web.xml, replace APPLICATION_ID with your google application id.

- I have removed the generated caches and its content. So ensure to do a GWT compile, before
 testing in the local server.
 
- In order to test this, you would have to sync with your own quickbook dataset.

- Sample qwc configuration files are present in data directory. 