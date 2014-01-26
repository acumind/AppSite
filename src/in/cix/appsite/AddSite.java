package in.cix.appsite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class AddSite extends Activity {

	
	protected static final String TAG = "AddSite";
	private EditText siteEditText;
	private ImageView backBtn;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.add_site_layout);
		
		siteEditText = (EditText) findViewById(R.id.siteEditText);
		
		backBtn = (ImageView) findViewById(R.id.backBtn);
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d(TAG, "OnClick: backBtn clicked");
				Intent intent = getIntent();
				setResult(RESULT_CANCELED);
				finish();

			}
		});
		
	

	}
	


	public void addSite(View v) {
		
		Intent intent = this.getIntent();
		intent.putExtra("SITE", siteEditText.getText().toString());
		this.setResult(RESULT_OK, intent);
		finish();
		

	}

}
