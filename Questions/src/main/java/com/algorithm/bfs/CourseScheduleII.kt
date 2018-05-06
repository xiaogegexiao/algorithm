package com.algorithm.bfs

import com.algorithm.AlgorithmQuestion
import java.util.HashSet
import java.util.LinkedList
import java.util.Queue
import java.util.HashMap



class CourseScheduleII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("There are a total of n courses you have to take, labeled from 0 to n-1.\n" +
                "\n" +
                "Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]\n" +
                "\n" +
                "Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.\n" +
                "\n" +
                "There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: 2, [[1,0]] \n" +
                "Output: [0,1]\n" +
                "Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   \n" +
                "             course 0. So the correct course order is [0,1] .\n" +
                "Example 2:\n" +
                "\n" +
                "Input: 4, [[1,0],[2,0],[3,1],[3,2]]\n" +
                "Output: [0,1,2,3] or [0,2,1,3]\n" +
                "Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     \n" +
                "             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. \n" +
                "             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .\n" +
                "Note:\n" +
                "\n" +
                "The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.\n" +
                "You may assume that there are no duplicate edges in the input prerequisites.\n" +
                "Hints:\n" +
                "\n" +
                "This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.\n" +
                "Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.\n" +
                "Topological sort could also be done via BFS.")
    }

    fun findOrder(numCourses: Int, prereq: Array<IntArray>): IntArray {
        val prereqNums = IntArray(numCourses)
        val map = HashMap<Int, MutableSet<Int>>()
        for (prereqrow in prereq) {
            val list = map.getOrDefault(prereqrow[1], HashSet())
            if (!list.contains(prereqrow[0])) {
                list.add(prereqrow[0])
                prereqNums[prereqrow[0]]++
            }
            map[prereqrow[1]] = list
        }

        val set = HashSet<Int>()
        val queue = LinkedList<Int>()
        val result = IntArray(numCourses)
        var index = 0
        for (i in 0 until numCourses) {
            if (prereqNums[i] == 0) {
                set.add(i)
                queue.offer(i)
                result[index++] = i
            }
        }

        while (!queue.isEmpty()) {
            val course = queue.poll()!!
            val subCourses = map.getOrDefault(course, HashSet())
            for (subCourse in subCourses) {
                if (--prereqNums[subCourse] == 0) {
                    set.add(subCourse)
                    queue.offer(subCourse)
                    result[index++] = subCourse
                }
            }
        }
        return if (set.size == numCourses) result else intArrayOf()
    }

}