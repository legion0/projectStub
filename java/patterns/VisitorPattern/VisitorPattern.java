import products.ProdA;
import products.ProductI;
import visitors.GetProductClassNameVisitor;

/**
 *
 * @author legion
 */
public class VisitorPattern {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ProductI prod = (ProductI) new ProdA();
		GetProductClassNameVisitor visitor = new GetProductClassNameVisitor();
		prod.accept(visitor);
		System.out.println(visitor.getClassName());
	}
}
