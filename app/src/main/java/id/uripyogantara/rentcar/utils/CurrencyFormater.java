package id.uripyogantara.rentcar.utils;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import id.uripyogantara.rentcar.model.Car;

public class CurrencyFormater {

    public static String toRupiah(int number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format((double)number);
    }
}
