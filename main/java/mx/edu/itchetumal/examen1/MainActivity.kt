package mx.edu.itchetumal.examen1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Crear informacion para agregar a los spinners
        val diaSpinner = arrayOf<String>("01","02","03","04","05","06","07","08","09","10","11","12","13",
        "14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31")

        val mesSpinner = arrayOf<String>("01","02","03","04","05","06","07","08","09","10","11","12")

        val anSpinner = ArrayList<String>()
        for(i in 1980 until 2020) {
            anSpinner.add(i.toString())
        }

        //Llenar Spinners
        var adapterDia = ArrayAdapter(this,android.R.layout.simple_list_item_1,diaSpinner)
        spnDia.adapter = adapterDia

        var adapterMes = ArrayAdapter(this,android.R.layout.simple_list_item_1,mesSpinner)
        spnMes.adapter = adapterMes

        var adapterAn = ArrayAdapter(this,android.R.layout.simple_list_item_1,anSpinner)
        spnAn.adapter = adapterAn
    }

    fun calcular(view: View) {
        //Obtener valores
        val nombre = txtNom.text
        val apeP = txtApeP.text
        val apeM = txtApeM.text
        val dia = spnDia.selectedItem.toString()
        val mes = spnMes.selectedItem.toString()
        val annio = spnAn.selectedItem.toString()

        //Obtener valores para formar CURP
        val apePArray = apeP.split("")
        val apeMCurp = apeM.split("")
        val nomCurp = nombre.split("")
        val annioArray = annio.split("")

        //Obtener primer vocal

        val apeVocal = apePArray.find{it.equals("a")||it.equals("e")||it.equals("i")||it.equals("o")||it.equals("u")}


        //Crear CURP
        val curp = apePArray[1] + apeVocal + apeMCurp[1] + nomCurp[1] + dia + mes + annioArray[3]+annioArray[4]

        txtCurp.text = curp
        println(curp)
    }

    //Limpiar funcion
    fun limpiar(view: View){
        txtNom.text.clear()
        txtApeP.text.clear()
        txtApeM.text.clear()

        txtCurp.text = ""
    }

}