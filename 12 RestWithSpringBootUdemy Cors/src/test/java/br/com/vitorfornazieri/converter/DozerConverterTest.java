package br.com.vitorfornazieri.converter;

import br.com.vitorfornazieri.converter.mocks.MockBook;
import br.com.vitorfornazieri.converter.mocks.MockPerson;
import br.com.vitorfornazieri.restwithspringbootudemy.converter.DozerConverter;
import br.com.vitorfornazieri.restwithspringbootudemy.data.model.Book;
import br.com.vitorfornazieri.restwithspringbootudemy.data.model.Person;
import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.BookVO;
import br.com.vitorfornazieri.restwithspringbootudemy.data.vo.PersonVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DozerConverterTest {
    MockPerson inputObjectPerson;
    MockBook inputObjectBook;

    @Before
    public void setUp() {
        inputObjectPerson = new MockPerson();
        inputObjectBook = new MockBook();
    }

    //Begin Person Tests
    @Test
    public void parseEntityPersonToPersonVOTest() {
        PersonVO output = DozerConverter.parseObject(inputObjectPerson.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListPersonToPersonVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObjectPerson.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Male", outputZero.getGender());

        PersonVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());

        PersonVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assert.assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parsePersonVOToEntityPersonTest() {
        Person output = DozerConverter.parseObject(inputObjectPerson.mockVO(), Person.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parserPersonVOListToEntityPersonListTest() {
        List<Person> outputList = DozerConverter.parseListObjects(inputObjectPerson.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());

        Person outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assert.assertEquals("Male", outputTwelve.getGender());
    }
    //End Person Tests

    //Begin Book Tests
    @Test
    public void parseEntityBookToBookVOTest() throws ParseException {
        BookVO output = DozerConverter.parseObject(inputObjectBook.mockEntity(), BookVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals("Title Test0", output.getTitle());
        //Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"), output.getLaunch_date().getDate());
        //Assert.assertEquals(10.0, output.getPrice().doubleValue());
    }

    @Test
    public void parseEntityListBookToBookVOListTest() throws ParseException {
        List<BookVO> outputList = DozerConverter.parseListObjects(inputObjectBook.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals("Title Test0", outputZero.getTitle());
        //Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"), outputZero.getLaunch_date().getDate());
        //Assert.assertEquals(10.0, outputZero.getPrice().doubleValue());

        BookVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals("Title Test7", outputSeven.getTitle());
        //Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"), outputSeven.getLaunch_date().getDate());
        //Assert.assertEquals(20.0, outputSeven.getPrice().doubleValue());

        BookVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
        //Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"), outputTwelve.getLaunch_date().getDate());
        //Assert.assertEquals(10.0, outputTwelve.getPrice().doubleValue());
    }

    @Test
    public void parseBookVOToEntityBookTest() throws ParseException {
        Book output = DozerConverter.parseObject(inputObjectBook.mockVO(), Book.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals("Title Test0", output.getTitle());
        //Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"), output.getLaunch_date().getDate());
        //Assert.assertEquals(10.0, output.getPrice().doubleValue());
    }

    @Test
    public void parserBookVOListToEntityBookListTest() throws ParseException {
        List<Book> outputList = DozerConverter.parseListObjects(inputObjectBook.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals("Title Test0", outputZero.getTitle());
        //Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"), outputZero.getLaunch_date().getDate());
        //Assert.assertEquals(10.0, outputZero.getPrice().doubleValue());

        Book outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals("Title Test7", outputSeven.getTitle());
        //Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"), outputSeven.getLaunch_date().getDate());
        //Assert.assertEquals(20.0, outputSeven.getPrice().doubleValue());

        Book outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
        //Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("25/10/1994"), outputTwelve.getLaunch_date().getDate());
        //Assert.assertEquals(10.0, outputTwelve.getPrice().doubleValue());
    }
    //End Book Test

}
