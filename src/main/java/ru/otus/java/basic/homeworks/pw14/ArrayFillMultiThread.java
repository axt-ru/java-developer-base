package ru.otus.java.basic.homeworks.pw14;

public class ArrayFillMultiThread {
    public static void main(String[] args) {
        final int size = 100_000_000;
        double[] array = new double[size];
        Thread[] threads = new Thread[4];

        long startTime = System.currentTimeMillis();

        for (int t = 0; t < 4; t++) {
            final int start = t * (size / 4);
            final int end = (t + 1) * (size / 4);
            threads[t] = new Thread(() -> {
                for (int i = start; i < end; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });
            threads[t].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения в четырёх потоках: " + (endTime - startTime) + " ms");
    }
}
