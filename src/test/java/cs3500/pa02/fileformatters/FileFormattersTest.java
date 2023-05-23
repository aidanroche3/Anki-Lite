package cs3500.pa02.fileformatters;

/**
 * Abstract class for testing file formatter classes
 */
public class FileFormattersTest {

  protected String arraysAndTest = """ 
        # This is a test file
                
        ## Heading
                
        # Java Arrays
        - [[An **array** is a collection of variables of the same type]], referred to
          by a common name.
        - In Java, arrays are objects, and must be created dynamically (at runtime).
        - [[T/F An array can contain multiple types:::false]]
                
        ## Declaring an Array
        - [[General Form: type[] arrayName;]]
        - ex: int[] myData;
        - [[T/F An array's size can be changed:::false]]
                
        - The above only creates a reference to an array object, but no array has
          actually been created yet.
                
        ## Creating an Array (Instantiation)
        - [[General form:  arrayName = new type[numberOfElements];]]
        - ex: myData = new int[100];
                
        - Data types of the reference and array need to match.
        - [[How do you initialize an integer array in Java?:::int[] = {..., ..., ...};]]
        - [[numberOfElements must be a positive Integer.]]
        - [[Gotcha: Array size is not modifiable once instantiated. ]]
        - [[ Testing extra edge cases: ::: answer with ::]]
        - [[ Testing on new line::: answer\s
        is split up]]
        - [[ T/F Testing with two colons ::]]
                
        ... more brilliance captured...\s
                
        """;
}
