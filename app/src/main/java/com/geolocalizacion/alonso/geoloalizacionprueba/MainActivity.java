package com.geolocalizacion.alonso.geoloalizacionprueba;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private LocationManager locationManager;
//    private final LocationListener gpsLocationListener =new LocationListener(){
//
//        @Override
//        public void onStatusChanged(String provider, int status) {
//            //final String tvTxt = textView.getText().toString();
//            switch (status) {
//                case LocationProvider.AVAILABLE:
//                    //textView.setText(tvTxt + "GPS available again\n");
//                    break;
//                case LocationProvider.OUT_OF_SERVICE:
//                   // textView.setText(tvTxt + "GPS out of service\n");
//                    break;
//                case LocationProvider.TEMPORARILY_UNAVAILABLE:
//                   // textView.setText(tvTxt + "GPS temporarily unavailable\n");
//                    break;
//            }
//        }
//
//        @Override
//        public void onProviderEnabled(String provider) {
//            //textView.setText(textView.getText().toString()
//                 //   + "GPS Provider Enabled\n");
//        }
//
//        @Override
//        public void onProviderDisabled(String provider) {
//            //textView.setText(textView.getText().toString()
//                    //+ "GPS Provider Disabled\n");
//        }
//
//        @Override
//        public void onLocationChanged(Location location) {
//          //  locationManager.removeUpdates(networkLocationListener);
//           // textView.setText(textView.getText().toString()
//                   // + "New GPS location: "
//                  //  + String.format("%9.6f", location.getLatitude()) + ", "
//                   // + String.format("%9.6f", location.getLongitude()) + "\n");
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0,new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
              System.out.println("cambio LOCATION");
                double latdouble =location.getLatitude();
                double longdouble = location.getLongitude();
                TextView lat = (TextView) findViewById(R.id.texto);
                TextView longi = (TextView) findViewById(R.id.texto2);
                lat.setText("La latitud es : " + latdouble);
                longi.setText("La longitud es: " + longdouble);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                System.out.println("cambio ESTADO");
                System.out.println("cambio Ativo");
                Toast.makeText(getApplicationContext(),
                        provider+"is "+status, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onProviderEnabled(String provider) {
                System.out.println("cambio Ativo");
                Toast.makeText(getApplicationContext(),
                        provider+" activado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onProviderDisabled(String provider) {
                System.out.println("cambio inativo");
                Toast.makeText(getApplicationContext(),
                        provider+" desactivado", Toast.LENGTH_LONG).show();

            }
        });
        Location   loc = locationManager;
        double latdouble =loc.getLatitude();
        double longdouble = loc.getLongitude();
        TextView lat = (TextView) findViewById(R.id.texto);
        TextView longi = (TextView) findViewById(R.id.texto2);
        lat.setText("La latitud es : " + latdouble);
        longi.setText("La longitud es: " + longdouble);




    }
    private void actualizaLocalizacion(Location loc){

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
