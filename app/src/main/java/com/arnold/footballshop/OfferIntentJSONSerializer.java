package com.arnold.footballshop;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class OfferIntentJSONSerializer {
	private Context mContext;
	private String mFilename;

	public OfferIntentJSONSerializer(Context c, String f) {
		mContext = c;
		mFilename = f;
	}
	
	public ArrayList<Offer> loadOffers() throws IOException, JSONException {
		ArrayList<Offer> offers = new ArrayList<Offer>();
		BufferedReader reader = null;
		try {
		// �������� � ������ ����� � StringBuilder
		InputStream in = mContext.openFileInput(mFilename);
		reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder jsonString = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
		// Line breaks are omitted and irrelevant
		jsonString.append(line);
		}
		// ������ JSON � �������������� JSONTokener
		JSONArray array = (JSONArray) new JSONTokener(jsonString.toString())
		.nextValue();
		for (int i = 0; i < array.length(); i++) {
			offers.add(new Offer(array.getJSONObject(i)));
			}
			} catch (FileNotFoundException e) {
			// ���������� ��� ������ "� ����"; �� ��������� ��������
			} finally {
			if (reader != null)
			reader.close();
			}
			return offers;
			}

	public void saveOffers(ArrayList<Offer> Offers)
			throws JSONException, IOException {
		// ���������� ������� � JSON
		JSONArray array = new JSONArray();
		
		for (Offer r : Offers)
		{
			array.put(r.toJSON());
		}
		// ������ ����� �� ����
		Writer writer = null;
		try {
			OutputStream out = mContext.openFileOutput(mFilename,
					Context.MODE_PRIVATE);
			writer = new OutputStreamWriter(out);
			writer.write(array.toString());
		} finally {
			if (writer != null)
				writer.close();
		}
	}


}