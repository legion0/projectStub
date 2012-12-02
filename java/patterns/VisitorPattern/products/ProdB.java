/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

/**
 *
 * @author legion
 */
public class ProdB implements ProductI {
	@Override
	public void accept(ProductVisitorI visitor) {
		visitor.visit(this);
	}
}
