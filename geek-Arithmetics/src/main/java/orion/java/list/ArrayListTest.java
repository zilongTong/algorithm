/*
package orion.java.list;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

*/
/**
 *
 *//*

public class ArrayListTest {

	private List<String> testList = new ArrayList<>();
	private String filePath = "E:/java/arrayListTest.temp";
	@Before
	public void init() {
		testList.add("11111111");
		testList.add("2222222");
		testList.add("333333333");
	}
	@Test
	public void testWrite() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
		oos.writeObject(testList);
	}

	@Test
	public void testRead() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
		@SuppressWarnings("unchecked")
		List<String> result = (List<String>) ois.readObject();
		System.out.println(result);
	}
}
*/
