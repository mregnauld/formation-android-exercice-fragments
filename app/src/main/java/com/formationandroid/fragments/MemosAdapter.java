package com.formationandroid.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MemosAdapter extends RecyclerView.Adapter<MemoViewHolder>
{
	
	// Liste d'objets métier :
	private List<Memo> listeMemos = null;
	
	
	/**
	 * Constructeur.
	 * @param listeMemos Liste de mémos
	 */
	public MemosAdapter(List<Memo> listeMemos)
	{
		this.listeMemos = listeMemos;
	}
	
	@Override
	public MemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View viewMemo = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memo, parent, false);
		return new MemoViewHolder(viewMemo);
	}
	
	@Override
	public void onBindViewHolder(MemoViewHolder holder, int position)
	{
		holder.getTextViewIntitule().setText(listeMemos.get(position).getIntitule());
	}
	
	@Override
	public int getItemCount()
	{
		return listeMemos.size();
	}
	
	/**
	 * Ajout d'un mémo à la liste.
	 * @param memo Mémo
	 */
	public void ajouterMemo(Memo memo)
	{
		listeMemos.add(0, memo);
		notifyItemInserted(0);
	}
	
	/**
	 * Retourne le mémo à la position voulue.
	 * @param position Position
	 * @return Mémo
	 */
	public Memo getItemParPosition(int position)
	{
		return listeMemos.get(position);
	}
	
}
