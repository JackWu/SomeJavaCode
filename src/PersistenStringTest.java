
public class PersistenStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersistentString x = new PersistentString("914bbs.txt", "test.txt");
		x.persist();
		System.out.println(x.getLength());

	}

}
