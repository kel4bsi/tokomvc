/*
 * DILARANG MENGHAPUS ATAU MENGEDIT COPYRIGHT INI.
 * 
 * Copyright 2008 echo.khannedy@gmail.com. 
 * All rights reserved.
 * 
 * Semua isi dalam file ini adalah hak milik dari echo.khannedy@gmail.com
 * Anda tak diperkenankan untuk menggunakan file atau mengubah file
 * ini kecuali anda tidak menghapus atau merubah lisence ini.
 * 
 * File ini dibuat menggunakan :
 * IDE        : NetBeans
 * NoteBook   : Acer Aspire 5920G
 * OS         : Windows Vista
 * Java       : Java 1.6
 */
package toko.view.usu;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author usu
 */
public class Button extends usu.widget.ButtonGlass {

    /*
     * Serial version UID
     */
    private static final long serialVersionUID = 1L;

    public Button() {
        super();
        setFont(getFont().deriveFont(Font.BOLD));
        setForeground(Color.WHITE);
        setRoundRect(true);
    }
}
