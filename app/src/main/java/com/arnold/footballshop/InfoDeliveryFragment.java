package com.arnold.footballshop;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class InfoDeliveryFragment extends DialogFragment implements OnBackPressedListener {


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		View v = getActivity().getLayoutInflater().inflate(
				R.layout.info_delivery, null);

		return new AlertDialog.Builder(getActivity()).setView(v)
				.setTitle(R.string.info_delivery_title).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				}).
						create();

	}


	@Override
	public void onBackPressed() {
		MainActivity.startFragment(new InfoListFragment());
	}
}
