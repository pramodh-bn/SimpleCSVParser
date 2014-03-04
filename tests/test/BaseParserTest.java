package test;

import com.xyz.app.config.Configuration;
import com.xyz.app.data.PersonVO;
import com.xyz.app.parse.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dyanna on 2/20/14.
 */
public class BaseParserTest {
    Configuration configuration;
    ICustomParser parser = new CommaCustomParser();
    BaseParser baseParser;

    @Before
    public void setUp() throws Exception {
        PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
        writer.println("Abercrombie, Neil, Male, Tan, 2/13/1943");
        writer.close();
        configuration = new Configuration("test.txt", ",", "l,f,g,c,d", "MM/dd/yyyy");
        baseParser = new BaseParser(configuration, parser);
    }

    @After
    public void tearDown() throws Exception {
        try{
            File file = new File("test.txt");

            if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPersonDataList() throws Exception {
        Assert.assertNotNull("baser parser is not null ", baseParser);
        PersonVO person = new PersonVO("Abercrombie","Neil", "Male", (new SimpleDateFormat("MM/dd/yyyy")).parse("2/13/1943"),"Tan", "");
        ArrayList<PersonVO> personList = new ArrayList<PersonVO>();
        personList.add(person);
        Assert.assertEquals("Abercombie is the last name ", person.getLastName(), baseParser.getPersonDataList().get(0).getLastName());
    }

    @Test
    public void testCommaCustomParser() throws Exception {
        Assert.assertNotNull("baser parser is not null ", baseParser);
        parser = new CommaCustomParser();
        ArrayList<String> personString = new ArrayList<String>();
        personString.add("Abercrombie");
        personString.add("Neil");
        personString.add("Male");
        personString.add("Tan");
        personString.add("2/13/1943");
        PersonVO personVO = parser.parse(personString);
        Assert.assertEquals("Last name equal to Abercrombie", "Abercrombie", personVO.getLastName());
    }

    @Test
    public void testPipeCustomParser() throws Exception {
        Assert.assertNotNull("baser parser is not null ", baseParser);
        parser = new PipeCustomParser();
        ArrayList<String> personString = new ArrayList<String>();
        personString.add("Smith");
        personString.add("Steve");
        personString.add("D");
        personString.add("M");
        personString.add("Red");
        personString.add("3-3-1985");
        PersonVO personVO = parser.parse(personString);
        Assert.assertEquals("Last name equal to Smith", "Smith", personVO.getLastName());
    }

    @Test
    public void testSpaceCustomParser() throws Exception {
        Assert.assertNotNull("baser parser is not null ", baseParser);
        parser = new SpaceCustomParser();
        ArrayList<String> personString = new ArrayList<String>();
        personString.add("Kournikova");
        personString.add("Anna");
        personString.add("F");
        personString.add("F");
        personString.add("6-3-1975");
        personString.add("Red");
        PersonVO personVO = parser.parse(personString);
        Assert.assertEquals("Last name equal to Kournikova", "Kournikova", personVO.getLastName());
    }

}
