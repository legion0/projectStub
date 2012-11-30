/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

/**
 *
 * @author legion
 */
public interface ProductVisitorI {
	public abstract void visit(ProdA prod);
	public abstract void visit(ProdB prod);
}
