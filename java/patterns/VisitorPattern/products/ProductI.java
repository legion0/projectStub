/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

/**
 *
 * @author legion
 */
public interface ProductI {
	public abstract void accept(ProductVisitorI visitor);
}
