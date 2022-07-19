class NewThread implements Runnable
{
	Thread t;
	String tname;
	public NewThread(String tname) {
		this.tname=tname;
		t=new Thread(this,this.tname);
		t.start();
	}
	public void run() {
		try {
			for(int i=0;i<5;i++)
			{
				System.out.println(t+" : "+i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Child Thread Exiting");
	}
}
public class ThreadDemo {

	public static void main(String[] args) {
		new NewThread("One");
		new NewThread("Two");
		new NewThread("Three");
		Thread t=Thread.currentThread();
		System.out.println("Current Thread : "+t);
		t.setName("My Thread");
		System.out.println("After Name Change : "+t);
		t.setPriority(3);
		System.out.println("After Priority Change : "+t);
		
		try {
			for(int i=0;i<5;i++)
			{
				System.out.println(t+" : "+i);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread Exiting");
	}
}
