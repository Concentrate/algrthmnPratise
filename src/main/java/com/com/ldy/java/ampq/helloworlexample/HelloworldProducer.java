package com.com.ldy.java.ampq.helloworlexample;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by liudeyu on 2019/10/23.
 */
public class HelloworldProducer {


    public static final String HELLO_WORLD_QUEUE = "hello_world_queue";

    private Channel channel;
    private ConnectionFactory connectionFactory;

    public HelloworldProducer() {

        rabbitmqbasicCon();
        connectionFactory = rabbitmqbasicCon();
        try {
            channel = connectionFactory.newConnection().createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory rabbitmqbasicCon() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    public void declareAQueue(String name) {
        try {
            channel.queueDeclare(name, true
                    , false, false, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendQueueMessageDirect(String queqe, String msg) {
        try {
            channel.basicPublish("", queqe, null, msg.getBytes("utf8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void declardDefaultQueue() {
        declareAQueue(this.getClass().getName());
    }


    public void sendDefaultQueueMsg(String msg) {
        sendQueueMessageDirect(this.getClass().getName(), msg);
    }


    public String getDefaultQueueName() {
        return this.getClass().getName();
    }


}
