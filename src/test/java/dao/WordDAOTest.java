package dao;

import entity.Word;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ANTON DUKHANIN on 06.02.2018.
 */
public class WordDAOTest {
    @Test
    public void translateInRus() throws Exception {
        Word word = new Word();
        word.setEng("яt");
        Assert.assertEquals("кот",(int)word.getEng().charAt(0));
    }

}