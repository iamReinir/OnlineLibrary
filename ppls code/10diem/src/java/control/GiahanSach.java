/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
/**
 *
 * @author LENOVO
 */
public class GiahanSach {
    
    private String title;
    private LocalDate borrowedDate;

    public GiahanSach(String title, LocalDate borrowedDate) {
        this.title = title;
        this.borrowedDate = borrowedDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public boolean isOverdue(LocalDate returnDate, int maxDays) {
        LocalDate dueDate = borrowedDate.plusDays(maxDays);
        return returnDate.isAfter(dueDate);
    }

    public long daysUntilDue(LocalDate returnDate, int maxDays) {
        LocalDate dueDate = borrowedDate.plusDays(maxDays);
        return ChronoUnit.DAYS.between(returnDate, dueDate);
    }

    public static void main(String[] args) {
        LocalDate borrowedDate = LocalDate.of(2023, 8, 1);
        GiahanSach book = new GiahanSach("The Catcher in the Rye", borrowedDate);
        int maxDaysToBorrow = 14;
        LocalDate returnDate = LocalDate.of(2023, 8, 15);

        if (book.isOverdue(returnDate, maxDaysToBorrow)) {
            System.out.println("Quyển sách \"" + book.getTitle() + "\" đã quá hạn.");
            //day la doan code true thi them ngay gia han sach, khoong thì in ra dòng Đã tới ngày trả sách 
            
            if(true){
                book.setBorrowedDate( LocalDate.of(maxDaysToBorrow, maxDaysToBorrow, maxDaysToBorrow));
            }else{
                System.out.println("Da toi ngay tra sach ");
                
            }
        } else {
            
            long daysLeft = book.daysUntilDue(returnDate, maxDaysToBorrow);
            System.out.println("Quyển sách \"" + book.getTitle() + "\" còn " + daysLeft + " ngày để trả.");
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    
    
}
