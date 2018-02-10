package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

public class Rehashing implements AlgorithmQuestion{
    @Override
    public void printDescription() {
        System.out.println("The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:\n" +
                "\n" +
                "size=3, capacity=4\n" +
                "\n" +
                "[null, 21, 14, null]\n" +
                "       ↓    ↓\n" +
                "       9   null\n" +
                "       ↓\n" +
                "      null\n" +
                "The hash function is:\n" +
                "\n" +
                "int hashcode(int key, int capacity) {\n" +
                "    return key % capacity;\n" +
                "}\n" +
                "here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.\n" +
                "\n" +
                "rehashing this hash table, double the capacity, you will get:\n" +
                "\n" +
                "size=3, capacity=8\n" +
                "\n" +
                "index:   0    1    2    3     4    5    6   7\n" +
                "hash : [null, 9, null, null, null, 21, 14, null]\n" +
                "Given the original hash table, return the new hash table after rehashing .\n" +
                "\n" +
                " Notice\n" +
                "For negative integer in hash table, the position can be calculated as follow:\n" +
                "\n" +
                "C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function: a % b = (a % b + b) % b to make it is a non negative integer.\n" +
                "Python: you can directly use -1 % 3, you will get 2 automatically.");
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }

        int newLen = hashTable.length * 2;
        ListNode[] res = new ListNode[newLen];

        for (ListNode node : hashTable) {
            while (node != null) {
                int index = (node.val % newLen + newLen) % newLen;
                ListNode curtNewParentNode = res[index];
                if (curtNewParentNode == null) {
                    res[index] = node;
                } else {
                    while (curtNewParentNode.next != null) {
                        curtNewParentNode = curtNewParentNode.next;
                    }
                    curtNewParentNode.next = node;
                }
                ListNode temp = node.next;
                node.next = null;
                node = temp;
            }
        }

        return res;
    }
}
