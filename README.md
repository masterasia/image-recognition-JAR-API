# image-recognition-JAR-API
java API for https://exadeep.com/

You can use this project in two ways .

1.An executable jar 
Download project.
Use maven install.
Find the jar the name is end with one-jar.
Use it like a executable jar: java -jar ...jar



2.A resource jar
Add this jar in your resource lib.
Use RecognitionFactory class get the interface.
There already have two definition:RequestType.URL  RequestType.RESOURCES
When you use the interface, you need call prepare first, and then just execute it.


Before you use it, please check properties.
In the path:src/main/resources/init.properties
KEY:means
HTTP.URL.ISPORN:The API url you get from https://exadeep.com/
HTTP.METHOD.ISPORN:no use now
API.KEY.ISPORN:the KEY you get from https://exadeep.com/


Any problem, leave a meesage. 
