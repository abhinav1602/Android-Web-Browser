package com.example.mybrowser;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	Button Go, Refresh, Forward, Back, ClearHis;
	EditText url;
	WebView ourBrows;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ourBrows = (WebView) findViewById(R.id.webView1);
		ourBrows.setWebViewClient(new ourViewClient());

		ourBrows.getSettings().setJavaScriptEnabled(true);
		ourBrows.getSettings().setLoadWithOverviewMode(true);
		ourBrows.getSettings().setUseWideViewPort(true);

		try {
			ourBrows.loadUrl("http:\\www.google.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Go = (Button) findViewById(R.id.go);
		Forward = (Button) findViewById(R.id.forward);
		Refresh = (Button) findViewById(R.id.refresh);
		Back = (Button) findViewById(R.id.backward);
		ClearHis = (Button) findViewById(R.id.clearhistory);
		url = (EditText) findViewById(R.id.url);
		Go.setOnClickListener(this);
		Forward.setOnClickListener(this);
		Refresh.setOnClickListener(this);
		Back.setOnClickListener(this);
		ClearHis.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.go:

			String add = url.getText().toString();
			ourBrows.loadUrl(add);
			//For hiding the keyboard after use
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.backward:
			if (ourBrows.canGoBack())
				ourBrows.goBack();

			break;
		case R.id.forward:
			if (ourBrows.canGoForward())
				ourBrows.goForward();
			break;
		case R.id.refresh:
			ourBrows.reload();
			break;
		case R.id.clearhistory:
			ourBrows.clearHistory();
			break;

		default:
			break;
		}
	}
}
