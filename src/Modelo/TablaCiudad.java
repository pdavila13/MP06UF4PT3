/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author pdavila
 */
public class TablaCiudad {
    
    private int _1_id_City;
    private String _2_Name;
    private String _3_CountryCode;
    private String _4_District;
    private int _5_Population;

    public TablaCiudad() {
        //
    }

    public TablaCiudad(String _2_Name, String _3_CountryCode, String _4_District, int _5_Population) {
        this._2_Name = _2_Name;
        this._3_CountryCode = _3_CountryCode;
        this._4_District = _4_District;
        this._5_Population = _5_Population;
    }
    
    public TablaCiudad(int _1_id_City, String _2_Name, String _3_CountryCode, String _4_District, int _5_Population) {
        this._1_id_City = _1_id_City;
        this._2_Name = _2_Name;
        this._3_CountryCode = _3_CountryCode;
        this._4_District = _4_District;
        this._5_Population = _5_Population;
    }

    public int get1_id_City() {
        return _1_id_City;
    }

    public void set1_id_City(int _1_id_City) {
        this._1_id_City = _1_id_City;
    }

    public String get2_Name() {
        return _2_Name;
    }

    public void set2_Name(String _2_Name) {
        this._2_Name = _2_Name;
    }

    public String get3_CountryCode() {
        return _3_CountryCode;
    }

    public void set3_CountryCode(String _3_CountryCode) {
        this._3_CountryCode = _3_CountryCode;
    }

    public String get4_District() {
        return _4_District;
    }

    public void set4_District(String _4_District) {
        this._4_District = _4_District;
    }

    public int get5_Population() {
        return _5_Population;
    }

    public void set5_Population(int _5_Population) {
        this._5_Population = _5_Population;
    }
}
