package com.gracjan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        DoubleLinkedList<Integer> dbl = new DoubleLinkedList<>();

        dbl.addFirst(12);
        dbl.addFirst(13);
        dbl.addFirst(14);
        dbl.add(55, 1);
        dbl.display();
        dbl.remove(6);
        System.out.println();
        dbl.display();
        System.out.println(dbl.getCounter());
    }
}
