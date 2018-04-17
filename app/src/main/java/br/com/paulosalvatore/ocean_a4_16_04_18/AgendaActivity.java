package br.com.paulosalvatore.ocean_a4_16_04_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AgendaActivity extends AppCompatActivity {

	private TextView tvNome;
	private TextView tvEmail;
	private TextView tvCompromisso;

	private String nome = "";
	private String email = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda);

		tvNome = findViewById(R.id.tvNome);
		tvEmail = findViewById(R.id.tvEmail);
		tvCompromisso = findViewById(R.id.tvCompromisso);

		Intent i = getIntent();

		nome = i.getStringExtra("nome");
		email = i.getStringExtra("email");

		String nomeEvento = i.getStringExtra("nomeEvento");
		String localEvento = i.getStringExtra("localEvento");
		String infoEvento = i.getStringExtra("infoEvento");

		if (nomeEvento != null) {
			tvCompromisso.setText(
					"Nome do Evento: " + nomeEvento + "\n" +
					"Local do Evento: " + localEvento + "\n" +
					"Informações do Evento: " + infoEvento
			);
		}

		tvNome.setText(nome);
		tvEmail.setText(email);
	}

	public void cadastrar(View view) {
		Intent i = new Intent(this, CompromissoActivity.class);
		i.putExtra("nome", nome);
		i.putExtra("email", email);
		startActivity(i);
		this.finish();
	}
}
