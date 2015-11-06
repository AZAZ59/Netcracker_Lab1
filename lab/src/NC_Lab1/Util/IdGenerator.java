package NC_Lab1.Util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by azaz on 06/11/15.
 */
public class IdGenerator {
    private static IdGenerator ourInstance = new IdGenerator();
    //private long counter=0;
    private AtomicLong counter = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return ourInstance;
    }

    public long GetNextId() {
        return counter.addAndGet(1);
    }
}
