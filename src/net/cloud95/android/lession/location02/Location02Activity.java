package net.cloud95.android.lession.location02;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class Location02Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView info = (TextView) findViewById(R.id.info);

		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		Criteria criteria  = new Criteria();//取得需求物件
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setPowerRequirement(Criteria.POWER_HIGH);
		criteria.setAltitudeRequired(true);
		criteria.setBearingRequired(true);
		criteria.setSpeedRequired(true);
		criteria.setCostAllowed(true);
		
		String bestProvider = locationManager.getBestProvider(criteria, true);
		info.append("\n"+bestProvider);
	}

}
