package com.gk.array;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 *  calculate the sum of large dataset array element by parallely
 */
public class ArraySumByParallel {
    private int[] array;

    /**
     * @param len just initialize the array
     *            the array contains the values
     *            1, 2, 3... len
     */
    public ArraySumByParallel(int len) {
        array = new int[len];
        for (int index = 0; index < len; index++) {
            array[index] = index+1;
        }
    }

    private class ParallelWorker implements Callable<Integer> {
        int start;
        int end;
        Integer sum;
        // Note the start and end indexes for this worker
        ParallelWorker(int start, int end) {
            this.start = start;
            this.end = end;
            sum = 0;
        }


        /**
         *
         * @return each thread result
         * @throws Exception
         */
        @Override
        public Integer call() throws Exception {
            for (int index=start; index<end; index++) {
                sum += array[index];
            }
            return  sum;
        }
    }


    /****
     *  this will creates the callable list then gives it to executor service to execute it parallely and get the list of future objects
     */
    public void runParallel() throws ExecutionException, InterruptedException {
        int numWorkerTHreads = 10;   // no of threads
        // Make and start all the workers, keeping them in a list.
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(numWorkerTHreads);
        int chunkSize = numWorkerTHreads + 2;   // 12 chunks
        int rest = array.length % chunkSize;
        int chunks = array.length / chunkSize + (rest > 0 ? 1 : 0);
        int[][] arrays = new int[chunks][];
        Integer sum = 0;
        for(int i = 0; i < (rest > 0 ? chunks - 1 : chunks); i++){
            // this copies 'chunk' times 'chunkSize' elements into a new array
            arrays[i] = Arrays.copyOfRange(array, i * chunkSize, i * chunkSize + chunkSize);
            Callable<Integer> callable = new ParallelWorker(i * chunkSize, i * chunkSize + chunkSize);
            ScheduledFuture<Integer> schedule = executorService.schedule(callable, 1, TimeUnit.MICROSECONDS);
            sum = sum+schedule.get();
        }
        if(rest > 0){ // only when we have a rest
            // we copy the remaining elements into the last chunk
            arrays[chunks - 1] = Arrays.copyOfRange(array, (chunks - 1) * chunkSize, (chunks - 1) * chunkSize + rest);
            Callable<Integer> callable = new ParallelWorker((chunks - 1) * chunkSize, (chunks - 1) * chunkSize + rest);
            ScheduledFuture<Integer> schedule = executorService.schedule(callable, 1, TimeUnit.MICROSECONDS);
            sum = sum+schedule.get();
        }
        executorService.shutdown();
        /**
         * print sum of all worker threads
         */
        System.out.println( "sum of array:" + sum+ " \t workers threads:" + numWorkerTHreads);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // command line argument: array_length
        Integer len = Integer.parseInt(args[0]);
        int sum = 0;
//        for(int index=1; index<=10000000; index++)
//            sum = sum + index;
        //System.out.println("sum="+sum);
        if(len > 9) {
            ArraySumByParallel at = new ArraySumByParallel(len);
            at.runParallel();
        }else{
            System.out.println("Invalid array length, it should be greater than or equal to thread pool size which 10");
        }

    }

}
