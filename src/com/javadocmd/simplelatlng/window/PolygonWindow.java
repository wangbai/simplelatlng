package com.javadocmd.simplelatlng.window;


import com.javadocmd.simplelatlng.LatLng;

/**
 *  @author wangbai
 */
public class PolygonWindow extends LatLngWindow<PolygonWindow> {
	
	private LatLng[] points = null; 
	
	public PolygonWindow(LatLng[] points) {
		setPoints(points);
	}
	
	public void setPoints(LatLng[] points) {
		if (!isPolygonValid(points)) {
			throw new IllegalArgumentException("It is not a valid polygon:"+points);
		}
		
		this.points = points;
	}
	
	public LatLng[] getPoints() {
		return points;
	}
	
	private boolean isPolygonValid(LatLng[] points) {
		if (points.length < 3) {
			return false;
		}
		
		for(LatLng point : points) {
			if (point == null) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public LatLng getCenter() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean contains(LatLng p) {
		int total = points.length;
		int through = 0;
		
		for (int i = 0, j = i + 1; i < total; ++i, j = i + 1) {
			LatLng p1 = points[i];
			LatLng p2 = points[j%total];
	
			/*
			 * calculate the point number, 
			 * when p radiate a leftward ray paralleling with y axis 
			 */
			if ( (p.getLatitude() > p1.getLatitude()) && (p.getLatitude() <= p2.getLatitude()) 
				|| (p.getLatitude() > p2.getLatitude()) && (p.getLatitude() <= p1.getLatitude()) ) {		
				if ( isLeft(p1, p2, p) ) {
					++through;
				}
			}
		}
		  
		if (through % 2 == 0) {
			return false;
		}
		
		return true;
	}

	public static boolean isLeft(LatLng p1, LatLng p2, LatLng p) {
		double judgeValueX = ( p1.getLongitude() - p2.getLongitude()) 
							/ (p1.getLatitude() - p2.getLatitude()) 
							* (p.getLatitude() - p2.getLatitude() ) 
							+ p2.getLongitude();
		
		if (judgeValueX > p.getLongitude()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean overlaps(PolygonWindow window) {
		// TODO Auto-generated method stub
		LatLng[] testPoints = window.getPoints();
		
		for(LatLng p : testPoints) {
			if (this.contains(p)) {
				return true;
			}
		}
		
		return false;
	}
}
