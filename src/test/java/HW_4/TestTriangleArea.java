package HW_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTriangleArea {

    private static Logger logger = LoggerFactory.getLogger(TestTriangleArea.class);

    @BeforeAll
    static void beforeAll(){
        logger.info("Первый тест");
    }

    @BeforeEach
    void beforeEach(){
        logger.warn("Следующий тест");
    }


    @Test
    void  triangleTest(){

      int result = new TriangleArea().triangle();

        Assertions.assertNotNull(result);


    }
    @Test
    void  triangleTest1(){

        int result = new TriangleArea().triangle();

        Assertions.assertEquals(6, result);


    }
    @Test
    void  triangleTest2(){

        int result = new TriangleArea().triangle();

        Assertions.assertNotEquals(7, result);

    }

    @Test
    @ParameterizedTest
    @ValueSource(ints = {7, 6, 3})
     void triangleTest3(){
        int result = new TriangleArea().triangle();
        Assertions.assertEquals(6, result);
    }

}
