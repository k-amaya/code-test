# Label Insight Backend Code Test

## Tools and technologies

* Java version: Java 17
* Spring Boot version: 3.3.0
* Maven Wrapper version: 3.3.1

## The project

The project is a rest service where it exposes 2 capacities:

* Missing Letters
* Animation

Each capacity is the respective solution of each problem of the code test. To use each capacity, you send the input information by an HTTP GET request, with the information in the body of the request.

## Project execution

Is necessary to have an environment variable named "JAVA_HOME" with the path of the JDK of java 17.  

To execute the project, you can run the main class from and IDE.

Also, you can execute from the command line, starting from the root folder of the project, using the command:

~~~shell
.\mvnw spring-boot:run
~~~

### Requests

The service is exposed by the port 8582. The endpoints and the body request for the capacities are:

* Missing Letters: 
  * Endpoint: /code-test/missing-letters
  * Body request:
	~~~json
	{
	    "phrase": "Lions, and tigers, and bears, oh my!"
	}
	~~~

* Animation:
  * Endpoint: /code-test/animation
  * Body request:
    ~~~json
    {
      "speed": 1,
      "particlesPositions": "...RLRR.LLRRR..LLRR." 
    }
    ~~~

### Response

Each capacity of the service returns the response of processing the input information in the body response.

Here are some examples:

* Missing Letters:
  * Body response:
    ~~~json
    {
      "missingLetters": "cfjkpquvwxz"
    }
	~~~

  * Animation:
    * Body response:
    ~~~json
    {
      "particlesPositions": [
          "...XXXX.XXXXX..XXXX.",
          "...XX.XXX..XXXXX..XX",
          "..X..XXXX...XXX....X",
          ".X...XX.XX..XXXX....",
          "X...XX.X.XXXX.XXX...",
          "...XX...X.XX...XXX..",
          "..XX.....XXXX...XXX.",
          ".XX.....XXX.XX...XXX",
          "XX.....XX..X.XX...XX",
          "X.....XX....X.XX...X",
          ".....XX......X.XX...",
          "....XX........X.XX..",
          "...XX..........X.XX.",
          "..XX............X.XX",
          ".XX..............X.X",
          "XX................X.",
          "X..................X",
          "...................."
      ]
    }
    ~~~
