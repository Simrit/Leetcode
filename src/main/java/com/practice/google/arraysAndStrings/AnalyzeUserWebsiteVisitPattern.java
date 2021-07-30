package com.practice.google.arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeUserWebsiteVisitPattern {
    /*
    1152. Analyze User Website Visit Pattern
Medium

We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.
(The websites in a 3-sequence are not necessarily distinct.)
Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest
such 3-sequence.


Example 1:
Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
Output: ["home","about","career"]
Explanation:
The tuples in this example are:
["joe", 1, "home"]
["joe", 2, "about"]
["joe", 3, "career"]
["james", 4, "home"]
["james", 5, "cart"]
["james", 6, "maps"]
["james", 7, "home"]
["mary", 8, "home"]
["mary", 9, "about"]
["mary", 10, "career"]
The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.


Note:

3 <= N = username.length = timestamp.length = website.length <= 50
1 <= username[i].length <= 10
0 <= timestamp[i] <= 10^9
1 <= website[i].length <= 10
Both username[i] and website[i] contain only lowercase characters.
It is guaranteed that there is at least one user who visited at least 3 websites.
No user visits two websites at the same time.
     */

    static class Browse {
        String user;
        String site;
        int time;

        public Browse(String user, String site, int time) {
            this.user = user;
            this.site = site;
            this.time = time;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        /*Approach here is to:
            1. create a list<browse> from input data and sort them using the time stamp.
            1. create a map of username to list of sites visited.
            2. For the list of websites visited by each user create all unique sets of 3 sites and store the counts of each set in a
            common map.
            3. from that map get the max by value and that is the answer.
         */

        //create the list of browse objects:
        List<Browse> list = new ArrayList<>();
        for(int i=0; i<username.length; i++){
            Browse tmp = new Browse(username[i], website[i], timestamp[i]);
            list.add(tmp);
        }

        //sort the list using timestamp
        Comparator<Browse> cmp = (a,b) -> {return a.time-b.time;};
        Collections.sort(list, cmp);

        Map<String,List<String>> sites_visited = new HashMap<>();
        for(Browse b : list){
            sites_visited.putIfAbsent(b.user, new ArrayList<>());
            sites_visited.get(b.user).add(b.site);
        }

        //create a new map of unique sets of 3.
        Map<List<String>,Integer> siteSets = new HashMap<>();
        for(List<String> l : sites_visited.values()){
            generate3Set(l, siteSets);
        }

        return Collections.max(siteSets.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public void generate3Set(List<String> sites,Map<List<String>,Integer> siteSets){
        for(int i=0 ;i<sites.size(); i++){
            for(int j=i; j<sites.size(); j++){
                for(int k=j; k<sites.size(); k++){
                    List<String> tmp = new ArrayList<>();
                    tmp.add(sites.get(i));
                    tmp.add(sites.get(j));
                    tmp.add(sites.get(k));
                    siteSets.put(tmp, siteSets.getOrDefault(tmp,0)+1);
                }
            }
        }
    }


}
