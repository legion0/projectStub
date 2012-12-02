/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author legion
 */
public class ProductFactory {
	
	private static final DefaultMutableTreeNode ROOT = new DefaultMutableTreeNode(ProdA.class);

	static <T extends ProdA> void register(Class<? extends T> aClass, Class<T> parentClass) throws NoSuchMethodException {
		aClass.getMethod("accepts", parentClass); // test Method Exists
		Enumeration<DefaultMutableTreeNode> enumi = ROOT.breadthFirstEnumeration();
		while (enumi.hasMoreElements()) {
			DefaultMutableTreeNode parent = enumi.nextElement();
			if (parent.getUserObject().toString().equals(parentClass.toString())) {
				parent.add(new DefaultMutableTreeNode(aClass));
				break;
			}
		}
	}
	
	public ProductI getProduct(String arg) {
		ProductI prod = new ProdA(arg);
		try {
			
			Enumeration<DefaultMutableTreeNode> enumi = ROOT.children();
			while (enumi.hasMoreElements()) {
				DefaultMutableTreeNode treeNode = enumi.nextElement();
				Class<? extends ProdA> aClass = (Class<? extends ProdA>)treeNode.getUserObject();
				Method tester = aClass.getMethod("accepts", prod.getClass());
				boolean accepts = (Boolean)tester.invoke(aClass, prod);
				System.out.println("Trying: " + aClass.toString());
				if (accepts) {
					enumi = treeNode.children();
					Constructor<?> constructor = aClass.getConstructor(ProdA.class);
					prod = (ProductI)constructor.newInstance(prod);
				}
				System.out.println("Children: " + enumi.hasMoreElements());
			}
		} catch (NoSuchMethodException e) {
			// TODO: 
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO: 
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO: 
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO: 
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO: 
			e.printStackTrace();
		}
		return prod;
	}

}
