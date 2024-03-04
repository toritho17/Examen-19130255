package mx.edu.itesca.examen_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetalleRegalo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalleregalo)
        val prodcutp: ImageView =findViewById(R.id.imageimg)
        val preciop: TextView =findViewById(R.id.precio)
        val bundle=intent.extras
        if (bundle!=null){
            prodcutp.setImageResource(bundle.getInt("imagen"))
            preciop.setText(bundle.getString( "precio"))
        }
    }
}