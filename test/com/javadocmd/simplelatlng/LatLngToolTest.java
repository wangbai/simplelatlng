package com.javadocmd.simplelatlng;

public class LatLngToolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LatLng p1 = new LatLng(0,0);
		LatLng p2 = new LatLng(1,1);
		LatLng p3 = new LatLng(1,1);
		LatLng p4 = new LatLng(0.4,5);
		
		System.out.println(LatLngTool.isIntersected(p1, p2, p3, p4));
	}

}
