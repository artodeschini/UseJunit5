import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Artur on 04/06/18.
 * Simple test for use JUnit 5 and new features
 */
//@Disabled if I can run any test in this class I can use @Disabled in a class
public class StringTest {

    private String aString = null;

    @BeforeAll
    public static void useBeforAll() {
        System.out.println("Initialize the connection of DataBase ");
    }

    @AfterAll
    public static void useAfterAll() {
        System.out.println("Close the connection of DataBase ");
    }

    @BeforeEach
    public void initTest(TestInfo info ) {
        System.out.println("Test method " + info.getDisplayName() );
    }

    @AfterEach
    public void closeTest(TestInfo info) {
        System.out.println("End test method " + info.getDisplayName() );
    }

    @Test
    public void lengthTestBasic() {
        int actualLength = "ABCD".length();
        int expectedLength = 4;

        assertEquals( expectedLength, actualLength );

        //Assert is lenght == 4
        //write test code
        //Invoke method square(4) => 4 x 4 = 16 CUT Core Under Test
        //check in place - 16 => Assertions

    }

    @Test
    public void toUpperCaseBasic() {
        String str = "abcd";
        String result = str.toUpperCase();

        assertNotNull( result );
        //assertNull();
        assertEquals( "ABCD" , result);

    }

    @Test
    public void checkIsObjectNull() {
        String str = null;

        assertNull( str );
    }

    @Test
    public void containsBasic() {
        String str = "abcd";
        //not has 'efg' in str
        boolean result = str.contains("efg");

        assertEquals( false , result);
        //or use
        assertFalse( result );
        //or use for boolean expected true value
        //assertTrue( result );
    }

    @Test
    public void slipeBasic() {
        String str = "abc dfg hij";
        String actual[] = str.split(" ");
        String expected[] = new String[] {
                "abc",
                "dfg",
                "hij"
        };

        assertArrayEquals( expected , actual );
    }

    @Test
    @DisplayName("when the thowException thow a NullPointerException")
    public void thowException() {
        String str = null;

        assertThrows(
                NullPointerException.class,
                () -> {
                    str.length();
                });
    }

    @Test
    public void lengthMoreThanZero() {
        assertTrue( "ABCDE".length() > 0  );
        assertTrue( "ABCD".length() > 0  );
        assertTrue( "ABC".length() > 0  );
        assertTrue( "AB".length() > 0  );
        assertTrue( "A".length() > 0  );
    }

    @ParameterizedTest
    @ValueSource(strings= { "ABCD" , "ABC", "AB" } )
    public void lengthMoreThanZeroParametrize(String string) {
        assertTrue( string.length() > 0 );
    }

    @ParameterizedTest
    @CsvSource( value =  { "abcd,ABCD", "abc,ABC", "ab,AB", "a,A"})
    // to default delimiter is ','
    public void multipleUpperCaseCheck(String str, String capitalized) {
        assertEquals( capitalized, str.toUpperCase() );
    }

    //Sample to give name to ParameterizedTest
    @ParameterizedTest( name = "the string {0} length is {1}") //change de out put {0} before ',' and {1} after ',
    @CsvSource( value =  { "abcd,4", "abc,3", "ab,2", "a,1", "'',0"})
    public void multipleUpperLenght(String str, int expectedLength) {
        assertEquals( str.length(), expectedLength );
    }

    @Test
    @RepeatedTest( 3 ) // only in JUnit 5
    @DisplayName("repatManyTimesTest")
    public void repatManyTimesTest() {
        assertEquals("same", "same");

    }

    @Test
    public void performedTest() {
        assertTimeout( Duration.ofSeconds(5), () -> {
            for (int i = 0; i < 100; i++ ) {
                System.out.println( i );
            }
        });

    }

    @Test
    @Disabled
    @DisplayName("noRun")
    public void noRun() {
        assertTrue( true );
    }

    @Nested
    @DisplayName("For a empty String")
    class EmptyStringTest {

        @BeforeEach
        void setEmpty() {
            aString = "";
        }

        @Test
        @DisplayName("length should be 0 ")
        void lengthZero() {
            assertEquals( 0 , aString.length() );
        }


        @Test
        @DisplayName("upper case is zero should be 0 ")
        void toUpperCaseNested(){
            assertEquals( "", aString.toUpperCase() );
        }
    }

    @Nested
    @DisplayName("For large strings")
    class LargeStringTest {

        @BeforeEach
        @DisplayName("init aString")
        void setLargeString() {
            StringBuilder stringBuilderTableAscii = new StringBuilder();
            for ( int i = 32; i < 127 ; i++ ) {
                stringBuilderTableAscii.append( (char) i );
            }
            aString = stringBuilderTableAscii.toString();
        }

        @Test
        void test() {

        }

    }
}
