package PetMeetUp;

import java.text.DecimalFormat;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

public class testMapApi {

    // 在Google Cloud Console中创建一个API密钥，并将其替换为你自己的API密钥
    private static final String API_KEY = ""; // AIzaSyC34kDvfBc95i78FsMQp-OvlqhtCQxa4Pc 

    public static void main(String[] args) {
        GeoApiContext context = new GeoApiContext.Builder()
                                    .apiKey(API_KEY)
                                    .build();

        String origin = "34.022273, -117.907428";
        String destination = "Mandarin Plaza, 1015 S Nogales St, Rowland Heights, CA 91748";

        try {
            DistanceMatrix distanceMatrix = DistanceMatrixApi.getDistanceMatrix(context, new String[]{origin}, new String[]{destination})
                                                            .mode(TravelMode.DRIVING)
                                                            .await();

            // 获取距离，以mile为单位
            DecimalFormat df = new DecimalFormat("#,###.0");            
            String distance = df.format(distanceMatrix.rows[0].elements[0].distance.inMeters/1000);

            System.out.println("Distance between " + origin + " and " + destination + ": " + distance + " miles");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
