# java-concurrency

###Threads 
* It is the smallest independent unit of a program that can be managed independently by a scheduler.
* In Java, all the programs have at least one thread, known as the main thread, that is provided by the JVM.
* The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.
* Java threads are objects like any other Java objects, threads are instances of class java.lang.Thread, or instances of subclasses of this class.
* Java threads can also execute code.

###Creating threads in Java
* A thread in Java can be created in the following two ways:
  * Extending java.lang.Thread class
  >public class MyThread extends Thread {  
  &nbsp;&nbsp;@Override  
  &nbsp;&nbsp;public void run(){  
  &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("This thread is running...");  
  &nbsp;&nbsp;}  
  &nbsp;&nbsp;public static void main(String[] args) {  
  &nbsp;&nbsp;&nbsp;&nbsp;MyThread obj = new MyThread();  
  &nbsp;&nbsp;&nbsp;&nbsp;obj.start();  
  &nbsp;&nbsp;&nbsp;&nbsp;}  
  &nbsp;&nbsp;}  
   
  * Implementing Runnable interface
  >public class MyThread implements Runnable {  
  &nbsp;&nbsp;@Override  
  &nbsp;&nbsp;public void run(){  
  &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("This thread is running...");  
  &nbsp;&nbsp;}  
  &nbsp;&nbsp;public static void main(String[] args) {  
  &nbsp;&nbsp;&nbsp;&nbsp;Thread obj = new Thread(new MyRunnable());  
  &nbsp;&nbsp;&nbsp;&nbsp;obj.start();  
  &nbsp;&nbsp;&nbsp;&nbsp;}  
  &nbsp;&nbsp;}
   
###There are 4 stages in the lifecycle of a thread, as given below:
* New - As we use the Thread class to construct a thread entity.
* Runnable - When a new thread's start() function is called, it enters a runnable state.
* Running - Running implies that the processor (CPU) has assigned a time slot to the thread for execution.
* Blocked - When the thread is alive, but it cannot be selected for execution by the scheduler.
* Dead - When a thread's run() function ends the execution of sentences, or when the stop() function is invoked.

###Java Thread Priorities
* Any thread spawned in the JVM has a priority that scale runs from 1 to 10 (lowest to highest).
* The main thread's priority and its children are set to 5 by default.
* The priority of any thread can be adjusted, whether it is the main thread or a user-defined thread. 