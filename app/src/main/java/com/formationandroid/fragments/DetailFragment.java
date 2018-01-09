package com.formationandroid.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment
{
	
	// Constantes :
	public static final String EXTRA_MEMO = "EXTRA_MEMO";
	
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_detail, container, false);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState)
	{
		// init :
		super.onActivityCreated(savedInstanceState);
		if (getView() != null && getContext() != null)
		{
			// vues :
			TextView textViewMemo = getView().findViewById(R.id.detail_memo);
			textViewMemo.setText(getArguments().getString(EXTRA_MEMO));
		}
	}
	
}
