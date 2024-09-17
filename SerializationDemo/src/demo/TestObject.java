package demo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObject {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		
		PurchaseOrder po=new PurchaseOrder("1234","Dell",100,900000);
		
		FileOutputStream fos=new FileOutputStream("pofile.dat");
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		oos.writeObject(po);
		
		
		FileInputStream fis=new FileInputStream("pofile.dat");
		ObjectInputStream iis=new ObjectInputStream(fis);
		Object obj=iis.readObject();
		PurchaseOrder ref= (PurchaseOrder) obj;
		System.out.println(ref);

	}

}
