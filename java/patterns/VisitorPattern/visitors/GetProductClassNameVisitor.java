/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visitors;

import products.ProdA;
import products.ProdB;
import products.ProductVisitorI;

/**
 *
 * @author legion
 */
public class GetProductClassNameVisitor implements ProductVisitorI {

	private String className = null;

	public String getClassName() {
		return className;
	}

	@Override
	public void visit(ProdA e) {
		className = "ProdA";
	}

	@Override
	public void visit(ProdB e) {
		className = "ProdB";
	}

}
