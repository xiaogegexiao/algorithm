package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

public class HashFunction implements AlgorithmQuestion{
    @Override
    public void printDescription() {
        System.out.println("In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to \"hash\" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:\n" +
                "\n" +
                "hashcode(\"abcd\") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE \n" +
                "\n" +
                "                              = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE\n" +
                "\n" +
                "                              = 3595978 % HASH_SIZE\n" +
                "\n" +
                "here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).\n" +
                "\n" +
                "Given a string as a key and the size of hash table, return the hash value of this key.f\n" +
                "\n" +
                "Clarification\n" +
                "For this problem, you are not necessary to design your own hash algorithm or consider any collision issue, you just need to implement the algorithm as described.\n" +
                "\n" +
                "Example\n" +
                "For key=\"abcd\" and size=100, return 78");
    }

    /*
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        if (key == null) {
            return 0;
        }
        long res = 0;
        for (char k : key) {
            res = ((res * 33)  % HASH_SIZE + k) % HASH_SIZE;
        }
        return (int)res;
    }
}
