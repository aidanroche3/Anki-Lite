package cs3500.pa02.fileformatters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class QuestionAndAnswerTest {
  String arraysAndTest = """ 
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
  String formatted = """
      [Q]T/F An array can contain multiple types[A]false[D]HARD
      [Q]T/F An array's size can be changed[A]false[D]HARD
      [Q]How do you initialize an integer array in Java?[A]int[] = {..., ..., ...};[D]HARD
      [Q] Testing extra edge cases: [A] answer with ::[D]HARD
      [Q] Testing on new line[A] answer is split up[D]HARD
      """;

  @Test
  public void testExtract() {
    assertEquals(formatted, new QuestionAndAnswer(arraysAndTest).extract());
  }

}