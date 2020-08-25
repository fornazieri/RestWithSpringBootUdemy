package br.com.vitorfornazieri.converter.mocks;

import br.com.vitorfornazieri.restwithspringbootudemy.data.model.Book;
import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.BookVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }

    private Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.longValue());
        book.setAuthor("Author Test" + number);
//        try {
//            book.setLaunch_date(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        book.setPrice(((number % 2)==0) ? 10D : 20D);
        book.setTitle("Title Test" + number);
        return book;
    }

    private BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setKey(number.longValue());
        book.setAuthor("Author Test" + number);
//        try {
//            book.setLaunch_date(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        book.setPrice(((number % 2)==0) ? 10.0 : 20.0);
        book.setTitle("Title Test" + number);
        return book;
    }

}
