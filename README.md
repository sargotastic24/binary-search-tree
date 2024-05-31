# binary-search-tree

Spell Checker with Binary Search Tree

This project implements a spell checker application that verifies words in a document against a provided dictionary.

Problem

The goal is to create an efficient spell checker for documents. A crucial factor in achieving efficiency is a well-structured mechanism for storing and searching the dictionary. In this implementation, we leverage two key strategies:

- Sorted Dictionary: The dictionary, consisting of a list of strings, is maintained in sorted order to facilitate efficient search using binary search.
- Binary Search Tree (BST): The dictionary is also stored within a BST data structure, enabling potentially very fast operations like insertion, deletion, and search.

Requirements

This project requires the development of several classes:

1) SortedSet Interface (Provided): This interface defines the essential operations for a sorted set, which your BinarySearchTree class will implement.

2) BinarySearchTree Class: This class represents a generic BST data structure. It includes a node class (not explicitly shown here) and offers methods for various set operations.
Consider including a method to generate a visual representation of the BST in DOT format for debugging and visualization purposes.

3) SpellChecker Class: This class manages the spell-checking process. It loads the dictionary and document, processes the document line by line, checks each word against the dictionary using the BST, and reports potential spelling errors. Existing methods should not be modified.

4) SpellCheckerDemo Class: This class demonstrates usage of the SpellChecker class. It's intended as a starting point for running your implementation but isn't a comprehensive tester. Create separate classes for thorough testing.

Implementation Notes

- The BinarySearchTree should be generic to accommodate various data types as keys.
- The dictionary should treat strings as case-insensitive, considering "tree," "Tree," and "TREE" as identical words.


Usage

- Refer to the SpellCheckerDemo class for a basic example of using the SpellChecker class.
- Create comprehensive testing classes to validate the functionality of the BinarySearchTree and SpellChecker implementations.


Provided Files

- SortedSet.java (interface)
- SpellChecker.java (partially implemented)
- SpellCheckerDemo.java (demonstration class)
- dictionary.txt (sample dictionary)
- hello_world.txt (sample document)
- good_luck.txt (sample document)
