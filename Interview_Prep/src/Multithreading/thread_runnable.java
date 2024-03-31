package Multithreading;

class childthread1 implements Runnable
{

	public void run()
	{
		System.out.println("---");
		try
		{
		for(int i = 5; i >=0 ; i--)
		{
			System.out.println(Thread.currentThread().getName());
			
			Thread.sleep(500);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

class createThread 
{3
	Thread child;
	public createThread(childthread1 ct1) {
		
		child =new Thread(ct1, "childthread");
		child.start();
		child.setName("prajakta");
		child.setPriority(Thread.MAX_PRIORITY);
	}
}

public class thread_runnable {

	public static void main(String[] args) {
		childthread1 ct1= new childthread1();
		createThread ct = new createThread(ct1);
	}
}
