package com.formationandroid.fragments;

public class Memo
{
	
	// Attributs :
	private String intitule = null;
	
	/**
	 * Constructeur.
	 * @param intitule Intitulé du mémo
	 */
	public Memo(String intitule)
	{
		this.intitule = intitule;
	}
	
	/**
	 * Getter intitulé.
	 * @return Intitulé du mémo
	 */
	public String getIntitule()
	{
		return intitule;
	}
	
}
