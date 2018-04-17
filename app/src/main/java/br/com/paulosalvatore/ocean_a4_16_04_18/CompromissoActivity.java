package br.com.paulosalvatore.ocean_a4_16_04_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class CompromissoActivity extends AppCompatActivity {

	private EditText etNomeEvento;
	private Spinner spLocalEvento;
	private EditText etInfoEvento;

	private String nome = "";
	private String email = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compromisso);

		etNomeEvento = findViewById(R.id.etNomeEvento);
		spLocalEvento = findViewById(R.id.spLocalEvento);
		etInfoEvento = findViewById(R.id.etInfoEvento);

		Intent i = getIntent();

		nome = i.getStringExtra("nome");
		email = i.getStringExtra("email");
	}

	public void cadastrar(View view) {
		String nomeEvento = etNomeEvento.getText().toString();
		String localEvento = spLocalEvento.getSelectedItem().toString();
		String infoEvento = etInfoEvento.getText().toString();

		Intent i = new Intent(this, AgendaActivity.class);
		i.putExtra("nome", nome);
		i.putExtra("email", email);
		i.putExtra("nomeEvento", nomeEvento);
		i.putExtra("localEvento", localEvento);
		i.putExtra("infoEvento", infoEvento);
		startActivity(i);
		this.finish();
	}

	public void limpar(View view) {
		etNomeEvento.setText("");
		spLocalEvento.setSelection(0);
		etInfoEvento.setText("");
	}
}
