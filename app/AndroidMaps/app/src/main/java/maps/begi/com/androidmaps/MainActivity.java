package maps.begi.com.androidmaps;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {

    private GoogleMap googleHarita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (googleHarita == null) {
            googleHarita = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.haritafragment))
                    .getMap();
            if (googleHarita != null) {
                //İstanbul, Kız Kulesi olsun.
                LatLng istanbulKoordinat = new LatLng(41.021161, 29.004065);
                googleHarita.addMarker(new MarkerOptions().position(istanbulKoordinat).title("Kız Kulesi"));  //harita imleci
                googleHarita.moveCamera(CameraUpdateFactory.newLatLngZoom(istanbulKoordinat, 13));
                googleHarita.setMapType(GoogleMap.MAP_TYPE_SATELLITE);  //uydu görünümü
                googleHarita.setMyLocationEnabled(true); //kullanıcı konumunu da gösterir.
            }
        }

    }
}
