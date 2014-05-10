package com.javarush.test.level26.lesson05.task01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Для того, чтобы усовершенствовать ум, надо больше размышлять, чем заучивать.
Расставьте volatile там, где необходимо
*/
public class Solution extends Thread {
    public static final String DEFAULT_JAVARUSH_THREAD_NAME = "JavaRushThread";

    private static final AtomicInteger createdThreadIndex = new AtomicInteger();
    private static final AtomicInteger aliveThreadIndex = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    private static volatile boolean debugLifecycle = false;

    public Solution(Runnable runnable) {
        this(runnable, DEFAULT_JAVARUSH_THREAD_NAME);
    }

    public Solution(Runnable runnable, String name) {
        super(runnable, name + "-" + createdThreadIndex.incrementAndGet());

        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                log.log(Level.SEVERE, "An error occurred in thread " + t.getName(), e);
            }
        });
    }

    public static void main(String[] args) {
        new Solution(new Runnable() {
            @Override
            public void run() {
                System.out.println("test JavaRush Runnable for Solution class");
            }
        }).start();


        new Solution(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Oops");
            }
        }).start();
    }

    public void run() {
        boolean debug = debugLifecycle;
        if (debug) {
            log.log(Level.FINE, "Created " + getName());
        }
        try {
            aliveThreadIndex.incrementAndGet();
            super.run();
        } finally {
            aliveThreadIndex.decrementAndGet();
            if (debug) {
                log.log(Level.FINE, "Exiting " + getName());
            }
        }
    }
}
