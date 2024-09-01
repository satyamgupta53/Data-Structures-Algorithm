package LinkedList.Implementation;

public class MainClass {
    public static void main(String[] args) {
        LinkedList root = new LinkedList();
        root.append(10);
        root.append(30);
        root.append(40);
        root.append(50);
        root.append(60);
        root.prepend(0);
        root.set(0, 1);
        System.out.println("Inserted successfully : " + root.insert(2, 20));
        System.out.println("Last node removed : " + root.removeLast().value);
        System.out.println("First node removed : " + root.removeStart().value);
        System.out.println(root.printList(root.getHead()));

        System.out.println("Element at index 3 removed : " + root.remove(4).value);
        System.out.println("Current length : " + root.getLength());
        System.out.println(root.printList(root.getHead()));

        root.reverse();
        System.out.println(root.printList(root.getHead()));
    }
}