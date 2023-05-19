# Java Arrays
- [[An **array** is a collection of variables of the same type]], referred to
  by a common name.
- In Java, arrays are objects, and must be created dynamically (at runtime).
- [[Where are arrays stored in memory?:::the heap]]

## Declaring an Array
- [[General Form: type[] arrayName;]]
- ex: int[] myData;
- [[T/F Arrays can hold multiple data types:::false]]

- The above only creates a reference to an array object, but no array has
  actually been created yet.

## Creating an Array (Instantiation)
- [[General form:  arrayName = new type[numberOfElements];]]
- ex: myData = new int[100];

- Data types of the reference and array need to match.
- [[numberOfElements must be a positive Integer.]]
- [[Gotcha: Array size is not modifiable once instantiated. ]]

... more brilliance captured... 
