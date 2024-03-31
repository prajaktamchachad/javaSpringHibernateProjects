package Multithreading;

class childThread extends Thread
{
	public childThread() {
		
		super("demochild");
		start();
	}


public void run()
{
	try {
		
		for(int i = 0 ; i < 5 ; i ++)
		{
			System.out.println(Thread.currentThread().getName()+"--"+i);
			Thread.sleep(500);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

public class create_thread {

	public static void main(String[] args) {
		childThread ct = new childThread();
	}
}
