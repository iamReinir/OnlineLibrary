/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model_interface.Entity;

/**
 *
 * @author PC
 */
public class user implements Entity{
    public String id;
    public String username;
    public String password;
    public String email;
    public String telephone_number;
    public String role;
    public String is_delete = "false";
    public String register_date;
    public String last_modified_at;

    public user() {
    }

    public user(String id, String username, String password, String email, String telephone_number, String role, String is_delete, String register_date, String last_modified_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone_number = telephone_number;
        this.role = role;
        this.is_delete = is_delete;
        this.register_date = register_date;
        this.last_modified_at = last_modified_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getLast_modified_at() {
        return last_modified_at;
    }

    public void setLast_modified_at(String last_modified_at) {
        this.last_modified_at = last_modified_at;
    }

    
    
    @Override
    public String getType() {
        return "user";
    }

    @Override
    public String[] getAttributesName() {
        return new String[]{
            "id",
            "username",
            "password",
            "email",
            "telephone_number",
            "role",
            "is_delete",
            "register_date",
            "last_modified_at"
        };
    }

    @Override
    public String getAttribute(String attribute_name) {
        switch (attribute_name) {
            case "id":
                return id;
            case "username":
                return username;
            case "password":
                return password;
            case "email":
                return email;
            case "telephone_number":
                return telephone_number;
            case "role":
                return role;
            case "is_delete":
                return is_delete;
            case "register_date":
                return register_date;
            case "last_modified_at":
                return last_modified_at;
            default:
                return "------ I’m sorry but I’m not sure what you’re asking for. "
                        + "Could you please clarify your request? "
                        + "If you’re looking for a summary of a user, "
                        + "I suggest you provide me with the id "
                        + "and username and password so I can help you better.\n";
        }
    }

    @Override
    public boolean setAttribute(String attribute_name, String value) {
        switch (attribute_name) {
            case "id":
                id = value;
                break;
            case "username":
                username = value;
                break;
            case "password":
                password = value;
                break;
            case "email":
                email = value;
                break;
            case "telephone_number":
                telephone_number = value;
               break;
            case "role":
                role = value;
                break;
            case "is_delete":
                is_delete = value;
                break;
            case "register_date":
                register_date = value;
                break;
            case "last_modified_at":
                last_modified_at = value;
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public boolean setAttributes(String[] attribute_names, String[] values) {
        if(attribute_names.length == values.length){
            for(int i = 0; i <= attribute_names.length; i++){
                attribute_names[i] = values[i];
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete() {
        is_delete = "true";
        return true;
    }

    @Override
    public boolean undelete() {
        is_delete = "false";
        return false;
    }
}
