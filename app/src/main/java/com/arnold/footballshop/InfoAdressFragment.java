package com.arnold.footballshop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class InfoAdressFragment extends Fragment implements OnBackPressedListener {


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.info_adress, container, false);
		Button иutton = (Button)v.findViewById(R.id.show_mapButton);
		иutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.startFragment(new MiniMapFragment());
			}
		});

		return  v;
	}

	@Override
	public void onBackPressed() {
		MainActivity.startFragment(new InfoListFragment());
	}
}
