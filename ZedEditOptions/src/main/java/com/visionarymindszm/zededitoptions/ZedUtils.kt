package com.visionarymindszm.zededitoptions

import android.app.DatePickerDialog
import android.content.Context
import android.content.res.Resources
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*

/**
 * @author Paul Kunda
 * @since 2021
 * @version 0.1.
 * This class is a Util tool to help you have a access to the most common dialogs without having to recreate then
 */
object ZedUtils {
    // province array
    val PROVINCES = arrayOf(
        "Central", "Copperbelt", "Eastern", "Luapula",
        "Lusaka", "Muchinga", "Northern", "NorthWestern", "Southern", "Western"
    )

    // districts Array
    private val central = arrayOf<String?>(
        "Chibombo", "Chisamba", "Chitambo",
        "Kabwe", "Kapiri-Mposhi", "Luano",
        "Mkushi", "Mumbwa", "Ngabwe",
        "Serenje", "Itezhi-Tezhi"
    )
    private val copperbelt = arrayOf<String?>(
        "Chililabombwe","Chingola","Kalulushi",
        "Kitwe","Luanshya","Lufwanyama",
        "Masaiti","Mpongwe","Mufulira",
        "Ndola","Chambishi"
    )
    private val eastern = arrayOf<String?>(
        "Chadiza", "Chasefu", "Chipangali",
        "Chipata", "Kasenengwa", "Katete",
        "Lumezi", "Lundazi", "Mambwe",
        "Lusangazi", "Nyimba", "Petauke",
        "Sinda", "Vubwi"
    )
    private val luapula = arrayOf<String?>(
        "Chiengi", "Chifunabuli", "Chipili",
        "Chembe", "Kawambwa", "Lunga",
        "Mansa", "Milenge", "Mwansabobwe",
        "Mwense", "Nchelenge", "Samfya"
    )
    private val lusaka = arrayOf<String?>(
        "Chilanga","Chirundu","Chongwe",
        "Kafue",  "Luangwa", "Lusaka",
        "Rufunsa","Shibuyunji"
    )
    private val muchinga = arrayOf<String?>(
        "Chama", "Chilinda", "Chinsali",
        "Isoka", "Kanchibiya", "Lavushimanda",
        "Mafinga", "Mpika", "Nakonde",
        "Shiwa'Ngandu"
    )
    private val northWestern = arrayOf<String?>(
        "Chavuma", "Ikelenge", "Kabompo",
        "Kalumbila", "Kasempa", "Manyinga",
        "Mufumbwe", "Mushindano", "Mwinilunga",
        "Solwezi", "Zambezi"
    )
    private val northern = arrayOf<String?>(
        "Chilubi", "Kaputa", "Kasama",
        "Lunte", "Lupososhi", "Luwingu",
        "Mbala", "Mporokoso", "Mpulungu",
        "Mungwi", "Nsama",  "Senga"
    )
    private val southern = arrayOf<String?>(
        "Chikankata", "Choma", "Gwembe",
        "Kalomo", "Kazungula", "Livingstone",
        "Mazabuka", "Monze",  "Namwala",
        "Pemba", "Siavonga", "Sinazongwe",
        "Zimba"
    )
    private val western = arrayOf<String?>(
        "Kalabo", "Kaoma", "Limulungu",
        "Luampa", "Lukulu", "Mitete",
        "Mongu", "Mulobezi", "Mwandi",
        "Nalolo", "Nkeyama", "Senanga",
        "Sesheke", "Shangombo", "SikongoSioma"
    )

    /**
     *
     * This shows a dialog of with options passed to it, a all purpose dialog
     * @param title: Title of the dialog
     * @param callingActivity_Fragment: Context to be displayed on
     * @param optionsPassed: Array of the options to be viewed
     * @param fieldCalled: Edit
     */
    fun showDialog(
        title: String?,
        callingActivity_Fragment: Context?,
        optionsPassed: Array<String?>,
        fieldCalled: EditText
    ) {
        val builder = AlertDialog.Builder(
            callingActivity_Fragment!!
        )
        builder.setTitle(title)
        builder.setItems(optionsPassed) { dialog, item ->
            fieldCalled.setText(
                optionsPassed[item]
            )
        }
        val alert = builder.create()
        alert.show()
    }

    /**
     *
     * @param provinceName: A String of the selected province
     * @return Array of the Districts in the given province
     */
    fun getDistrictArray(provinceName: String?): Array<String?> {
        when (provinceName) {
            "Central" -> return central
            "Copperbelt" -> return copperbelt
            "Eastern" -> return eastern
            "Luapula" -> return luapula
            "Lusaka" -> return lusaka
            "Muchinga" -> return muchinga
            "NorthWestern" -> return northWestern
            "Northern" -> return northern
            "Southern" -> return southern
            "Western" -> return western
        }
        return arrayOfNulls(0)
    }

    /**
     *
     * @param callingContext : Activity (AppCompact) or Fragment that is current
     * @param requestingView: View that was passed, casting this view to two possible instances
     */
    fun pickDate(callingContext: Context?, requestingView: View?) {
        val calendar = Calendar.getInstance()
        val day: Int = calendar[Calendar.DAY_OF_MONTH]
        val month: Int = calendar[Calendar.MONTH]
        val year: Int = calendar[Calendar.YEAR]
        DatePickerDialog(callingContext!!, { datePicker, yearInner, monthInner, dayInner ->
            val setMeUp = "" + dayInner + "/" + (monthInner + 1) + "/" + yearInner
            if (requestingView is EditText) {
                requestingView.setText(setMeUp)
            } else if (requestingView is TextView) {
                requestingView.text = setMeUp
            }
        }, year, month, day)
            .show()
    }

    fun validateEditFields(resources: Resources, inputFields: Array<EditText>): Boolean {
        inputFields.forEach { currentField ->
            if(currentField.text.toString().isEmpty()){
                currentField.error = "${resources.getResourceEntryName(currentField.id)} can't be Empty"
                return false
            }
        }
        return true
    }

    fun nrcValidation(nrcEditText: EditText){
        nrcEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val nrcText = nrcEditText.text.toString()
                if(nrcText.length == 9){
                    nrcEditText.setText(formatNrc(nrcText))
                }
            }
        })
    }

    private fun formatNrc(unFormattedNrc: String): String {
        val upperBoundCharacters: String = unFormattedNrc.substring(0, 6)
        val getTheLastCharacters: String = unFormattedNrc.substring(6, 8)
        val stringBuilder = StringBuilder()
        return stringBuilder.append(upperBoundCharacters)
            .append("/").append(getTheLastCharacters).append("/")
            .append(unFormattedNrc[8]).toString()

    }
}