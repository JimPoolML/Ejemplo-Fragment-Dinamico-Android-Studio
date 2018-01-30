package appjpm4everyone.fragment_dinamico;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements
             Fragment_Azul.OnFragmentInteractionListener, Fragment_Rojo.OnFragmentInteractionListener,
             Fragment_Verde.OnFragmentInteractionListener{

    //Creamos las instancias de los Fragments
    Fragment_Verde fragment_verde;
    Fragment_Rojo  fragment_rojo;
    Fragment_Azul  fragment_azul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos las instancias de los XML
        fragment_azul =  new Fragment_Azul();
        fragment_rojo =  new Fragment_Rojo();
        fragment_verde = new Fragment_Verde();

        //Deseo que el Fragment Rojo sea el primero en aparecer
        //Selecciono primero el contenedor y luego el fragment a cargar
        getSupportFragmentManager().beginTransaction().add(R.id.Contenedor_Fragment,fragment_rojo).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void Click1(View view) {
        //Con el evento de los botones va a cargar el respectivo Fragment

        FragmentTransaction  CambioFragment = getSupportFragmentManager().beginTransaction();

        //Depende del boton pulsado caragaz el Fragment con un Switch Case
        switch(view.getId()){

            case R.id.btnBlue:
                CambioFragment.replace(R.id.Contenedor_Fragment, fragment_azul);
                break;

            case R.id.btnGreen:
                CambioFragment.replace(R.id.Contenedor_Fragment, fragment_verde);
                break;

            case R.id.btnRed:
                CambioFragment.replace(R.id.Contenedor_Fragment, fragment_rojo);
                break;
        }

        CambioFragment.commit();

    }
}
