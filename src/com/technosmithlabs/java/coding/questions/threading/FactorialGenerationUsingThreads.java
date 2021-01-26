package com.technosmithlabs.java.coding.questions.threading;

public class FactorialGenerationUsingThreads {

    public static void main(String[] args) {
        Thread threadOne = new Thread(new FactorialWorker(5));
        Thread threadTwo = new Thread(new FactorialWorker(5));
        threadOne.start();
        threadTwo.start();
    }

}

class FactorialWorker implements Runnable {

    private long number;

    public FactorialWorker(long number) {
        this.number = number;
    }

    @Override
    public void run() {
        long factorialResult = 1;
        for (int i = 1; i <= number; i++) {
            factorialResult = factorialResult * i;
        }
        System.out.println("The result of factorial is: " + factorialResult + " from Thread " + Thread.currentThread().getName());
    }
}
