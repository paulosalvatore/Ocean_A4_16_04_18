package br.com.paulosalvatore.ocean_a4_16_04_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private EditText etNome;
	private EditText etEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etNome = findViewById(R.id.etNome);
		etEmail = findViewById(R.id.etEmail);
	}

	public void enviar(View view) {
		String nome = etNome.getText().toString();
		String email = etEmail.getText().toString();

		if (nome.isEmpty()) {
			Toast.makeText(this, "Digite o seu nome.", Toast.LENGTH_SHORT).show();
		}
		else if (email.isEmpty()) {
			Toast.makeText(this, "Digite o seu e-mail.", Toast.LENGTH_SHORT).show();
		}
		else {
			Intent i = new Intent(this, AgendaActivity.class);
			i.putExtra("nome", nome);
			i.putExtra("email", email);
			startActivity(i);
		}
	}

	public void limpar(View view) {
		etNome.setText("");
		etEmail.setText("");
	}
}
