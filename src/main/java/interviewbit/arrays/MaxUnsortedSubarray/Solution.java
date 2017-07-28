package interviewbit.arrays.MaxUnsortedSubarray;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		int n =A.size();
		int lmax =Integer.MIN_VALUE;
		int rmin=Integer.MAX_VALUE;
		int start=-1;
		int end=-1;
		int prev=Integer.MIN_VALUE;
		for(int i=0; i<n;i++) {
			prev = lmax;
			if(A.get(i)>lmax) {
				lmax=A.get(i);
			}
			if(i>0 && A.get(i)<prev) {
				end=i;
			}
		}
		prev=Integer.MAX_VALUE;
		for(int i=n-1; i>=0;i--) {
			prev = rmin;
			if(A.get(i)<rmin){
				rmin=A.get(i);
			}
			if(i < n-1 && A.get(i)>prev) {
				start=i;
			}
		}
		ArrayList<Integer> arr = new ArrayList<>();
		if(start==-1) {
			arr.add(-1);
			return arr;
		}
		arr.add(start);
		arr.add(end);
		return arr;
		
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>(n);
		for(int i=0; i<n; i++)
			a.add(in.nextInt());
		System.out.println(sol.subUnsort(a));
	}
}
