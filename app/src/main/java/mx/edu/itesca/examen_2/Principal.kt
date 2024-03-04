package mx.edu.itesca.examen_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        var btndetalles: Button = findViewById(R.id.btndetalles) as Button
        var btnglobos: Button = findViewById(R.id.btnglobos) as Button
        var btnpeluches: Button = findViewById(R.id.btnpeluches) as Button
        var btnregalos: Button = findViewById(R.id.btnregalos) as Button
        var btntazas: Button = findViewById(R.id.btntazas) as Button
        btndetalles.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Detalles")
            startActivity(intent)
        }
        btnglobos.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Globos")
            startActivity(intent)
        }
        btnpeluches.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Peluches")
            startActivity(intent)
        }
        btnregalos.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Regalos")
            startActivity(intent)
        }
        btntazas.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType","Tazas")
            startActivity(intent)
        }
    }
}