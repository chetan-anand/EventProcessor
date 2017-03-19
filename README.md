# EventProcessor
This repo contains the two roads interview project

Steps to test  the implementation.
------------------------------------------

1. Downlaod the kafkal 10 version from this link https://www.apache.org/dyn/closer.cgi?path=/kafka/0.10.2.0/kafka_2.11-0.10.2.0.tgz;

2. Untar it and go to the bin floder and start the zookeeper.
 $ bin/zookeeper-server-start.sh config/zookeeper.properties
 
3. Simlarly start the kafka brokerm by the following command.
Before starting kafka broker, change the num.partitions to some positive integer. like i have done 5.
$ bin/kafka-server-start.sh config/server.properties

4. Now in the project file go to TestProduce.java in kafka-produce folder
This will start a test sale reciept producer.
Go to its Constant.java file to change its settings.

5. Now is the time to start the event processer. Go to ProcessorStart.java in event-processor-main folder
This will start the event processor and output the results as and when processed.
GO to its Constant.java file to change its settings.
