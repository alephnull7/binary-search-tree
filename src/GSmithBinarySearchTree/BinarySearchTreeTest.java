// Programmer: Gregory Smith
// Date: 06/13/2022
// Program: Binary Search Tree
// References: Building Java Programs, 5th Edition: Chapters 1-17
// Purpose: Demonstrate the BinarySearchTree class
// IDE: IntelliJ

package GSmithBinarySearchTree;
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        // Integer tree
        System.out.println("We can use the generic binary tree to make an Integer tree");
        BinarySearchTree<Integer> IntegerTree = new BinarySearchTree<>();
        IntegerTree.add(7);
        IntegerTree.add(3);
        IntegerTree.add(172);
        IntegerTree.add(52);
        IntegerTree.add(1);
        IntegerTree.add(4);
        IntegerTree.add(220);
        IntegerTree.add(550);
        IntegerTree.add(770);
        IntegerTree.add(551);
        IntegerTree.printSideways();
        System.out.println();

        System.out.println("We can \"replace\" values in the tree (sequential remove and add)");
        IntegerTree.replace(7, -1);
        IntegerTree.printSideways();
        System.out.println();
        System.out.println("We test to see if the tree contains a value that we know we added");
        System.out.println(IntegerTree.contains(52));
        System.out.println();

        // String tree
        System.out.println("We can also make a String tree");
        BinarySearchTree<String> StringTree = new BinarySearchTree<>();
        StringTree.add("IntegerTree");
        StringTree.add("Ashley");
        StringTree.add("Stuart");
        StringTree.printSideways();
        System.out.println();

        // PhoneBookEntry tree
        System.out.print("We can make a tree of any Object class that has Comparable implemented,");
        System.out.println("like PhoneBookEntry");
        BinarySearchTree<PhoneBookEntry> PhoneBookTree = new BinarySearchTree<>();
        PhoneBookTree.add(new PhoneBookEntry("IntegerTree", "Stewart", "123 Main Street", "Bellingham", "WA", 360, 7654321));
        PhoneBookTree.add(new PhoneBookEntry("Franklin", "Smith", "321 Main Street", "Bellingham", "WA", 206, 1234567));
        PhoneBookTree.add(new PhoneBookEntry("Roger", "Jobs", "777 Fancy Drive", "Seattle", "WA", 360, 1112222));
        PhoneBookTree.add(new PhoneBookEntry("Person", "Guy", "777 Fancy Drive", "Spokane", "WA", 360, 1112222));
        PhoneBookTree.add(new PhoneBookEntry("Abraham", "Zeebo", "777 Fancy Drive", "Olympia", "WA", 360, 1112222));
        PhoneBookTree.add(new PhoneBookEntry("Cameron", "Stewart", "777 Fancy Drive", "Tacoma", "WA", 360, 1112222));
        PhoneBookTree.add(new PhoneBookEntry("Rashif", "Rahman", "777 Fancy Drive", "Portland", "OR", 360, 1112222));
        PhoneBookTree.printSideways();
        System.out.println();

    } // end of main

} // end of BinarySearchTreeTest
