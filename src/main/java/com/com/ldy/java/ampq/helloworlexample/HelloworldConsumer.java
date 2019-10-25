package com.com.ldy.java.ampq.helloworlexample;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by liudeyu on 2019/10/23.
 */
public class HelloworldConsumer {


    private String queueName;

    private com.rabbitmq.client.Channel channel;
    private final ConnectionFactory factory;

    public HelloworldConsumer(String queueName) {
        this.queueName = queueName;

        factory = HelloworldProducer.rabbitmqbasicCon();
        try {
            channel = factory.newConnection().createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }


    public void listenerMsg() throws IOException {
        channel.basicConsume(queueName, true, this.hashCode() + "", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body, "utf8"));
            }
        });
    }





    public static void main(String[] argv) {
        HelloworldProducer producer = new HelloworldProducer();
        producer.declardDefaultQueue();
        producer.sendDefaultQueueMsg("hello,world");
        String inputContent = "";
        HelloworldConsumer consumer=new HelloworldConsumer(producer
        .getDefaultQueueName());
        try {
            consumer.listenerMsg();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while ((inputContent = scanner.nextLine()) != null) {
              producer.sendDefaultQueueMsg(inputContent);
        }

    }


}
