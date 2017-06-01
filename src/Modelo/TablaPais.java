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
public class TablaPais {
    
    private int _1_id_Country;
    private String _2_Code;
    private String _3_Name;
    private String _4_Continent;
    private String _5_Region;
    private int _6_Population;
    private String _7_Capital;

    public TablaPais() {
        //
    }

    public TablaPais(String _2_Code, String _3_Name, String _4_Continent, String _5_Region, int _6_Population, String _7_Capital) {
        this._2_Code = _2_Code;
        this._3_Name = _3_Name;
        this._4_Continent = _4_Continent;
        this._5_Region = _5_Region;
        this._6_Population = _6_Population;
        this._7_Capital = _7_Capital;
    }

    public TablaPais(int _1_id_Country, String _2_Code, String _3_Name, String _4_Continent, String _5_Region, int _6_Population, String _7_Capital) {
        this._1_id_Country = _1_id_Country;
        this._2_Code = _2_Code;
        this._3_Name = _3_Name;
        this._4_Continent = _4_Continent;
        this._5_Region = _5_Region;
        this._6_Population = _6_Population;
        this._7_Capital = _7_Capital;
    }

    public int get1_id_Country() {
        return _1_id_Country;
    }

    public void set1_id_Country(int _1_id_Country) {
        this._1_id_Country = _1_id_Country;
    }

    public String get2_Code() {
        return _2_Code;
    }

    public void set2_Code(String _2_Code) {
        this._2_Code = _2_Code;
    }

    public String get3_Name() {
        return _3_Name;
    }

    public void set3_Name(String _3_Name) {
        this._3_Name = _3_Name;
    }

    public String get4_Continent() {
        return _4_Continent;
    }

    public void set4_Continent(String _4_Continent) {
        this._4_Continent = _4_Continent;
    }

    public String get5_Region() {
        return _5_Region;
    }

    public void set5_Region(String _5_Region) {
        this._5_Region = _5_Region;
    }

    public int get6_Population() {
        return _6_Population;
    }

    public void set6_Population(int _6_Population) {
        this._6_Population = _6_Population;
    }

    public String get7_Capital() {
        return _7_Capital;
    }

    public void set7_Capital(String _7_Capital) {
        this._7_Capital = _7_Capital;
    } 
}
