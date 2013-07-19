package com.javadocmd.simplelatlng.window;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.util.LatLngConfig;

/**
 *  @author shiwenchen
 */
public class PolygonWindow extends LatLngWindow<PolygonWindow> {
	
	private LatLng[] points = null; 
	
	public PolygonWindow(LatLng[] points) {
		assert (points.length >= 3);
		this.points = points;
	}

	@Override
	public LatLng getCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	public int containsBound(LatLng point) {
		// TODO Auto-generated method stub
		int total = this.points.length;
		int count = 0;
		LatLng pointOne = this.points[0];

		for (int i = 1; i <= total; i++) {
			// point is an vertex
			if ((point.getLongitude() == pointOne.getLongitude())
					&& (point.getLatitude() == pointOne.getLatitude())) {
				return 2;
			}

			// right vertex
			LatLng pointTwo = this.points[i % total];
			// ray is outside of our interests
			if ((point.getLatitude() < min(pointOne.getLatitude(),
					pointTwo.getLatitude()))
					|| (point.getLatitude() > max(pointOne.getLatitude(),
							pointTwo.getLatitude()))) {
				// next ray left point
				pointOne.setLatitudeLongitude(pointTwo.getLatitude(), pointTwo.getLongitude());
			
				continue;
			}

			// ray is crossing over by the algorithm (common part of)
			if ((point.getLatitude() > min(pointOne.getLatitude(),
					pointTwo.getLatitude()))
					&& (point.getLatitude() < max(pointOne.getLatitude(),
							pointTwo.getLatitude()))) {
				// x is before of ray
				if (point.getLongitude() <= max(pointOne.getLongitude(),
						pointTwo.getLongitude())) {
					// overlies on a horizontal ray
					if ((pointOne.getLatitude() == pointTwo.getLatitude())
							&& (point.getLongitude() >= min(
									pointOne.getLongitude(),
									pointTwo.getLongitude()))) {
						return 2;
					}
					// ray is vertical
					if (pointOne.getLongitude() == pointTwo.getLongitude()) {
						// overlies on a ray
						if (pointOne.getLongitude() == point.getLongitude()) {
							return 2;
						} else {// before ray
							++count;
						}

					} else {// cross point on the left side
						// cross point of x
						double xinters = ((point.getLatitude() - pointOne
								.getLatitude()) * (pointTwo.getLongitude() - pointOne
								.getLongitude()))
								/ (pointTwo.getLatitude() - pointOne
										.getLatitude())
								+ pointOne.getLongitude();
						// overlies on a ray
						if (Math.abs(point.getLongitude() - xinters) < LatLngConfig.DEGREE_TOLERANCE) {
							return 2;
						}
						// before ray
						if (point.getLongitude() < xinters) {
							++count;
						}
					}
				}
			} else {// special case when ray is crossing through the vertex
					// p crossing over p2
				if ((point.getLatitude() == pointTwo.getLatitude())
						&& (point.getLongitude() <= pointTwo.getLongitude())) {
					// next vertex
					LatLng pointThree = this.points[(i + 1) % total];
					// p.y lies between p1.y & p3.y
					if ((point.getLatitude() >= min(pointOne.getLatitude(),
							pointThree.getLatitude()))
							&& (point.getLatitude() <= max(
									pointOne.getLatitude(),
									pointThree.getLatitude()))) {
						++count;
					} else {
						count += 2;
					}
				}
			}

			// next ray left point
			pointOne.setLatitudeLongitude(pointTwo.getLatitude(), pointTwo.getLongitude()) ;
		}

		if ((count % 2) == 0) {
			return 1;
		} else {
			return 0;
		}
	}


	
	@Override
	public boolean contains(LatLng point) {
		// TODO Auto-generated method stub
		int total = this.points.length;
		int count = 0;
		LatLng pointOne = this.points[0];

		for (int i = 1; i <= total; i++) {
			// point is an vertex
			if ((point.getLongitude() == pointOne.getLongitude())
					&& (point.getLatitude() == pointOne.getLatitude())) {
				return true;
			}

			// right vertex
			LatLng pointTwo = this.points[i % total];
			// ray is outside of our interests
			if ((point.getLatitude() < min(pointOne.getLatitude(),
					pointTwo.getLatitude()))
					|| (point.getLatitude() > max(pointOne.getLatitude(),
							pointTwo.getLatitude()))) {
				// next ray left point
				pointOne.setLatitudeLongitude(pointTwo.getLatitude(), pointTwo.getLongitude());
			
				continue;
			}

			// ray is crossing over by the algorithm (common part of)
			if ((point.getLatitude() > min(pointOne.getLatitude(),
					pointTwo.getLatitude()))
					&& (point.getLatitude() < max(pointOne.getLatitude(),
							pointTwo.getLatitude()))) {
				// x is before of ray
				if (point.getLongitude() <= max(pointOne.getLongitude(),
						pointTwo.getLongitude())) {
					// overlies on a horizontal ray
					if ((pointOne.getLatitude() == pointTwo.getLatitude())
							&& (point.getLongitude() >= min(
									pointOne.getLongitude(),
									pointTwo.getLongitude()))) {
						return true;
					}
					// ray is vertical
					if (pointOne.getLongitude() == pointTwo.getLongitude()) {
						// overlies on a ray
						if (pointOne.getLongitude() == point.getLongitude()) {
							return true;
						} else {// before ray
							++count;
						}

					} else {// cross point on the left side
						// cross point of x
						double xinters = ((point.getLatitude() - pointOne
								.getLatitude()) * (pointTwo.getLongitude() - pointOne
								.getLongitude()))
								/ (pointTwo.getLatitude() - pointOne
										.getLatitude())
								+ pointOne.getLongitude();
						// overlies on a ray
						if (Math.abs(point.getLongitude() - xinters) < LatLngConfig.DEGREE_TOLERANCE) {
							return true;
						}
						// before ray
						if (point.getLongitude() < xinters) {
							++count;
						}
					}
				}
			} else {// special case when ray is crossing through the vertex
					// p crossing over p2
				if ((point.getLatitude() == pointTwo.getLatitude())
						&& (point.getLongitude() <= pointTwo.getLongitude())) {
					// next vertex
					LatLng pointThree = this.points[(i + 1) % total];
					// p.y lies between p1.y & p3.y
					if ((point.getLatitude() >= min(pointOne.getLatitude(),
							pointThree.getLatitude()))
							&& (point.getLatitude() <= max(
									pointOne.getLatitude(),
									pointThree.getLatitude()))) {
						++count;
					} else {
						count += 2;
					}
				}
			}

			// next ray left point
			pointOne.setLatitudeLongitude(pointTwo.getLatitude(), pointTwo.getLongitude()) ;
		}

		if ((count % 2) == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean overlaps(PolygonWindow window) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static double max(double first, double second) {
		return (first > second) ? first : second;
	}

	private static double min(double first, double second) {
		return (first < second) ? first : second;
	}

}
