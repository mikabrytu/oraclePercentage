package br.com.tinhoproducoes.oraclepercentage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int sysNumber;
    public int playerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText playerNumberField = (EditText) findViewById(R.id.player_number_guess);
        Button playerTryTrigger = (Button) findViewById(R.id.player_try_trigger);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                sysNumber = generateNumber();
            }
        });

        playerTryTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sPlayerGuess = String.valueOf(playerNumberField.getText());

                if (sPlayerGuess.equals("")) {
                    Toast.makeText(MainActivity.this, "Insira um número", Toast.LENGTH_SHORT).show();
                } else {
                    playerNumber = Integer.parseInt(sPlayerGuess);

                    if (playerNumber == sysNumber) {
                        Toast.makeText(MainActivity.this, "Você é um verdadeiro oráculo", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Você NÃO é um oráculo", Toast.LENGTH_LONG).show();
                        playerNumberField.setText("");
                    }

                }

            }
        });
    }

    private int generateNumber() {
        Random gerador = new Random();

        return gerador.nextInt(10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to theaction bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
