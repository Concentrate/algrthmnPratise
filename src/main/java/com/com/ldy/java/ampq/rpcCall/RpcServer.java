package com.com.ldy.java.ampq.rpcCall;

import com.com.ldy.java.ampq.helloworlexample.HelloworldProducer;
import com.rabbitmq.client.*;
import org.springframework.util.NumberUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by liudeyu on 2019/10/24.
 */
public class RpcServer {

    public static final String QUEUE_RPC = RpcServer.class.getSimpleName();
    private int lastCall;

    private int cacluFaboFun(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }


    private int cacluFabRe(int n) {

        int[] note = new int[n + 1];
        note[0] = note[1] = 1;
        return cacluFabRecur(n, note);
    }

    private int cacluFabRecur(int n, int[] note) {
        if (note[n] != 0) {
            return note[n];
        }
        note[n] = cacluFabRecur(n - 1, note) + cacluFabRecur(n - 2, note);
        return note[n];
    }


    public void startRpcComputeServer() {
        ConnectionFactory factory = HelloworldProducer.rabbitmqbasicCon();
        try {
            Connection connection = factory.newConnection();

            Channel channel = connection.createChannel();
            channel.basicQos(1);
            channel.queueDeclare(QUEUE_RPC, false, false, false, null);
            channel.queuePurge(QUEUE_RPC);
            Object moniter = new Object();
            lastCall = 0;
            channel.basicConsume(QUEUE_RPC, true, new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                    String messgae = new String(body, "utf8");
                    int caclu = NumberUtils.parseNumber(messgae, Integer.class);
                    lastCall =caclu;
                    int result=cacluFaboFun(caclu);

                    channel.basicPublish("",properties.getReplyTo(),properties,String.valueOf(result).getBytes("utf8"));
                    synchronized (moniter){
                        moniter.notify();
                    }
                }
            });


            while (true) {
                synchronized (moniter) {
                    moniter.wait();
                    System.out.println("send callback there,one rpc result send,the last call is "+ lastCall);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] argv) {
        RpcServer rpcServer = new RpcServer();
        rpcServer.startRpcComputeServer();

    }
}
