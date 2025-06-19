package level01;

public class Volume {
	 public static void main(String[] args) {
	        double radiusKm = 6378;
	        double radiusMiles = radiusKm * 0.621371;
	        double pi = Math.PI;

	        double volumeKm3 = (4.0 / 3.0) * pi * Math.pow(radiusKm, 3);
	        double volumeMiles3 = (4.0 / 3.0) * pi * Math.pow(radiusMiles, 3);

	        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
	    }

}
