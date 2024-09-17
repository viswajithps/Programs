
package first;

public class First {
	
	Runnable r =new Runnable() {
		public void run() {
			System.out.println("from run method");
		}
	};
	
	
	{
	Runnable r1=()->{
		System.out.println("From run method");
	};
     r1.run();
	}
	
	
	
	
	
	
	
}
