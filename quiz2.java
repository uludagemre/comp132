Quiz2Bonus Study Material - Quiz2 Questions
Here is the Quiz2 questions and their solutions:

Question 1: Implementing a mutable string data type

StringBuilder in Java provides a mutable string type. In this question you will implement your own mutable string data type: MutableString class for creating and manipulating dynamic string information.



 MutableString  stores characters of a string in a private char array:



 class MutableString {

     // representing a string as a char array;
     private char[] charArray; // array to store the characters of the string. 
                                                 // first character is at index 0

     private int       length;    // # of characters in the string

     …..

}

For example, If you store  “Hello” in a MutableString object with capacity  (size) 10, the length will be 5, and the array willl look like as follows:

    

 We can mutate this string by inserting, appending, or deleting characters. If you append “COMP” to the previous MutableString, the character array will look like:



 If you want to append further another string, “132”, however, you need to create a bigger character array since HelloCOMP132 will not fit into array of capacity 10.  If you allocate a new array of capacity 12, and copy the characters of the current string to the new array, then you can append 132. The new array will look like:



In this question, you are asked to implement MutableString class. Complete the given class ques1.MutableString.java (partially implemented). Before starting coding,  inspect the test class and the MutableString.java. Look at the instance variables, and the methods getLenght(), getCapacity(), toString() that are already implemented.You can add any private helper method for code reuse.

Your task is to complete the following constructors and methods:

MutableString()

This constructor creates an empty string (length 0), and with default capacity  of 10.

 MutableString(char[] charArray)

This constructor creates a string initialized with the characters in charArray. The capacity is the default value (10)  if the length of the parameter charArray  is less than or equal to the default capacity. Otherwise, the capacity is computed as length*2+2 where length is the length of the parameter charArray.

 All the methods below modifies the MutableString. If the modication requires a bigger capacity than the current capacity, the new capacity will be always computed as the “length*2+2” where length is the number of chars after the modification.

 public MutableString insert(int index, char c) 

It inserts char c at the position index. It returns a reference to ‘this’; Example: assume that the MutableString value is “Hello”.   Then, insert(1,’X’)  will result in “HXello”; 

 public MutableString deleteCharAt(int index)

It deletes the character at the position index. It returns a reference to ‘this’; It throws StringIndexOutOfBoundsException (defined in java.lang) if you try to delete at an invalid index. Example: assume that the MutableString value is “Hello”. Then, deleteAtChar(1)  will result in “Hllo”;  deleteAtChar(6) will cause an exception.

public MutableString append(MutableString str)

It appends str to the end of this. It returns a reference to ‘this’. str is unchanged.

 You can add any private helper method for code reuse.YOU ARE NOT ALLOWED TO USE ANY String OR StringBuilder in the solution, or any other collections (ArrayList….)



Question 2 : Regular Expressions, Files

 In this question, you are asked to clean a text file (somewhat corrupted) that contains various information on ‘users’. Each line in the file  has a name, lastname, various phone numbers, various emails, and some other information as well. All this information is stored in a file, one line per user, The first two words are first name and lastname (separated by spaces) but the rest of the line has no order or structure. Phone numbers, emails, and other information might be in any order or format. For example, the data file might be something like:

Jango Fett  Bounty hunter 0 544 2312 can be accessed at fett at gmail.com or other phone number 2123387777or5387777  as well fett_jango@yahoo.com

JarJar Binks leave a message at 5321111, journays with Qiu-Gon Jinn, possible email addresses are jar@jarjar jar@jarjar.com 232jar@star.com    0 455 3434  0544

Vober Dand Tarsunt from the planet Suntilla (@dand.suntilla.com)   who serves as a logistics controller (0 212 338 9999) for the Resistance (0 555 X 0 555 5555)during the attack on Starkiller Base (0555234A) in The Force Awakens (force@awakens). dand_vober_1@force.awakens.com or d_vober@ku.edu.tr . He also appears at the Resistance base on D'Qar in The Last Jedi.

What we want is to list users and their “valid” mobile  phone numbers and “valid” email addresses.

Valid mobile phone number:  Any text that looks like:
0 5XX XXXX    or  0 5XXXXXX  or  05XX XXXX or 05XXXXXX   or 5XXXXXX  or 5XX XXXX   where X is any digit.

Valid email address: any text    <Name>@<Domain_1>.<Domain_2>.  .<Domain_n> where:<Name> :

starts with a letter  (letter means lower or uppercase letters)
can contain any number of  letters  or digits,
can contain at most one  _  character (underscore)
no other characters
<Domain_i>:

must have at least one letter or digit
can contain only letters or digits
<Domain_i> and <Domain_i+1> is separated by a single ‘.’

<Domain_n>  (last one) can contain only 2 or 3 letters.

A valid email contains at least two domains.

In the text line, a valid email is preceded at least by one space character.

Examples:     fett_jango@yahoo.com but not fett_jango_email@yahoo.com ,  _fett@yahoo.com

                       feTT@Email.yahoo.com  but not   feTT@yahoo.comm, feTT@com

You are asked to write a program to read a user text file, and find valid phone and valid emails of each user. Your program will write output into a file. The files are under the same directory as your class (ProcessUsers.java) that you need to complete. Your program will produce the following output for the above example file.

Jango Fett:

     mobile phone: 0 544 2312

     mobile phone: 5387777

     valid email:  fett_jango@yahoo.com

