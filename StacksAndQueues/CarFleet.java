package StacksAndQueues;

import java.util.HashSet;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1){
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        int[] helper = new int[speed.length];
        for(int i=0; i<position.length; i++){
            helper[i] = position[i] + speed[i];

        }
        int count = 0;
        for(int i=0; i<helper.length; i++){

            if(set.contains(helper[i])){
                count ++;
            }
            set.add(helper[i]);
        }
        int pairs = count;
        int remaining = helper.length - (count*2);
        return pairs+remaining;
    }
}
