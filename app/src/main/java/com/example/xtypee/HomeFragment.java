package com.example.xtypee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageSlider imageSlider;
    TextView textView;

    private static final String[] TEXTOS = {
            "Según datos de la plataforma inmobiliaria Propiedades.com, el precio promedio por metro cuadrado de una propiedad en la Ciudad de México es de alrededor de 32,000 pesos mexicanos.",
            "Las alcaldías de la Ciudad de México que tuvieron el mayor número de transacciones inmobiliarias durante el primer semestre de 2021 fueron Cuauhtémoc, Benito Juárez y Miguel Hidalgo, según datos de la AMPI.",
            "De acuerdo con un estudio de la plataforma inmobiliaria Lamudi, los compradores de vivienda en la Ciudad de México tienen en promedio entre 35 y 44 años de edad y buscan principalmente propiedades de dos o tres habitaciones.",
            "Según un estudio de la plataforma inmobiliaria Vivanuncios, el 90% de los mexicanos que compran una casa o departamento lo hacen para vivir en ella, mientras que sólo el 10% lo hace como inversión.",
            "En 2021, la pandemia de COVID-19 provocó una disminución del 25% en la venta de viviendas en la Ciudad de México durante el primer semestre del año, en comparación con el mismo período del año anterior, según datos de la Asociación Mexicana de Profesionales Inmobiliarios (AMPI).",
            "La Ciudad de México tiene el mayor número de viviendas del país: De acuerdo con el INEGI, la Ciudad de México cuenta con más de 7 millones de viviendas, lo que representa cerca del 20% del total de viviendas en México.",
            "Según datos de la Asociación Mexicana de Profesionales Inmobiliarios (AMPI), el tiempo promedio para vender una casa en la Ciudad de México es de entre 6 y 9 meses. Sin embargo, este tiempo puede variar considerablemente según la zona y el tipo de propiedad.",
            "La escrituración de una casa en la Ciudad de México puede ser un proceso largo y complejo. En promedio, el trámite puede tardar entre 2 y 3 meses, y requiere de la intervención de un notario público y de diversas autoridades municipales y federales.",
            "Según datos de la plataforma Inmuebles24, el costo promedio de la renta de una casa en la Ciudad de México ha disminuido en un 10% en comparación con los precios pre-pandemia. Esto se debe a una mayor oferta de viviendas disponibles en el mercado.",
            "Según datos de la plataforma Propiedades.com, el 70% de los compradores de vivienda en la Ciudad de México son jóvenes entre 25 y 44 años. Esto se debe en gran parte al aumento en la población joven que busca independizarse y adquirir su propia vivienda.",
            "La Ciudad de México es un centro importante para la educación superior en el país, y atrae a estudiantes de todo México. El 40% de los estudiantes foráneos en la ciudad provienen de otros estados de la república.",
            "Aunque la Ciudad de México es una metrópoli de gran tamaño, el costo de vida en la ciudad es más bajo que en otras ciudades latinoamericanas como São Paulo o Buenos Aires. Esto hace que sea una opción atractiva para los estudiantes foráneos.",
            "Según datos del Instituto Nacional de Estadística y Geografía (INEGI), en la Ciudad de México, el 64% de la población vive en viviendas rentadas, mientras que el 34% vive en viviendas propias.",
            "Según datos de 2021 de la plataforma inmobiliaria Propiedades.com, la colonia de la Ciudad de México con el precio promedio de renta más alto es Polanco, con un promedio de alrededor de $40,000 pesos mexicanos al mes.",
            "Según datos de 2021 de la plataforma inmobiliaria Propiedades.com, la colonia de la Ciudad de México con el precio promedio de venta más alto es Lomas de Chapultepec, con un promedio de alrededor de $43 millones de pesos mexicanos.",
            "Según un estudio realizado por el portal inmobiliario Propiedades.com, en 2021 los departamentos de 2 recámaras fueron los más buscados para comprar en la Ciudad de México."
    };


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Obtener una referencia al TextView
        textView = view.findViewById(R.id.textView2);

        // Generar un índice aleatorio
        Random random = new Random();
        int indiceAleatorio = random.nextInt(TEXTOS.length);

        // Establecer el texto del TextView con el texto aleatorio
        textView.setText(TEXTOS[indiceAleatorio]);

        imageSlider = view.findViewById(R.id.imageSlider);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add( new SlideModel(R.drawable.huno, ScaleTypes.FIT));
        imageList.add( new SlideModel(R.drawable.hdos, ScaleTypes.FIT));
        imageList.add( new SlideModel(R.drawable.htres, ScaleTypes.FIT));
        imageList.add( new SlideModel(R.drawable.hcuatro, ScaleTypes.FIT));
        imageList.add( new SlideModel(R.drawable.hcinco, ScaleTypes.FIT));

        imageSlider.setImageList(imageList);
        return view;

    }


}