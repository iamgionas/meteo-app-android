package ch.supsi.dti.isin.meteoapp.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ch.supsi.dti.isin.meteoapp.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Carico il layout contenente lo spazio per i fragment
        setContentView(R.layout.fragment_single_fragment);

        //Richiedo il gestore dei fragments
        FragmentManager fm = getSupportFragmentManager();

        // Recupro il fragment presente nel layout fragment_single_fragment -> id = fragment_container
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        // Se è nullo inizio con creare il fragment nuovo e caricarlo nel layout
        if (fragment == null) {
            fragment = createFragment();
            // Aggiungo il fragment creato nel layout sotto l'id fragment_container
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}