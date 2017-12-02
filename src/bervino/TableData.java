/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package bervino;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AdityaHarisCandra
 */
public class TableData {
    
    private final StringProperty nb;
    private final StringProperty kb;
    private final StringProperty nl;
    private final StringProperty tgl;
    private final StringProperty np;
    
    public TableData(String nb, String kb, String nl, String tgl, String np) {
        this.nb = new SimpleStringProperty(nb);
        this.kb = new SimpleStringProperty(kb);
        this.nl = new SimpleStringProperty(nl);
        this.tgl = new SimpleStringProperty(tgl);
        this.np = new SimpleStringProperty(np);
    }
    public String getnb() {
        return nb.get();
    }

    public String getkb() {
        return kb.get();
    }

    public String getnl() {
        return nl.get();
    }
    
    public String gettgl() {
        return tgl.get();
    }
    
    public String getnp() {
        return np.get();
    }
    
    public void setnb(String value) {
        nb.set(value);
    }

    public void setkb(String value) {
        kb.set(value);
    }

    public void setnl(String value) {
        nl.set(value);
    }
    
    public void tgl(String value) {
        tgl.set(value);
    
    }
    
    public void np(String value) {
        np.set(value);
    
    }
    
    public StringProperty nbProperty() {
        return nb;
    }

    public StringProperty kbProperty() {
        return kb;
    }

    public StringProperty nlProperty() {
        return nl;
    }
    
    public StringProperty tglProperty() {
        return tgl;
    }
    
    public StringProperty npProperty() {
        return np;
    }
}
