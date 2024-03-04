package mx.edu.itesca.examen_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import android.content.Context
import android.content.Intent

class Regalos : AppCompatActivity() {
    var productos=ArrayList<Detalles>()
    var adapter: DetallesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)
        var menuOption: String? = intent.getStringExtra("menuType")
        val typeProduct: TextView =findViewById(R.id.producttype)
        cargarProductos(menuOption)

        adapter=DetallesAdapter(this, productos)
        var gridproduct: GridView =findViewById(R.id.catalogoproductos)
        gridproduct.adapter=adapter
    }
    fun cargarProductos(option:String?){
        val typeProduct: TextView =findViewById(R.id.producttype)
        when(option){
            "Detalles"->{
                typeProduct.setText("Detalles")
                productos.add(Detalles(R.drawable.cumplebotanas,"$280"))
                productos.add(Detalles(R.drawable.cumplecheve,"$320"))
                productos.add(Detalles(R.drawable.cumpleescolar,"$330"))
                productos.add(Detalles(R.drawable.cumplepaletas,"$190"))
                productos.add(Detalles(R.drawable.cumplesnack,"$150"))
                productos.add(Detalles(R.drawable.cumplevinos,"$370"))
            }
            "Globos"->{
                typeProduct.setText("Globos")
                productos.add(Detalles(R.drawable.globoamor,"$240"))
                productos.add(Detalles(R.drawable.globocumple,"$820"))
                productos.add(Detalles(R.drawable.globofestejo,"$260"))
                productos.add(Detalles(R.drawable.globonum,"$760"))
                productos.add(Detalles(R.drawable.globoregalo,"$450"))
                productos.add(Detalles(R.drawable.globos,"$240"))
            }
            "Peluches"->{
                typeProduct.setText("Peluches")
                productos.add(Detalles(R.drawable.peluchemario,"$320"))
                productos.add(Detalles(R.drawable.pelucheminecraft,"$320"))
                productos.add(Detalles(R.drawable.peluchepeppa,"$290"))
                productos.add(Detalles(R.drawable.peluches,"$10,000"))
                productos.add(Detalles(R.drawable.peluchevarios,"$330"))
                productos.add(Detalles(R.drawable.peluchesony,"$280"))
                productos.add(Detalles(R.drawable.peluchestich,"$195"))
            }
            "Regalos"->{
                typeProduct.setText("Regalos")
                productos.add(Detalles(R.drawable.regaloazul,"$80"))
                productos.add(Detalles(R.drawable.regalobebe,"$290"))
                productos.add(Detalles(R.drawable.regalocajas,"$140"))
                productos.add(Detalles(R.drawable.regalocolores,"$85"))
                productos.add(Detalles(R.drawable.regalos,"$10,000"))
                productos.add(Detalles(R.drawable.regalovarios,"$75"))
            }
            "Tazas"->{
                typeProduct.setText("Tazas")
                productos.add(Detalles(R.drawable.tazaabuela,"$120"))
                productos.add(Detalles(R.drawable.tazalove,"$120"))
                productos.add(Detalles(R.drawable.tazaquiero,"$260"))
                productos.add(Detalles(R.drawable.tazas,"$280"))
            }
        }
    }
    class DetallesAdapter :BaseAdapter{
        var productos2=ArrayList<Detalles>()
        var context: Context?= null
        constructor(context: Context, productos2: ArrayList<Detalles>):super(){
            this.productos2=productos2
            this.context=context
        }
        override fun getCount(): Int {
            return productos2.size
        }
        override fun getItem(position: Int): Any {
            return productos2[position]
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var productos2=productos2[position]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista=inflator.inflate(R.layout.detalle, null)
            var image: ImageView=vista.findViewById(R.id.image_product_cell)
            var title: TextView=vista.findViewById(R.id.product_price_cell)
            image.setImageResource(productos2.image)
            title.setText(productos2.precio)
            image.setOnClickListener(){
                val intento = Intent (context,DetalleRegalo::class.java)
                intento.putExtra( "imagen", productos2.image)
                intento.putExtra( "precio", productos2.precio)
                context!!.startActivity(intento)
            }
            return vista
        }

    }
}