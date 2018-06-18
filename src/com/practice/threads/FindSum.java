package com.practice.threads;

import com.practice.file_io.sum.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Given a large number of files N, with numbers inside these files
 * Find total sum of all the numbers in all files.
 * Use multithreading here. Waiting for reading to be done is expensive
 *
 */
public class FindSum {
    public static long getSum(List<String> files) {
        long sum = 0;
        Semaphore sem = new Semaphore(1);
        ExecutorService service = Executors.newFixedThreadPool(2);//Seems to be slower when adding more threads. Is it because overhead?
        List<Callable<Long>> list = new ArrayList<>();
        for(String s : files) {
            Callable<Long> task = () ->
            {
                //sem.acquire();
                String name = Thread.currentThread().getName();
                System.out.println("Starting " +s + " " + name);
                long ans = ReadFile.readFile(s);
                System.out.println("Ending " +s + " " + name);
                //sem.release();

                return ans;
            };
            list.add(task);
        }
        try {
            List<Future<Long>> resp = service.invokeAll(list);//This is what starts the execution of tasks.
            for(Future fut : resp) {
                sum+= (Long)fut.get();//I'll have all of my code by the time I'm here
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdownNow();

        return sum;
    }
}
