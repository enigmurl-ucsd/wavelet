# springNotSpring15l

This repo provides a basic counter program that runs as a standalone webapp. It has two versions:

## Version1: Spring

# Spring demo
​
NOTE: Make sure you have Visual Studio Code and Java (jdk) installed on your computer (with the PATH environment variable). 
> Pretty sure we already have a document/lab explaining this
​
## Set-up
​
Set an environment variable with name `JAVA_HOME` and value `[the path to your JDK installation]`.
​
```
> Example (Windows):
Variable name: JAVA_HOME
Variable value: C:\Program Files\Java\jdk-19\
```
​
## Running the file
Download the demo folder onto your computer and open it in VSCode.
​
**NOTE**: Make sure your folder doesn't have `()` in the name. This may cause an error later when you try to run the file.
> Error: `"}" was unexpected at this time.`
​
> Found on Windows 11. [Moving the file out of the Downloads folder](https://stackoverflow.com/questions/62028432/mvnw-cmd-for-demo-spring-boot-project-not-working-in-windows) also might help? 
​
First, `cd` into the folder that contains `src`.
- Now, when you run the `ls` command, you should see a bunch of files, one of them being `src`.
​
**Run the following command**:
```
Windows:
mvnw spring-boot:run
-- OR --
.\mvnw spring-boot:run
​
Linux:
./mvnw spring-boot:run
```
​
The program will take a minute to run the first time. Eventually, you should see text art displaying the word `Spring` appear, and eventually, no more text should appear in the terminal. Now, the program is running!
​
Example:
​
![What your terminal should look like](https://i.imgur.com/RtW1wW5.png)
​
## Testing
Find `main` > `java` > `com` > `program` > `ProgramClass.java`
​
In that file are examples of functions attached to URLs to try accessing, including:
- http://localhost:8080/
- http://localhost:8080/increment
- http://localhost:8080/add?count=20
​
​
What will each of these URLs do?

## Version2: Basic Java Servlet

It's basically an implementation on the default Java Servlet library with Apache Tomcat.

Just in case if we need to make the size of this repo smaller:

[servlet jar](https://mavenlibs.com/jar/file/tomcat/servlet-api)

[apache tomcat](https://tomcat.apache.org/download-80.cgi)

To run the program, do the following:

```bash
cd ServletAttempt
javac -cp jars/servlet-api-5.5.23.jar ServletWrapper.java ProgramClass.java
mv ServletWrapper.class ProgramClass.class tomcat/apache-tomcat-8.5.82/webapps/ROOT/WEB-INF/classes/
bash tomcat/apache-tomcat-8.5.82/bin/catalina.sh run
```

It is confirmed that jdb works with this version according to the following [StackOverflow answer](https://stackoverflow.com/a/68929474/15466075) and has been tested to work.
