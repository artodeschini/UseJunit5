README.md
# UseJunit5
Test With JUnit 5

To create a simple test

Create a class
in the class

create a void method
use the @Test

use the basics 

assertEquals
expected / actual

check is a object is not null
assertNotNull 

check is a object is null
assertNull

for boolean values
check is actual is false
assertFalse

check is actual is true
assertTrue

to Array
check is one array is same than another
assertArrayEquals( expected , actual );
this check all position same equals and the size is the same

the annotation @BeforeEach
is execute before (antes) all test
if you has 3 test the method is run 3 times

the annotation @AfterEach
is execute after (depois) all test
if you has 3 test the method is run 3 times

the methods with @BeforeEach and @AfterEach
you can use a parameter TestInfo
with a instance o TestInfo you can get the name of method

With the JUnit 4 use @Before and @After but the TestInfo not present
TestInfo is only in JUnit 5

You can use the @BeforeAll to connect the database for exemple
this method need to be static
the method is call frist before than all tests

You can use the @AfterAll to close connect the database for exemple
this method need to be static
the method is call after before than all tests

In JUnit 5 the word public is not required in test's

the annotation @DisplayName show the message that you put in before run the test

@ParameterizedTest
you can use multiple values with this annotation
use with the @ValueSource
sample
@ParameterizedTest
@ValueSource(strings= { "ABCD" , "ABC", "AB" } )
void lengthMoreThanZeroParametrize(String string) {
    assertTrue( string.length() > 0 );
}

//Sample to give name to ParameterizedTest
I can change the output of test with
@ParameterizedTest( name = "the string {0} length is {1}") //change de out put {0} before ',' and {1} after ',

I can repeat many time with RepeatedTest
@RepeatedTest( 3 )

I can try de performace with assertTimeout
Use a the aegs : 
aTime, () -> { <my source> }   
assertTimeout( Duration.ofSeconds(5), () -> {
            for (int i = 0; i < 100; i++ ) {
                System.out.println( i );
            }
        });


I can disable a test @Disabled in JUnit 5 with 4 use @Ignored

If I can not run any Test in a class I use @Disable in the class 
when I use in classe any test not run

the annotation @Nested 
I can use to use a nested class when a run a test

JUnit 5 x JUnit 4 != 
@BeforeAll instead of @BeforeClass
@AfterAll instead of @AfterClass
@BeforeEach instead of @Before
@AfterEach instead of @After
@Disable instead of @Ignote
@Tag instead of @Category
assertThrows instead of expected attibute
assertTimeout instead of timeout attibute

New in JUnit 5
@Nested for nested tests
@RepeatedTest to execute tests mulpiple times

Best pratices for good unit test
1 Readable
Look at the test and you know what is begin tested
(I can read the class test and know what the test is do in 15 seconds)

2 Fast
what happerns if unit tests take a long time to run?
(think abaout what the advantage of unit test is lost 2 hours?)

3 Isolated
Fails only when there is an issue whith code!
(is not good if they star failing because of an external depedency not avaliable then the fail)

4 Run often
What is the use having unit test which are note run frenquently?
What happens if you do not commit code often?

