package com.formationandroid.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
	
	// Vues :
	private RecyclerView recyclerView = null;
	private EditText editTextMemo = null;
	private FrameLayout frameLayoutConteneurDetail = null;
	
	// Adapter :
	private MemosAdapter memosAdapter = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// vues :
		recyclerView = findViewById(R.id.liste_memos);
		editTextMemo = findViewById(R.id.saisie_memo);
		frameLayoutConteneurDetail = findViewById(R.id.conteneur_detail);
		
		// à ajouter pour de meilleures performances :
		recyclerView.setHasFixedSize(true);
		
		// layout manager, décrivant comment les items sont disposés :
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		
		// contenu d'exemple :
		List<Memo> listeMemos = new ArrayList<>();
		for (int a = 0 ; a < 20 ; a++)
		{
			listeMemos.add(new Memo("Mémo n°" + (a + 1)));
		}
		
		// adapter :
		memosAdapter = new MemosAdapter(this, listeMemos);
		recyclerView.setAdapter(memosAdapter);
	}
	
	/**
	 * Appelé lors du clic sur un item de la liste, depuis l'adapter.
	 * @param position Position dans la liste d'objets métier (position à partir de zéro !)
	 */
	public void onClicItem(int position)
	{
		// récupération du mémo à cette position :
		Memo memo = memosAdapter.getItemParPosition(position);
		
		// affichage du détail :
		if (frameLayoutConteneurDetail != null)
		{
			// fragment :
			DetailFragment fragment = new DetailFragment();
			Bundle bundle = new Bundle();
			bundle.putString(DetailFragment.EXTRA_MEMO, memo.intitule);
			fragment.setArguments(bundle);
			
			// le conteneur de la partie détail est disponible, on est donc en mode "tablette" :
			getSupportFragmentManager().beginTransaction().replace(R.id.conteneur_detail, fragment).commit();
		}
		else
		{
			// le conteneur de la partie détail n'est pas disponible, on est donc en mode "smartphone" :
			Intent intent = new Intent(this, DetailActivity.class);
			intent.putExtra(DetailFragment.EXTRA_MEMO, memo.intitule);
			startActivity(intent);
		}
	}
	
	/**
	 * Listener clic bouton valider.
	 * @param view Bouton valider
	 */
	public void onClickBoutonValider(View view)
	{
		// ajout du mémo :
		memosAdapter.ajouterMemo(new Memo(editTextMemo.getText().toString()));
		
		// animation de repositionnement de la liste (sinon on ne voit pas l'item ajouté) :
		recyclerView.smoothScrollToPosition(0);
		
		// on efface le contenu de la zone de saisie :
		editTextMemo.setText("");
	}
	
}
