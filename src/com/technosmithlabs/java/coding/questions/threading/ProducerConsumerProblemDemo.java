package com.technosmithlabs.java.coding.questions.threading;

public class ProducerConsumerProblemDemo {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumerOne = new Consumer(producer);
        Consumer consumerTwo = new Consumer(producer);
        Thread producerThread = new Thread(producer);
        Thread consumerOneThread = new Thread(consumerOne);
        Thread consumerTwoThread = new Thread(consumerTwo);
        consumerOneThread.start();
        consumerTwoThread.start();
        producerThread.start();
    }
}

class Producer implements Runnable {

    private StringBuffer stringBuffer = new StringBuffer();
    private static final String[] WORDS = {"Hello", "this", "is", "Anshul", "this side"};

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    @Override
    public void run() {
        synchronized (stringBuffer) {
            for (int i = 0; i < WORDS.length; i++) {
                stringBuffer.append(WORDS[i]).append(" ");
            }
            System.out.println("Producing completed");
            stringBuffer.notifyAll();
        }
    }
}

class Consumer implements Runnable {
    private Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        synchronized (producer.getStringBuffer()) {
            try {
                producer.getStringBuffer().wait();
                System.out.println(Thread.currentThread().getName() + " Consumer consuming the value generated from producer");
                System.out.println(producer.getStringBuffer());
                System.out.println("Consuming completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
