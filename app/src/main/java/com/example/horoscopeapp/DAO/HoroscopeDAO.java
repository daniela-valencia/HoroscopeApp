package com.example.horoscopeapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.example.horoscopeapp.HoroscopeClass;


public class HoroscopeDAO {

    private final SQLiteHelper dbHelper;

    public HoroscopeDAO(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void addRecord(HoroscopeClass horoscope) {
        if (horoscope == null) throw new NullPointerException();

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_CURRENT_DATE,
                horoscope.getCurrent_date().toLowerCase());
        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_SIGN,
                horoscope.getSign().toLowerCase());
        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUMN_RANGE,
                horoscope.getRange());
        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_DESCRIPTION,
                horoscope.getDescription().toLowerCase());
        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_COMPATIBILITY,
                horoscope.getCompatibility().toLowerCase());
        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_MOOD,
                horoscope.getMood().toLowerCase());
        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_COLOR,
                horoscope.getColor().toLowerCase());
        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_LUCKY_NUMBER,
                horoscope.getLucky_number());
        values.put(HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_LUCKY_TIME,
                horoscope.getLucky_time().toLowerCase());

        db.insert(com.example.horoscopeapp.DAO.HoroscopeContratoDAO.HoroscopeEntrada.TABLE_NAME, null, values);

        db.close();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public HoroscopeClass getRecord(String sign, String day) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = new String[]{
                HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_CURRENT_DATE,
                HoroscopeContratoDAO.HoroscopeEntrada.COLUMN_RANGE,
                HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_SIGN,
                HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_DESCRIPTION,
                HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_COMPATIBILITY,
                HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_MOOD,
                HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_COLOR,
                HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_LUCKY_NUMBER,
                HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_LUCKY_TIME
        };

        String selection = HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_CURRENT_DATE + " = ?"
                + " AND " + HoroscopeContratoDAO.HoroscopeEntrada.COLUNM_SIGN + " = ?";


        String[] selectionArgs = new String[]{day, sign};

        Cursor cursor = db.query(
                HoroscopeContratoDAO.HoroscopeEntrada.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        HoroscopeClass horoscope = null;
        if (cursor.moveToFirst()) {
            horoscope = new HoroscopeClass(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7),
                    cursor.getString(8)
            );
        }

        cursor.close();

        db.close();

        return horoscope;
    }


}
