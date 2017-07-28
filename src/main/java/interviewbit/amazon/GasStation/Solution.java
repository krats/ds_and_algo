package interviewbit.amazon.GasStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
		int currentFuel = 0;
		int remaining = 0;
		int total = 0;
		int start = 0;
		for(int i = 0; i < gas.size(); i++){
			remaining = gas.get(i) - cost.get(i);
			if(currentFuel >= 0)
				currentFuel += remaining;
			else{
				currentFuel = remaining;
				start = i;
			}
			total += remaining;
		}
		return total >= 0 ? start : -1;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> gas = new ArrayList<>(n);
		ArrayList<Integer> cost = new ArrayList<>(n);
		for (int i=0; i < n; i++) {
			gas.add(in.nextInt());
		}
		n = in.nextInt();
		for (int i=0; i < n; i++) {
			cost.add(in.nextInt());
		}
		System.out.println(sol.canCompleteCircuit(gas, cost));
	}
}
