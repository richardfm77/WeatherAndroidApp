package com.developers.weatherappservice.repositories;

import org.springframework.stereotype.Repository;

import java.util.Hashtable;

/**
 * Class for implementation a cache.
 * @param <K> key to save an object.
 * @param <V> the objet to save.
 * */
@Repository
public class Cache<K,V> extends Hashtable<K,V> implements Runnable {

    /**
     * Parameter of cache.
     * */
    private boolean active = true;

    /**
     * Build a cache.
     * */
    public Cache() {
        super();
        start();
    }

    /**
     * Start a thread for implementation
     * a chronometer.
     * */
    private void start() {
        Thread thread = new Thread(this);
        thread.start();
        System.out.println("Start cache.");
    }

    @Override
    public V get(Object key) {
        System.out.println("Cache working");
        return super.get(key);
    }

    /**
     * Run the chronometer.
     * Clear the cache after at time.
     * */
    @Override
    public void run() {
        while (active) {
            try {
                Thread.sleep(1800000);
                this.clear();
                System.out.println("Clear cache.");
            } catch (InterruptedException in) {
                System.err.println("Error interrupted cache.");
            }
        }
    }

    /**
     * Set the parameter active.
     * */
    public void setActive(boolean active) {
        this.active = active;
    }
}