------

JarJar Binks:

     mobile phone: 5321111

     valid email:  jar@jarjar.com

------

Vober Dand:

     mobile phone: 0 555 5555

     valid email:  d_vober@ku.edu.tr

------ 

Complete ProcessUsers.java to solve this question using Regular Expressions, Scanner, and Formatter.
There is already a test input file (users.txt)   in the same directory where ProcessUsers.java is.
Test program Quest2Test.java gives the name of the  output file. The file should be created  again in the same directory.
Make sure:
Look at the QuizTest2 and ProcessUsers.java
Input and output files are under the same directory as ProcessUsers.java file.
ProcessUsers.java handles exceptions FileNotFoundException and NoSuchFileException. It prints “File not found” message when such an exception happens.
Your code should close all opened files automatically, even in the case of exceptions.
Item
Quiz2Bonus Study Material - Solutions
//// Ques 1 soln  
package ques1;  
  
public class MutableString {  
    private static int DEFAULT_SIZE = 10; // default size of the character array  
      
    private char[] charArray;  // string is stored in this array, first char is at index 0  
    private int length;        // number of characters stored  
      
    public int getLength() {return length;} // return length of string stored  
    public int getCapacity() {return charArray.length;} // return the current capacity  
      
    public String toString() {  
         return new String(charArray,0,length);  
    }  
      
    //*******  DO NOT CHANGE ANYTHING BEFORE THIS LINE***********  
    //*******  WRITE YOUR CODE BELOW                  ***********  
      
    public MutableString() {  
        charArray = new char[DEFAULT_SIZE]; // capacity is default size  
        length = 0;  
  
    }  
      
    public MutableString(char[] charArray) {  
        this();  
        if (getCapacity() < charArray.length)   
            growArray(charArray.length*2+2);  
        for(int i=0; i<charArray.length; i++) {  
            this.charArray[i]=charArray[i];  
        }  
        length = charArray.length;  
        //System.out.printf("%s length %d capacity %d%n",new String(charArray,0,length),length,capacity);  
    }  
      
      
    public MutableString insert(int index, char c) {  
        if (length+1 > getCapacity()) {  
            growArray((length+1)*2+2);  
        }  
        for(int i=length; i>index; i--) {  
            charArray[i]=charArray[i-1];  
        }  
        charArray[index] = c;  
        length++;  
        return this;  
    }  
      
  
    public MutableString deleteCharAt(int index) {  
          
        if (index >= length ||  index < 0)   
            throw new StringIndexOutOfBoundsException("String index out of range: "+ index);  
        for(int i=index; i<length-1; i++) {  
            charArray[i]=charArray[i+1];  
        }  
        length--;  
        return this;  
    }  
      
    public MutableString append(MutableString str) {  
        if (str.length+length > getCapacity()) {  
            growArray((str.length+length)*2+2);  
        }  
        for(int i=0; i<str.charArray.length; i++) {  
            this.charArray[length+i]=str.charArray[i];  
        }  
        length += str.length;  
        return this;  
    }  
      
    private void growArray(int newCapacity) {  
        char[] newArray = new char[newCapacity];  
        for(int i=0; i<length; i++) {  
            newArray[i]=charArray[i];  
        }  
        charArray = newArray;  
        //System.out.printf("grow: %s length %d capacity %d%n",new String(charArray,0,length),length,capacity);  
    }  
      
  
}  
 

//// Ques 2 soln  
package ques2;  
  
import java.nio.file.NoSuchFileException;  
import java.nio.file.Paths;  
import java.util.Scanner;  
import java.util.Formatter;  
import java.util.NoSuchElementException;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
  
public class ProcessUsers {  
  
    private static String emailRegExpr = "\\s+[a-zA-Z][a-zA-Z0-9]*_?[a-zA-Z0-9]*@([A-Za-z0-9]+\\.)+[A-Za-z]{2,3}";  
    private static String phoneRegExpr = "(0|0\\s)?5[0-9]{2}\\s?[0-9]{4}";  
      
      
    public static  void processUserFile(String inputFile, String outputFile)  {  
          
          
        Pattern phoneExpr = Pattern.compile(phoneRegExpr);  
        Pattern emailExpr = Pattern.compile(emailRegExpr);  
                  
        try (Scanner input = new Scanner(Paths.get("./src/ques2/"+inputFile));  
             Formatter output = new Formatter("./src/ques2/"+outputFile);  
            ) {  
            while(input.hasNext()) {  
                String name = input.next();  
                String lastname = input.next();  
                String user = input.nextLine();  
                output.format("%s %s:%n", name,lastname);  
                // System.out.println(user);  
                Matcher matcherPhone = phoneExpr.matcher(user);  
                Matcher matcherEmail = emailExpr.matcher(user);  
                  
                while (matcherPhone.find()) {  
                    output.format("     mobile phone: %s%n",matcherPhone.group());  
                    // System.out.println(matcherPhone.group());  
                }  
                while (matcherEmail.find()) {  
                    output.format("     valid email: %s%n",matcherEmail.group());  
                    // System.out.println(matcherEmail.group());  
                }  
                output.format("------%n");  
                  
            }  
        }     
        catch (FileNotFoundException | NoSuchFileException e) {  
            System.err.println(e+": File not found");  
        }  
        catch (IOException e) {  
            System.err.println(e);  
        }  
          
                  
                  
          
    }  
  
}  
