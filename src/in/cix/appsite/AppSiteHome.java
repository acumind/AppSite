package in.cix.appsite;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class AppSiteHome extends Activity {
	private static final String TAG = "AppSiteHome";
	protected static final int ADD_SITE_REQ_CODE = 101;
	ListView siteListView;
	List<String> siteList = new ArrayList<String>();
	private ImageView addBtn;
	ArrayAdapter<String> siteAdapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.app_site_home);

		String[] siteArray = getResources().getStringArray(R.array.sites);
		for(String entry: siteArray)
			siteList.add(entry);
		
		addBtn = (ImageView) findViewById(R.id.addBtn);
		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d(TAG, "OnClick: AddBtn clicked");

				Intent in = new Intent(getApplicationContext(), AddSite.class);
				startActivityForResult(in, ADD_SITE_REQ_CODE);

			}
		});

		siteListView = (ListView) findViewById(R.id.siteList);
		siteAdapter = new ArrayAdapter<String>(
				getApplicationContext(),
				android.R.layout.simple_spinner_dropdown_item, siteList);

		siteListView.setAdapter(siteAdapter);
		siteListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int arg2,
					long pos) {
				Log.d(TAG, "OnClick: Site Clicked = " + "http://"
						+ siteList.get((int) pos));


				Intent in = new Intent();
				in.setAction(Intent.ACTION_VIEW);
				in.setData(Uri.parse("http://" + siteList.get((int) pos)));
				startActivity(in);

			}
		});
		

	}

	@Override
	protected void onActivityResult(int reqCode, int resCode, Intent data) {
		Log.d(TAG, "onActivityResult : rCode = " + reqCode + " resCode = " + resCode );
		
		if(resCode == RESULT_OK && reqCode == ADD_SITE_REQ_CODE ){
			String site = data.getExtras().getString("SITE");
			Log.d(TAG, "Entered site is = " + site.toString());
			
			siteList.add(site);
			siteAdapter.notifyDataSetChanged();
			
		}
		
		super.onActivityResult(reqCode, resCode, data);
	}



}
