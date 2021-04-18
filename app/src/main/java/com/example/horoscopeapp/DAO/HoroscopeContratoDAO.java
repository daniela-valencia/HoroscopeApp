package com.example.horoscopeapp.DAO;

import android.provider.BaseColumns;

public final class HoroscopeContratoDAO {

    private HoroscopeContratoDAO() {
    }

    public static class HoroscopeEntrada implements BaseColumns {
        public static final String TABLE_NAME = "Horoscope2021";
        public static final String COLUNM_CURRENT_DATE = "current_date";
        public static final String COLUMN_RANGE = "range";
        public static final String COLUNM_SIGN = "sign";
        public static final String COLUNM_DESCRIPTION = "description";
        public static final String COLUNM_COMPATIBILITY = "compatibility";
        public static final String COLUNM_MOOD = "mood";
        public static final String COLUNM_COLOR = "color";
        public static final String COLUNM_LUCKY_NUMBER = "lucky_number";
        public static final String COLUNM_LUCKY_TIME = "lucky_time";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HoroscopeEntrada.TABLE_NAME + "("
                    + HoroscopeEntrada._ID + " INTEGER PRIMARY KEY, "
                    + HoroscopeEntrada.COLUNM_CURRENT_DATE + " TEXT NOT NULL, "
                    + HoroscopeEntrada.COLUMN_RANGE + " TEXT NOT NULL, "
                    + HoroscopeEntrada.COLUNM_SIGN + " TEXT NOT NULL, "
                    + HoroscopeEntrada.COLUNM_DESCRIPTION + " TEXT, "
                    + HoroscopeEntrada.COLUNM_COMPATIBILITY + " TEXT, "
                    + HoroscopeEntrada.COLUNM_MOOD + " TEXT, "
                    + HoroscopeEntrada.COLUNM_COLOR + " TEXT, "
                    + HoroscopeEntrada.COLUNM_LUCKY_NUMBER + " INTEGER, "
                    + HoroscopeEntrada.COLUNM_LUCKY_TIME + " TEXT );";

}
