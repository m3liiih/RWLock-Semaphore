import java.util.concurrent.Semaphore;

class ReadWriteLock {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore writeLock = new Semaphore(1);  // exclusive write access
    private int readCount = 0;  // active reader count
    
    // acquire read lock
    public void readLock() {
        try {
            mutex.acquire();
            readCount++;
            if (readCount == 1) {
                writeLock.acquire();
            }
            mutex.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // acquire write lock
    public void writeLock() {
        try {
            writeLock.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // release read lock
    public void readUnLock() {
        try {
            mutex.acquire();
            readCount--;
            if (readCount == 0) {
                writeLock.release();
            }
            mutex.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // release write lock
    public void writeUnLock() {
        writeLock.release();
    }
}