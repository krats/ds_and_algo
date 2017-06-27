package interviewbit.arrays.HotelBookings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by karthikb on 27-06-2017.
 */
public class Solution {
	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		ArrayList<Booking> bookings = new ArrayList<Booking>(arrive.size()*2);
		for(int i=0; i<arrive.size(); i++)
		{
			bookings.add(new Booking(arrive.get(i), true));
			bookings.add(new Booking(depart.get(i), false));
		}
		Collections.sort(bookings, new BookingComparator());
		int count = 0;
		for(int i=0; i<bookings.size(); i++)
		{
			count += bookings.get(i).start ? 1 : -1;
			if(count > K) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>(100);
		ArrayList<Integer> b = new ArrayList<>(100);
		a.add(40);
		a.add(18);
		b.add(40);
		b.add(43);
		int k = 1;
		Solution sol = new Solution();
		System.out.println(sol.hotel(a,b,k));
	}
}

class BookingComparator implements Comparator<Booking> {
	public int compare(Booking a, Booking b)
	{
		if(a.day == b.day)
		{
			if(a.start)
				return 1;
			else
				return -1;
		}
		return a.day-b.day;
	}
}

class Booking {
	int day;
	boolean start;
	public Booking(int day, boolean start)
	{
		this.day = day;
		this.start = start;
	}
}
