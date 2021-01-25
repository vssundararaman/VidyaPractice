package com.vidya.fb;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'Z'};

        //char[] tasks = {'A', 'A'};

    //    B -> A - > Idle -> B -> A -> Idle -> B -> A - Idle - B

        System.out.println(taskIntervals(tasks, 2));
    }

    static int taskIntervals(char[] tasks, int n) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : tasks) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(charMap.values());

        int cycles = 0;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
               if(!queue.isEmpty()){
                   list.add(queue.remove());
               }
            }

            for(int i: list){
                if(--i >0){
                    queue.add(i);
                }
            }

            cycles += queue.isEmpty()? list.size(): n+1;
        }

        return cycles;
    }
}
