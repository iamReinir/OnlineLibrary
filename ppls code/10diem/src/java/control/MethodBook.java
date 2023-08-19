/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import model_interface.Entity;
import stubForEntity.BookSetStub;
import stubForEntity.BookStub;

/**
 *
 * @author LENOVO
 */
public class MethodBook {

    public MethodBook() {

    }

    public static void Addbook(String bookId, String Title, String Author, String Year, String Summary) {
        BookSetStub s = new BookSetStub();
        BookStub bookstub = new BookStub(bookId, Title, Author, Year, Summary);
        s.add(bookstub);

    }
    public  void AccBook(boolean Acc,String Id){
        if(Acc){
            BookSetStub book =new BookSetStub();
            book.getEntity(Id).setAttribute(isaccept, true);
            //bên em có trường isaccept bên chị ko nên lỗi chỗ ni nên em bỏ vào sẽ chạy đc
            
            
        }
        
    }
    
        }
    
    
         


