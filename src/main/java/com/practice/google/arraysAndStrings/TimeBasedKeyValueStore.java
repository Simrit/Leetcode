package com.practice.google.arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    /*
    Map<String, List<Pair<Integer,String>>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<Pair<Integer,String>>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        //get the list associated with the key;
        List<Pair<Integer,String>> list = map.get(key);

        if(list==null)
            return "";
        else{

            //implement binary search on the list
            int left = 0;
            int right = list.size()-1;
            while(left<=right){
                int mid = (left+right)>>1;
                Pair<Integer,String> curr = list.get(mid);
                if(timestamp-curr.getKey()>0){
                    left = mid+1;
                }
                else if(timestamp-curr.getKey()==0)
                    return curr.getValue();
                else if(timestamp-curr.getKey()<0){
                    right=mid-1;
                }
            }
            return left>0 ? list.get(left-1).getValue() : "";
        }
    }
     */
}
