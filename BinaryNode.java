/*
 * @author Sarthak Goyal
 * @version March 18th, 2019
 */

	public class BinaryNode<Type extends Comparable<? super Type>> {

		public Type element;

		public BinaryNode<Type> left; 

		public BinaryNode<Type> right;

		/**
		 * Creates a binary node with left and right nodes as children.
		 * 
		 * @param element - data stored at this node
		 * @param left    - left child node
		 * @param right   - right child node
		 */
		public BinaryNode(Type element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}
	}		
