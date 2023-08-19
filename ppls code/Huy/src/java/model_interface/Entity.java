package model_interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public interface Entity {
    String getType();
    String[] getAttributesName();
    String getAttribute(String attribute_name);
    boolean setAttribute(String attribute_name, String value);
    boolean setAttributes(String[] attribute_names, String[] values);
    boolean delete();
    boolean undelete();
}