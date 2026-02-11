# Read–Write Lock Implementation (Java)

## Overview
This project implements a **custom Read–Write Lock** mechanism in Java using `Semaphore`.  
It manages concurrent access to a shared resource by allowing **multiple readers simultaneously** while ensuring **exclusive access for writers**.

Originally developed as part of concurrency and operating systems practice, it has been organized into a standalone repository for demonstration and learning purposes.

---

## Key Concepts
- **Multiple concurrent readers** are allowed.
- **Writers have exclusive access** to the shared resource.
- **Synchronization is handled using semaphores:**
  - `mutex` semaphore: protects the reader count
  - `writeLock` semaphore: ensures exclusive write access

---

## How It Works

### Read Lock
1. A reader acquires the `mutex` and increments the reader count.  
2. The **first reader blocks writers** by acquiring the `writeLock`.  
3. Multiple readers can access the resource concurrently.

### Write Lock
1. A writer acquires the `writeLock` directly.  
2. During writing, **no readers or other writers can access** the resource.

### Unlocking
- Readers decrement the reader count.  
- The **last reader releases the `writeLock`**.  
- Writers release the `writeLock` after completing their operation.

---

## Technologies Used
- Java  
- `java.util.concurrent.Semaphore`  
- Multithreading & synchronization primitives

---

## Possible Improvements

- Add fairness control to prevent writer starvation
- Implement timeout-based lock acquisition
- Add unit tests and usage examples
