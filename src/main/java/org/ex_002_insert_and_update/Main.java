package org.ex_002_insert_and_update;

import org.apache.log4j.Logger;
import org.ex_002_insert_and_update.entity.Author2;
import org.ex_002_insert_and_update.entity.Book2;

import java.awt.print.Book;

/**
 * Created by Asus on 04.11.2017.
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
         AuthorHelper ah = new AuthorHelper();
         BookHelper bh = new BookHelper();

         Author2 author = new Author2();
         author.setName("Lesia");
         author.setLastName("Ukrainka");
         ah.addAuthor(author);//Добавление нового автора
            ah.changeNameById(1, "Orak");
            bh.addBook(new Book2("Book", 1));
            bh.changeNameById(1, "Over");

            bh.bookInfo(2);
 //       ah.addManyAuthors(author);

//        Author2 author = ah.getAuthorById(38);
//        author.setName("Aleksandr");
//        author.setLastName("Pushkin");
//        ah.addAuthor(author);//Будет апдейт автора или добавление?
//        ah.addAuthor(null);


    }

}
