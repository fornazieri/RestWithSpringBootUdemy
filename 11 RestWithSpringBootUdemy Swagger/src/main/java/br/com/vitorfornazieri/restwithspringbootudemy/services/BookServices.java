package br.com.vitorfornazieri.restwithspringbootudemy.services;

import br.com.vitorfornazieri.restwithspringbootudemy.converter.DozerConverter;
import br.com.vitorfornazieri.restwithspringbootudemy.data.model.Book;
import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.BookVO;
import br.com.vitorfornazieri.restwithspringbootudemy.exception.ResourceNotFoundException;
import br.com.vitorfornazieri.restwithspringbootudemy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    BookRepository repository;

    public BookVO create(BookVO book){
        var entity = DozerConverter.parseObject(book, Book.class);
        var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public List<BookVO> findAll(){
        return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
    }

    public BookVO findById(Long id){
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, BookVO.class);
    }

    public BookVO update(BookVO person){
        var entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(person.getAuthor());
        entity.setTitle(person.getTitle());
        entity.setPrice(person.getPrice());
        entity.setLaunch_date(person.getLaunch_date());
        var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public void delete(Long id){
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
