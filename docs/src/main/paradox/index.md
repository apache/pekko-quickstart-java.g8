# Apache Pekko Actors Quickstart with Java
 
Apache Pekko is a toolkit and runtime for building highly concurrent, distributed, and fault-tolerant event-driven applications on the JVM. Pekko can be used with both Java and Scala.
This guide introduces Pekko Actors by describing the Java version of the Hello World example. If you prefer to use Pekko with Scala, switch to the Pekko Quickstart with Scala guide. 

Actors are the unit of execution in Pekko. The Actor model is an abstraction that makes it easier to write correct concurrent, parallel and distributed systems. The Hello World example illustrates Pekko basics. Within 30 minutes, you should be able to download and run the example and use this guide to understand how the example is constructed. This will get your feet wet, and hopefully inspire you to dive deeper into the wonderful world of Pekko!

After trying this example the comprehensive [Getting Started Guide](https://pekko.apache.org/docs/pekko/current/java/guide/introduction.html) is a good next step to continue learning more about Pekko.

## Install

The easiest way to setup this project is use [sbt](https://www.scala-sbt.org).

Open a Terminal window and run the following command. It will create a subdirectory with the example code in it.
```
sbt new apache/pekko-quickstart-java.g8
```

## Running the example

Create a new project using `sbt new apache/pekko-quickstart-java.g8`.

Make sure that you have installed the build tool of your choice and thereafter open a Terminal window and, from inside the project directory, type the following to run Hello World:

Maven
:  ```
$ mvn compile exec:exec
```

Gradle
:  ```
$ gradle run
```

The output should look _something_ like this (scroll all the way to the right to see the Actor output):
 
Maven
: ```
Scanning for projects...
[INFO]
[INFO] ------------------------< hello-pekko-java:app >-------------------------
[INFO] Building app 1.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ app ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO]
[INFO] --- exec-maven-plugin:1.6.0:exec (default-cli) @ app ---
[2019-10-12 09:20:30,248] [INFO] [org.apache.pekko.event.slf4j.Slf4jLogger] [hellopekko-pekko.actor.default-dispatcher-3] [] -
Slf4jLogger started
SLF4J: A number (1) of logging calls during the initialization phase have been intercepted and are
SLF4J: now being replayed. These are subject to the filtering rules of the underlying logging system.
SLF4J: See also https://www.slf4j.org/codes.html#replay
>>> Press ENTER to exit <<<
[2019-10-12 09:20:30,288] [INFO] [com.example.Greeter] [hellopekko-pekko.actor.default-dispatcher-6]
[pekko://hellopekko/user/greeter] - Hello Charles!
[2019-10-12 09:20:30,290] [INFO] [com.example.GreeterBot] [hellopekko-pekko.actor.default-dispatcher-3]
[pekko://hellopekko/user/Charles] - Greeting 1 for Charles
[2019-10-12 09:20:30,291] [INFO] [com.example.Greeter] [hellopekko-pekko.actor.default-dispatcher-6]
[pekko://hellopekko/user/greeter] - Hello Charles!
[2019-10-12 09:20:30,291] [INFO] [com.example.GreeterBot] [hellopekko-pekko.actor.default-dispatcher-3]
[pekko://hellopekko/user/Charles] - Greeting 2 for Charles
[2019-10-12 09:20:30,291] [INFO] [com.example.Greeter] [hellopekko-pekko.actor.default-dispatcher-6]
[pekko://hellopekko/user/greeter] - Hello Charles!
[2019-10-12 09:20:30,291] [INFO] [com.example.GreeterBot] [hellopekko-pekko.actor.default-dispatcher-3]
[pekko://hellopekko/user/Charles] - Greeting 3 for Charles
```

Gradle
: ```
:run 
[2019-10-12 09:47:16,399] [INFO] [org.apache.pekko.event.slf4j.Slf4jLogger] [hellopekko-pekko.actor.default-dispatcher-3] [] -
Slf4jLogger started
SLF4J: A number (1) of logging calls during the initialization phase have been intercepted and are
SLF4J: now being replayed. These are subject to the filtering rules of the underlying logging system.
SLF4J: See also https://www.slf4j.org/codes.html#replay
>>> Press ENTER to exit <<<
[2019-10-12 09:47:16,437] [INFO] [com.example.Greeter] [hellopekko-pekko.actor.default-dispatcher-6]
[pekko://hellopekko/user/greeter] - Hello Charles!
[2019-10-12 09:47:16,439] [INFO] [com.example.GreeterBot] [hellopekko-pekko.actor.default-dispatcher-3]
[pekko://hellopekko/user/Charles] - Greeting 1 for Charles
[2019-10-12 09:47:16,440] [INFO] [com.example.Greeter] [hellopekko-pekko.actor.default-dispatcher-6]
[pekko://hellopekko/user/greeter] - Hello Charles!
[2019-10-12 09:47:16,440] [INFO] [com.example.GreeterBot] [hellopekko-pekko.actor.default-dispatcher-3]
[pekko://hellopekko/user/Charles] - Greeting 2 for Charles
[2019-10-12 09:47:16,440] [INFO] [com.example.Greeter] [hellopekko-pekko.actor.default-dispatcher-6]
[pekko://hellopekko/user/greeter] - Hello Charles!
[2019-10-12 09:47:16,440] [INFO] [com.example.GreeterBot] [hellopekko-pekko.actor.default-dispatcher-3]
[pekko://hellopekko/user/Charles] - Greeting 3 for Charles
<=========----> 75% EXECUTING [27s]
> :run
```
   
Congratulations, you just ran your first Pekko app. Now take a look at what happened under the covers. 

## What Hello World does

The example consists of three actors:

* Greeter: Receives commands to `Greet` someone and responds with a `Greeted` to confirm the greeting has taken place
* GreeterBot: receives the reply from the Greeter and sends a number of additional greeting messages and collect the replies until a given max number of messages have been reached.
* GreeterMain: The guardian actor that bootstraps everything

## Benefits of using the Actor Model

The following characteristics of Pekko allow you to solve difficult concurrency and scalability challenges in an intuitive way: 

* Event-driven model &#8212; Actors perform work in response to messages. Communication between Actors is asynchronous, allowing Actors to send messages and continue their own work without blocking to wait for a reply.
* Strong isolation principles &#8212; Unlike regular objects in Java, an Actor does not have a public API in terms of methods that you can invoke. Instead, its public API is defined through messages that the actor handles. This prevents any sharing of state between Actors; the only way to observe another actor's state is by sending it a message asking for it.
* Location transparency &#8212; The system constructs Actors from a factory and returns references to the instances. Because location doesn't matter, Actor instances can start, stop, move, and restart to scale up and down as well as recover from unexpected failures. 
* Lightweight &#8212; Each instance consumes only a few hundred bytes, which realistically allows millions of concurrent Actors to exist in a single application.
 
Let's look at some best practices for working with Actors and messages in the context of the Hello World example.

@@@index

* [Define the Actors and messages](define-actors.md)
* [Create the Actors](create-actors.md)
* [Communicate with Actors](communicate-with-actors.md)
* [The Main Class](main-class.md)
* [Full Example](full-example.md)
* [Testing Actors](testing-actors.md)
* [Running the Application](running-the-application.md)
* [IntelliJ](intellij-idea.md)

@@@
