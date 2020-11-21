package com.gaston.ejercicioparcial2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner turnos;
    ArrayAdapter<String> adapter;
    String[] turnosExamen = { "Mañana", "Tarde", "Noche" };
    EditText nombre;
    EditText apellido;
    EditText legajo;
    Button guardar;
    private Handler miHandler;
    private static final int CODIGO_OPERACION = 99;
    private static final String CANAL_MENSAJES_ID = "canal";
    private static List< Alumno > alumnosCargados ;
    private String turnoElegido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turnos = findViewById(R.id.spinnerTurnos);
        nombre = findViewById(R.id.nombreAlumno);
        apellido = findViewById(R.id.apellidoAlumno);
        legajo = findViewById(R.id.legajo);
        guardar = findViewById(R.id.button1);
        alumnosCargados = new ArrayList<Alumno>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, turnosExamen);
        turnos.setAdapter(adapter);
        BroadcastReceiver br = new MyReceiver();
        IntentFilter filtro = new IntentFilter();
        filtro.addAction(MyReceiver.EVENTO_01);
        getApplication().getApplicationContext()
                .registerReceiver(br,filtro);
        turnos.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        turnoElegido = parent.getItemAtPosition(position).toString();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) { }
                });

                    miHandler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message inputMessage) {
                if(inputMessage.what==CODIGO_OPERACION){
                    /*estado.setTextColor((Integer)inputMessage.obj);
                    estado.setText("FINALIZA proceso largo”
                            + “La duracion es "+inputMessage.arg1);*/
                }
            }
        };


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Message mensaje = new Message();
                mensaje.what=CODIGO_OPERACION;
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                            Alumno a1 = new Alumno(nombre.getText().toString(),apellido.getText().toString(),Integer.parseInt(legajo.getText().toString()), turnoElegido);
                            alumnosCargados.add(a1);
                            mensaje.obj=a1;
                            miHandler.sendMessage(mensaje);
                        Intent i = new Intent();
                        i.putExtra("data1",nombre.getText().toString());
                        i.putExtra("data2",apellido.getText().toString());
                        i.putExtra("data3",Integer.parseInt(legajo.getText().toString()));
                        i.putExtra("data4",turnoElegido);
                        i.setAction(MyReceiver.EVENTO_01);
                        sendBroadcast(i);
                    }
                };
                Thread t1 = new Thread(r);
                t1.start();
            }
        });

    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.nombre_canal);
            //String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel =
                    new NotificationChannel(CANAL_MENSAJES_ID, name, importance);
            //channel.setDescription(description);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}