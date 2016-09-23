# assignment-4

Write a program to read a statement and determine wheter each token is a number, identifier, a reserved word, or special character. Suppose the following arrays are already given

char reservedWords[4][10] = {"cout<<", "for", "int", "while"}

char special[7][3] = {"=", "*", "-", ";", "(", ")", "<="}

first check whether the token is a reserved word, if not is it special symbol, if not is it a number or an identifier.

Sample I/O:

Enter a statement: for ( int tom_jones = 22 ; tom_jones <= 100 ; tom_jones = tom + 1 ) cout<< 2tom ;
