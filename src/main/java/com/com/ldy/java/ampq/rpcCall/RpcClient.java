package com.com.ldy.java.ampq.rpcCall;

import com.cedarsoftware.util.StringUtilities;
import com.com.ldy.java.ampq.helloworlexample.HelloworldProducer;
import com.rabbitmq.client.*;
import org.apache.http.util.TextUtils;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * Created by liudeyu on 2019/10/25.
 */
public class RpcClient {


    public int getRpcFabResult(int tmp) throws IOException, TimeoutException, InterruptedException {
        String UUID = java.util.UUID.randomUUID().toString();
        ConnectionFactory factory = HelloworldProducer.rabbitmqbasicCon();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String replyDefaultChannel = channel.queueDeclare().getQueue();
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .correlationId(UUID)
                .replyTo(replyDefaultChannel)
                .build();

        channel.basicPublish("", RpcServer.QUEUE_RPC, properties, String.valueOf(tmp).getBytes(
                "utf8"
        ));

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(1);
        String tag = channel.basicConsume(replyDefaultChannel, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (StringUtilities.equals(properties.getCorrelationId(), UUID)) {
                    blockingQueue.offer(NumberUtils.parseNumber(new String(body, "utf8"), Integer.class));
                }
            }
        });
        Integer res = blockingQueue.take();
        channel.basicCancel(tag);
        return res;
    }


    public static void main(String[] argv) {

        RpcClient rpcClient=new RpcClient();
        for (int i=1;i<30;i++){
            try {
                System.out.println(String.format("rpc ,%d ,fab result is %d", i,rpcClient.getRpcFabResult(i)));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
