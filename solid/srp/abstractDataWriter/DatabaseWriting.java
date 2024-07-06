package io.github.ndimovt.solid.srp.abstractDataWriter;

import io.github.ndimovt.solid.srp.dataSaver.SaveBookInfo;
import io.github.ndimovt.solid.srp.dataSaver.SaveInvoiceInvo;
import io.github.ndimovt.solid.srp.entity.Book;
import io.github.ndimovt.solid.srp.entity.Invoice;

public abstract class DatabaseWriting implements SaveInvoiceInvo, SaveBookInfo {
    public void saveBook(Book book){
        System.out.println("Not implemented yet");
    }
    public void saveInvoice(Invoice invoice){
        System.out.println("Not implemented yet");
    }
}
