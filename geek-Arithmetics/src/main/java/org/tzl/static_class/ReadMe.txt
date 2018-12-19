	static synchronized 和 synchronized的区别
	
	synchronized基本原则
	1：当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
	      其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
	      
	2：当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
	       其他线程仍然可以访问“该对象”的非同步代码块。
	       
	3：当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
	       其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
	       
	synchronized(this)中的this是指“当前的类对象”，即synchronized(this)所在的类对应的当前对象。它的作用是获取“当前对象的同步锁”。


	4、实例锁和全局锁
synchronized(this)  类锁
synchronized(Object.Class) 对象锁


	实例锁 -- 锁在某一个实例对象上。如果该类是单例，那么该锁也具有全局锁的概念。实例锁对应的就是synchronized关键字。
	全局锁 -- 该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。全局锁对应的就是static synchronized（或者是锁在该类的class或者classloader对象上）。

	关于“实例锁”和“全局锁”有一个很形象的例子：

	pulbic class Something {
	    public synchronized void isSyncA(){}
	    public synchronized void isSyncB(){}
	    public static synchronized void cSyncA(){}
	    public static synchronized void cSyncB(){}
	}
	
	假设，Something有两个实例x和y。分析下面4组表达式获取的锁的情况。
	(01) x.isSyncA()与x.isSyncB() 
	(02) x.isSyncA()与y.isSyncA()
	(03) x.cSyncA()与y.cSyncB()
	(04) x.isSyncA()与Something.cSyncA()
	
	
	
	(1):  不能被同时访问。因为isSyncA()和isSyncB()都是访问同一个对象(对象x)的同步锁！
	
	(2):  可以同时被访问。因为访问的不是同一个对象的同步锁，x.isSyncA()访问的是x的同步锁，而y.isSyncA()访问的是y的同步锁。
	
	(3):  不能被同时访问。在Something.java类中加入两个静态方法cSyncA()和cSyncB()，
			因为cSyncA()和cSyncB()都是static类型，x.cSyncA()相当于Something.cSyncA()，
			y.cSyncB()相当于Something.cSyncB()，因此它们共用一个同步锁，不能被同时访问。
			
	(4):   可以被同时访问。因为isSyncA()是实例方法，x.isSyncA()使用的是对象x的锁；而cSyncA()是静态方法，
			Something.cSyncA()可以理解对使用的是“类的锁”。因此，它们是可以被同时访问的。

