package gabriel.alexander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fecha = findViewById<TextView>(R.id.txtEdad)
        val calcular = findViewById<Button>(R.id.btnCalcular)
        val edad = findViewById<TextView>(R.id.txtResultado)


        val objResta = Resta()

        calcular.setOnClickListener {
            val resultado =
                objResta.restar(fecha.text.toString().toInt())
            edad.text = "Tu edad es de: $resultado"
        }
    }
}