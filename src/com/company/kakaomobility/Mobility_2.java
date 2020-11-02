package com.company.kakaomobility;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Mobility_2 {
    public static void main(String[] args) {
        Mobility_2 mobility_2 = new Mobility_2();

        String[][] friends = {{"david", "demi"}, {"frank", "demi"}, {"demi", "james"}, {"a", "david"}, {"frank", "a"}, {"james", "c"}, {"frank", "c"}};
        String user_id = "frank";

        String[] solution = mobility_2.solution(friends, user_id);
        Arrays.stream(solution).forEach(x -> System.out.print(x));
    }

    public String[] solution(String[][] friends, String user_id) {
        Graph graph = new Graph();
        for (String[] edge : friends) {
            graph.addPerson(edge[0]);
            graph.addPerson(edge[1]);
            graph.addEdge(edge[0], edge[1]);
        }

        Map<String, List<String>> degreeVertices = graph.getDegreeVertices();

        List<String> frank_friends = degreeVertices.get("frank");

        int max_count = 0;
        List<String> recommendList = new ArrayList<>();

        System.out.println(frank_friends);
        for (String frank_friend : frank_friends) {
            List<String> mutual_friends = degreeVertices.get(frank_friend);


            System.out.println(mutual_friends);
            for (String mutual_friend : mutual_friends) {
                if (!mutual_friend.equals(user_id)) {

                    int mutual_friend_count = 0;
                    List<String> mutual_friends_list = degreeVertices.get(mutual_friend);
                    Map<String, List<String>> recommendFreinds = graph.getRecommendFreinds();
                    recommendFreinds.put(user_id, recommendList);

                    for (String mutual_friend_other : mutual_friends_list) {
                        if (frank_friends.contains(mutual_friend_other)) mutual_friend_count++;
                    }

                    if (mutual_friend_count == max_count) {
                        System.out.println("==");
                        recommendList.add(mutual_friend);

                    } else if (mutual_friend_count > max_count) {
                        System.out.println(">>");
                        recommendList = new ArrayList<>();
                        recommendList.add(mutual_friend);
                        max_count = mutual_friend_count;
                    }

                    recommendFreinds.put(user_id, recommendList);
                }
            }
        }
        return graph.recommendFreinds(user_id);
    }


    class Graph {
        private Map<String, List<String>> degreeVertices;
        private Map<String, List<String>> recommendFreinds;

        public Graph() {
            this.degreeVertices = new HashMap<>();
            this.recommendFreinds = new HashMap<>();
        }

        public Map<String, List<String>> getDegreeVertices() {
            return degreeVertices;
        }

        void addPerson(String name) {
            degreeVertices.putIfAbsent(name, new ArrayList<>());
        }

        public Map<String, List<String>> getRecommendFreinds() {
            return recommendFreinds;
        }

        public String[] recommendFreinds(String name) {
            List<String> recommendList = recommendFreinds.get(name);
            Set<String> set = recommendList.stream().collect(Collectors.toSet());
            String[] recommendArr = new String[set.size()];
            return set.toArray(recommendArr);
        }

        void addEdge(String a, String b) {
            degreeVertices.get(a).add(b);
            degreeVertices.get(b).add(a);
        }
    }
}
