package com.javadocmd.simplelatlng.LatlngChinaTool;

import com.javadocmd.simplelatlng.LatLng;

/*
 * author: wangbai@yongche.com
 */
public final class MarsToBaidu {
	
	private static final double x_pi = Math.PI * 3000.0 / 180.0;

	public LatLng transcodeFromGcj02toBd09 (LatLng gcPoint) {
		double gcLat = gcPoint.getLatitude();
		double gcLon = gcPoint.getLongitude();
		
	    double x = gcLon, y = gcLat;
	    double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
	    double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
	    
	    return new LatLng(z * Math.sin(theta) + 0.006, z * Math.cos(theta) + 0.0065);
	}

	public LatLng transcodeFromBd09toGcj02 (LatLng bdPoint) {
		double bdLat = bdPoint.getLatitude();
		double bdLon = bdPoint.getLongitude();
	    
		double x = bdLon - 0.0065, y = bdLat - 0.006;
	    double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
	    double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
	    
	    return new LatLng(z * Math.sin(theta), z * Math.cos(theta));
	}
}
