# The Diamond Kata
The aim is to create a function with that accepts a single character as input and returns a matrix of characters in a specific pattern. The matrix should be a perfect square whose dimensions depend on the input character. Starting at A each row in the pattern uses the next letter of the alphabet up to the argument character and then back down to A. The letters in the matrix form a diamond. The first row should include A vertically centered surrounded by padding. The second row should include two B characters in the center separated by a single padding character.  
Examples of the pattern are:  
-A-  
B-B  
-A-  
---A---  
--B-B--  
-C---C-  
D-----D  
-C---C-  
--B-B--  
---A---  
The simplest form is the diamond of A.  
A  
As you can see all diamonds exhibit vertical and horizontal, but not rotational, symmetry.