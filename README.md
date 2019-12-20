# FakeNewsAlert
A java webservice that checks if screenshots of tweets are real or fake news. Uses Microsoft Cognitive Services OCR API and Twitter API.

Sprint 1: Create a local service that tells you if a tweet is real or fake based on a username and tweet.

Steps to get started are below:
1. Import the pom.xml file into IntelliJ or an IDE of your choice
2. Run the maven clean and install task.(via yoiur IDE or command line)
Notes: This is what is happening while you are running these tasks. Essentially, if you follow the pom.xml file, as well as downloading dependencies, it will also create a jar file under the lib folder and a war file under this folder target/fakenewsalert-1.0-SNAPSHOT/WEB-INF/lib
You need a jar file and war file to deploy your service in Azure. (TODO: Create pipeline in Azure Devops)

3. The next thing you need to do is to get a Twitter App ID, App Secret, Token and Secret and put this into the Constants class
See the "How to get started with the Twitter API" section on this page: https://developer.twitter.com/en/docs/basics/getting-started
(TODO: Store credentials in Azure Key Vault)

4. After this you can start your service. Run your main class "RestLauncher.java" which launches the Rest Service(using the vertx library)

5. Test the service locally using Postman

-Use this GET Request endpoint to ping the service(as a healthcheck): http://localhost:8080/test

-Use a POST request to check if a tweet is real or fake, endpoint: http://localhost:8080/verify, add this JSON payload to the body of the POSt request. The Service should return a string with "real" or "fake" to determine whether the tweet is real or not.

{
"handle":"@similola",
"tweet":"This is a test tweet, playing around with the Twitter API (again). As you were :)"
}

Sprint 2: Deploy web service to Azure using Azure app service

TBD

Sprint 3: Create a service that uses Microsoft Cognitive Services OCR to identify userhandle and tweet content from screenshot

TBD

Sprint 4: Create end to end service using OCR and Twitter APIs

TBD

Sprint 5: Deploy final service to Azure

TBD

