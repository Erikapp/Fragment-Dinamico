package com.digitalhouse.projetofragmento;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.digitalhouse.frag1.Frag1;
import com.digitalhouse.frag1.Frag2;

public class MainActivity extends AppCompatActivity {

    private Button botao1;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao1 = (Button) findViewById(R.id.botao1);

        //Pega o FragmentManager
        fragmentManager = getSupportFragmentManager();

        //Abre uma transação e add
        fragmentManager.beginTransaction()
                .add(R.id.frame1, new Frag1()).commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame2, new Frag2()).commit();

        //Substitui um Fragment
        fragmentManager.beginTransaction()
                .replace(R.id.frame2, new Frag2())
                .addToBackStack(null)
                .commit();

        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame2);
                if(fragment != null)
                    fragmentManager.
                            beginTransaction().remove(fragment).commit();
                Toast.makeText(v.getContext(), "Você está no fragmento 2", Toast.LENGTH_LONG).show();
            }
        });
    }
}
