package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Set<String> strSet=new TreeSet<String>();
		strSet.add("vishnu");
		strSet.add("Saini");
		strSet.add("Rajesh");
		strSet.add("Dinesh");
		strSet.add("Mahesh");
		strSet.add("Vijay");
		strSet.add("Ram");
		strSet.add("Santosh");
		Iterator<String> itr=strSet.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		List<String> strSet=new ArrayList<String>();
		strSet.add("vishnu");
		strSet.add("Saini");
		strSet.add("Rajesh");
		strSet.add("Dinesh");
		strSet.add("Mahesh");
		strSet.add("Vijay");
		strSet.add("Ram");
		strSet.add("Santosh");
		System.out.println(strSet.get(1));
		Iterator<String> itr=strSet.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
