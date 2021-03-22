package com.visionarymindszm.zededitoptions;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

/**
 * @author Paul Kunda
 * @since 2021
 * @version 0.1.0
 * This class is a Util tool to help you have a access to the Zambian Districts and Provinces without having to recreate then
 */
public class ZedUtils {
    // province array
    public static final String[] PROVINCES = {"Central", "Copperbelt", "Eastern", "Luapula",
            "Lusaka", "Muchinga", "Northern", "North_Western", "Southern", "Western"};

    // districts Array
    public static final String[] Central = {"Chibombo","Chisamba","Chitambo","Kabwe","Kapiri-Mposhi","Luano","Mkushi","Mumbwa","Ngabwe","Serenje","Itezhi-Tezhi"};
    public static final String[] Copperbelt = {"Chililabombwe","Chingola","Kalulushi","Kitwe","Luanshya","Lufwanyama","Masaiti","Mpongwe","Mufulira","Ndola","Chambishi"};
    public static final String[] Eastern = {"Chadiza","Chasefu","Chipangali","Chipata","Kasenengwa","Katete","Lumezi","Lundazi","Mambwe","Lusangazi","Nyimba","Petauke","Sinda","Vubwi"};
    public static final String[] Luapula = {"Chiengi","Chifunabuli","Chipili","Chembe","Kawambwa","Lunga","Mansa","Milenge","Mwansabobwe","Mwense","Nchelenge","Samfya"};
    public static final String[] Lusaka = {"Chilanga","Chirundu","Chongwe","Kafue","Luangwa","Lusaka","Rufunsa","Shibuyunji"};
    public static final String[] Muchinga = {"Chama","Chilinda","Chinsali","Isoka","Kanchibiya","Lavushimanda","Mafinga","Mpika","Nakonde","Shiwa'Ngandu"};
    public static final String[] North_Western = {"Chavuma","Ikelenge","Kabompo","Kalumbila","Kasempa","Manyinga","Mufumbwe","Mushindano","Mwinilunga","Solwezi","Zambezi"};
    public static final String[] Northern = {"Chilubi","Kaputa","Kasama","Lunte","Lupososhi","Luwingu","Mbala","Mporokoso","Mpulungu","Mungwi","Nsama","Senga"};
    public static final String[] Southern = {"Chikankata","Choma","Gwembe","Kalomo","Kazungula","Livingstone","Mazabuka","Monze","Namwala","Pemba","Siavonga","Sinazongwe","Zimba"};
    public static final String[] Western = {"Kalabo","Kaoma","Limulungu","Luampa","Lukulu","Mitete","Mongu","Mulobezi","Mwandi","Nalolo","Nkeyama","Senanga","Sesheke","Shangombo","SikongoSioma"};

    /**
     *
     * This shows a dialog of with options passed to it, a all purpose dialog
     * @param title: Title of the dialog
     * @param callingActivity_Fragment: Context to be displayed on
     * @param optionsPassed: Array of the options to be viewed
     * @param fieldCalled: Edit
     */
    public static void showDialog(final String title, final Context callingActivity_Fragment, final String[] optionsPassed, final EditText fieldCalled){
        AlertDialog.Builder builder = new AlertDialog.Builder(callingActivity_Fragment);
        builder.setTitle(title);
        builder.setItems(optionsPassed, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                fieldCalled.setText(optionsPassed[item]);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    /**
     *
     * @param provinceName: A String of the selected province
     * @return Array of the Districts in the given province
     */
    public static  String[] getDistrictArray (String provinceName){
        switch (provinceName) {
            case "Central":
                return Central;
            case "Copperbelt":
                return Copperbelt;
            case "Eastern":
                return Eastern;
            case "Luapula":
                return Luapula;
            case "Lusaka":
                return Lusaka;
            case "Muchinga":
                return Muchinga;
            case "North_Western":
                return North_Western;
            case "Northern":
                return Northern;
            case "Southern":
                return Southern;
            case "Western":
                return Western;
        }
        return new String[0];
    }

}