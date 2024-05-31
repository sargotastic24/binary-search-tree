/*
 * @author Sarthak Goyal
 * @version March 18th, 2019
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	LinkedList<Type> q = new LinkedList<Type>();
	private BinaryNode<Type> rootNode = null;
	
	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually inserted); otherwise, returns false
	 */
	@Override
	public boolean add(Type item) {
		if(rootNode == null) {
			rootNode = new BinaryNode<Type>(item);
			return true;
		}	
		return recursiveAdd(rootNode, item);	
	}
	
	/*
	 * A helper method( for add() ) to use recursion to add an element.
	 */
	private boolean recursiveAdd(BinaryNode<Type> n, Type item)
	{
		if(item.compareTo(n.element) < 0) {
			if(n.left == null) { 
				n.left = new BinaryNode<Type>(item);
				q.add(item);
				return true;
			}
			else {
				recursiveAdd(n.left, item);
			}
		}
		
		if(item.compareTo(n.element) > 0) {
			if(n.right == null) {
				n.right = new BinaryNode<Type>(item);
				return true;
			}
			else {
				recursiveAdd(n.right, item);
			}
		}
		return false;
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually inserted); otherwise,
	 *         returns false
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) { //case if duplicates?
		boolean flag = false;
		for(Type i : items) {
			if(this.add(i)) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() {
		rootNode = null;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input item;
	 *         otherwise, returns false
	 */
	@Override
	public boolean contains(Type item) {
		if(rootNode == null) {
			return false;
		}
		return recursiveContains(rootNode, item);
	}

	/*
	 * A helper method( for contains() ) to use recursion to find an element.
	 */
	private boolean recursiveContains(BinaryNode<Type> n, Type item) {
		if(item.compareTo(n.element) == 0) {
			return true;
		}
		
		else if(item.compareTo(n.element) < 0) {
			if(n.left == null) {
				return false;
			}
			else {
				return recursiveContains(n.left, item);
			}
		}
		else {
			
		 if(n.right == null) {
				return false;
			}
			else {
				return recursiveContains(n.right, item);
			}
		}
	}
	
	/**
	 * Determines if for each item in the specified collection, there is an item in
	 * this set that is equal to it.
	 * 
	 * @param items - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an item
	 *         in this set that is equal to it; otherwise, returns false
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		Boolean flag = false;
		for(Type i : items) {
			if(this.contains(i)) {
				flag = true;
			}
			else {
				return false;
			}
		}
		return flag;
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public Type first() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The tree is empty");
		}
		
		BinaryNode<Type> temp = rootNode;
		while(temp.left != null) {
			temp = temp.left;
		}
		Type temp2 = temp.element;
		return temp2;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		return rootNode == null;
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public Type last() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The tree is empty");
		}	
		if(rootNode.right == null) {
			return rootNode.element;
		}
		else {
			BinaryNode<Type> temp = rootNode;
			while(temp.right != null) {
				temp = temp.right;
			}
			Type temp2 = temp.element;
			return temp2;
		}
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually removed); otherwise, returns false
	 */
	@Override
	public boolean remove(Type item) {
		 if (rootNode == null) {
	        return false; 
	     }
		BinaryNode<Type> n = deleteRecursive(rootNode, item);
		return n != null;
	}
	
	/*
	 * A Helper Method for remove() it uses recursion to find the Node 
	 * then it deletes it and attaches the remaining nodes to the new parent node.
	 */
	public BinaryNode<Type> deleteRecursive(BinaryNode<Type> root, Type data) 
    { 
		if(root == null) {
			return root;
		}
		 
        if(data.compareTo(root.element) < 0) {
            root.left = deleteRecursive(root.left, data);
        } 
        else if(data.compareTo(root.element) > 0) {
            root.right = deleteRecursive(root.right, data);
        } 
        else {
            if(root.left == null && root.right == null) {
                return null;
            } 
            else if(root.left == null) {
                return root.right;
            } 
            else if(root.right == null) {
                return root.left;
            }
            else {
                Type minValue = minValue(root.right);
                root.element = minValue;
                root.right = deleteRecursive(root.right, minValue);
            }
        }
        return root;
    } 
	
	/*
	 * returns the smallest element in the right subtree
	 * A further helper method for deleteRecursive()
	 * @return: returns the smallest value on the right side of the tree.
	 */
	public Type minValue(BinaryNode<Type> n) 
    { 
        Type minvalue = n.element; 
        while(n.left != null) 
        { 
           minvalue = n.left.element; 
           n = n.left; 
        } 
        return minvalue; 
    } 

	/**
	 * Ensures that this set does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually removed); otherwise,
	 *         returns false
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		Boolean flag = false;
		for(Type i : items) {
			flag = remove(i) || flag;
		}
		return flag;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() {
		if(rootNode == null) {
			return 0;
		}
		else if(rootNode.left == null && rootNode.right == null) {
			return 1;
		}
		else {
			return sizeRecursive(rootNode);
		}
	}
	
	/*
	 * A helper method for size() it traverses the tree and keeps count of the number of nodes
	 * @return: the final int count of the total number of nodes in the tree (including root Node).
	 */
	public int sizeRecursive(BinaryNode<Type> n) {
		int count = 1;
	    if (n.left != null) {
	       count += sizeRecursive(n.left);
	    }
	    if (n.right != null) {
	        count += sizeRecursive(n.right);
	    }
	    return count;
	}
	
	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order. (in-order traversal).
	 */
	@Override
	public ArrayList<Type> toArrayList() {
		ArrayList<Type> a = new ArrayList<Type>();
		if(rootNode == null) {
			return a;
		}
		 return printInOrder(rootNode, a);
	}
	
	/*
	 * A helper method for toArrayList(), it recursively calls itself to fill the ArrayList with the nodes
	 * in a in-order traversal (Left, Node, Right).
	 * @return: returns the ArrayList with the elements in a in-order traversal order.
	 */
	public ArrayList<Type> printInOrder(BinaryNode<Type> n, ArrayList<Type> a) 
    {
		 if (n == null) {
		      return a;
		 }
		 printInOrder(n.left, a);
		 a.add(n.element);
		 printInOrder(n.right, a);
		 if(a.size() == size()) {
		    return a;
		 }
		 return a;
	} 
}