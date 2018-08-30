package opet.acs.com.apprateioopet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    private EditText edtComanda, edtPessoas;
    private TextView txtRateio;
    private CheckBox chkServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtComanda = findViewById(R.id.edtComanda);
        edtPessoas = findViewById(R.id.edtPessoas);
        txtRateio = findViewById(R.id.txtRateio);
        chkServico = findViewById(R.id.chkServico);
        chkServico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {
                //Toast.makeText(MainActivity.this, String.valueOf(isCheked), Toast.LENGTH_SHORT).show();

                double comanda = Double.parseDouble(edtComanda.getText().toString());
                comanda *= 1.1;
                edtComanda.setText(new DecimalFormat(".00").format(comanda));


            }
        });

    }

    //Versao 2

    public void calculaRateio (View view){
        double comanda = Double.parseDouble(edtComanda.getText().toString());
        double pessoas = Double.parseDouble(edtPessoas.getText().toString());



        double rateio = comanda / pessoas;

        DecimalFormat mFormat = new DecimalFormat(".00");
        String resultado = "Valor do Rateio: " + mFormat.format(rateio);;

        txtRateio.setText(resultado);

    }
}
