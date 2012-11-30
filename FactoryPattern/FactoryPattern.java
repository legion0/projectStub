import products.ProductFactory;

/**
 *
 * @author legion
 */
public class FactoryPattern {

	static {
		try {
			// Force Register of classes
			Class.forName("products.ProdAB");
			Class.forName("products.ProdABC");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ProductFactory pf = new ProductFactory();
		System.out.println(pf.getProduct("ProdABC").toString());
	}
}
