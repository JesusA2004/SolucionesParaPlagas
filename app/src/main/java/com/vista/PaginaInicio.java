package com.vista;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.solucionesparaplagas.R;

public class PaginaInicio {

    private View _bg__welcome_ek2;
    private ImageView marcoimagenp;
    private ImageView textsolucionesparaplagas;
    private TextView label_text;
    private TextView soluciones_para_plagas_urbanas_y_agr_colas;
    private TextView __bienvenido_;
    private ImageView logotipsinfondo;
    private View informacion;
    private TextView bajada_a_chapultepec___3__chapultepec__62360_cuernavaca__mor_;
    private ImageView iconodireccion;
    private ImageView iconopaginawebrecortada_1;
    private TextView solucionesparaplagas_com;
    private TextView crear_una_cuenta;
    private View view;

    /*
    public PaginaInicio(View view) {
        this.view = view;
        setInicio();
    }*/

    // Asignacion de elementos en la UI con lo dado por Figma
    private void setInicio() {
        _bg__welcome_ek2 = view.findViewById(R.id._bg__welcome_ek2);
        marcoimagenp = view.findViewById(R.id.marcoimagenp);
        textsolucionesparaplagas = view.findViewById(R.id.textsolucionesparaplagas);
        label_text = view.findViewById(R.id.label_text);
        soluciones_para_plagas_urbanas_y_agr_colas = view.findViewById(R.id.soluciones_para_plagas_urbanas_y_agr_colas);
        __bienvenido_ = view.findViewById(R.id.__bienvenido_);
        logotipsinfondo = view.findViewById(R.id.logotipsinfondo);
        informacion = view.findViewById(R.id.informacion);
        bajada_a_chapultepec___3__chapultepec__62360_cuernavaca__mor_ = view.findViewById(R.id.bajada_a_chapultepec___3__chapultepec__62360_cuernavaca__mor_);
        iconodireccion = view.findViewById(R.id.iconodireccion);
        iconopaginawebrecortada_1 = view.findViewById(R.id.iconopaginawebrecortada_1);
        solucionesparaplagas_com = view.findViewById(R.id.solucionesparaplagas_com);
        crear_una_cuenta = view.findViewById(R.id.crear_una_cuenta);
    }
}
