# Fake News Alert
A java webservice that checks if tweets are real or fake news. Uses Vertx for the webservice and Twitter API to verify tweets based on a username and a tweet.

## Project Background
This project won the CreateCon 2018 UK Hackathon, subsequently invited to Microsoft Corp in Redmond to build a beta version.
### Demo Video at One Week Hackathon 2018
<a href="http://www.youtube.com/watch?feature=player_embedded&v=0HfON-5dUpY
" target="_blank"><img src="http://img.youtube.com/vi/0HfON-5dUpY/0.jpg" 
alt="Demo Video at One Week Hackathon 2018" width="240" height="180" border="10" /></a>
### One Week Hackathon 2018 Vlog
<a href="http://www.youtube.com/watch?feature=player_embedded&v=2JUmncbo2xU
" target="_blank"><img src="http://img.youtube.com/vi/2JUmncbo2xU/0.jpg" 
alt="One Week Hackathon 2018 Vlog" width="240" height="180" border="10" /></a>

## Steps to get started:
1. Import the pom.xml file into IntelliJ/Visual Studio Code or an IDE of your choice
2. Run the maven clean and install task.(via your IDE or command line)
   Command line instructions 
   First check if maven is installed with the following (check version)
   $ mvn -v
   $ mvn clean install
   Notes: This is what is happening while you are running these tasks: Essentially, if you follow the pom.xml file, as well as    downloading dependencies, it will also create a jar file under the lib folder and a war file under this folder target/fakenewsalert-1.0-SNAPSHOT/WEB-INF/lib. You need a jar file and war file to deploy your service in the future.

3. The next thing you need to do is to get a Twitter App ID, App Secret, Token and Secret and put this into the Constants class
See the "How to get started with the Twitter API" section on this page: https://developer.twitter.com/en/docs/basics/getting-started
(It is preferable to store credentials somewhere secure like Azure Key Vault)

4. After this you can start your service. Run your main class "RestLauncher.java" which launches the Rest Service(using the vertx library)

5. Test the service locally using Postman

*Use this GET Request endpoint to ping the service(as a healthcheck): http://localhost:8080/test

*Use a POST request to check if a tweet is real or fake, endpoint: http://localhost:8080/verify, add this JSON payload to the body of the POST request. The Service should return a string with "real" or "fake" to determine whether the tweet is real or not.

{
"handle":"@similola",
"tweet":"This is a test tweet, playing around with the Twitter API (again). As you were :)"
}

