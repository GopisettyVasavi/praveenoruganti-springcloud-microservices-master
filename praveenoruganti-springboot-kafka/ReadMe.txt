Apache Kafka
Apache Kafka is a distributed streaming platform with capabilities such as publishing and subscribing to a stream of records, storing the records in a fault tolerant way, and processing that stream of records. 
It is used to build real-time streaming data pipelines, that can perform functionalities such as reliably passing a stream of records from one application to another and processing and transferring the records to the target applications.

Topics
Kafka is run as a cluster in one or more servers and the cluster stores/retrieves the records in a feed/category called Topics. Each record in the topic is stored with a key, value, and timestamp.
The topics can have zero, one, or multiple consumers, who will subscribe to the data written to that topic. In Kafka terms, topics are always part of a multi-subscriber feed.

Partitions
The Kafka cluster uses a partitioned log for each topic.
The partition maintains the order in which data was inserted and once the record is published to the topic, it remains there depending on the retention period (which is configurable). The records are always appended at the end of the partitions. It maintains a flag called 'offsets,' which uniquely identifies each record within the partition.
The offset is controlled by the consuming applications. Using offset, consumers might backtrace to older offsets and reprocess the records if needed.

Producers
The stream of records, i.e. data, is published to the topics by the producers. They can also assign the partition when it is publishing data to the topic. The producer can send data in a round robin way or it can implement a priority system based on sending records to certain partitions based on the priority of the record.

Consumers
Consumers consume the records from the topic. They are based on the concept of a consumer-group, where some of the consumers are assigned in the group. The record which is published to the topic is only delivered to one instance of the consumer from one consumer-group. Kafka internally uses a mechanism of consuming records inside the consumer-group. Each instance of the consumer will get hold of the particular partition log, such that within a consumer-group, the records can be processed parallelly by each consumer.

Spring Boot Kafka Application
Spring provides good support for Kafka and provides the abstraction layers to work with over the native Kafka Java clients.
We can add the below dependencies to get started with Spring Boot and Kafka.
 
Steps to download and  run Apache Kafka
Step 1: Download the apache kafka and unzip using winrar
http://apachemirror.wuchna.com/kafka/2.3.0/kafka_2.12-2.3.0.tgz
Step 2: Start the server
Once you download Kafka, you can issue a command to start ZooKeeper which is used by Kafka to store metadata.
D:\Praveen\Softwares\kafka_2.12-2.3.0>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
Next, we need to start the Kafka cluster locally by issuing the below command.
D:\Praveen\Softwares\kafka_2.12-2.3.0>bin\windows\kafka-server-start.bat .\config\server.properties
Now, by default, the Kafka server starts on localhost:9092.


Let’s develop a simple REST controller with Swagger integration and expose with one endpoint, /publish, as shown below. It is used to publish the message to the topic.
 
We can then write the producer which uses Spring's KafkaTemplate to send the message to a topic named users, as shown below.
 
We can also write the consumer as shown below, which consumes the message from the topic users and output the logs to the console.
 
Now, we need a way to tell our application where to find the Kafka servers and create a topic and publish to it. We can do it using application.yaml as shown below.
 
Let’s see the main application class with Swagger integration
 
Now, if we run the application and hit the endpoint as shown below, we have published an message to the topic.
 
Now, if we check the logs from the console, it should print the message which was sent to the publish endpoint as seen below.



