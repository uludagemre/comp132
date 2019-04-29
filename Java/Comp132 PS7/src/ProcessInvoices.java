// Exercise 17.12: ProcessInvoices.java
// Processing Invoices with lambdas and streams.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
public class ProcessInvoices {
	
   public static void main(String[] args) {
      Invoice[] invoices = {
         new Invoice(83, "Electric sander", 7, 57.98),
         new Invoice(24, "Power saw", 18, 99.99),
         new Invoice(7, "Sledge hammer", 11, 21.50),
         new Invoice(77, "Hammer", 76, 11.99),
         new Invoice(39, "Lawn mower", 3, 79.50),
         new Invoice(68, "Screwdriver", 106, 6.99),
         new Invoice(56, "Jig saw", 21, 11.00),
         new Invoice(3, "Wrench", 34, 7.50)
      };
      ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
      
     
      

      /* 
       * Use lambdas and streams to sort the Invoice objects by PartDescription, 
       * then display the results.
       * */
      System.out.println("Invoices sorted by part description:");
      Arrays.stream(invoices)
      .sorted(Comparator.comparing(Invoice::getPartNumber))
      .forEach(System.out::println);
//	  slist.forEach(e -> System.out.println("Part Desription:"+ e.getPartDescription()+", Part Number: "+e.getPartNumber()+", Quantity:"+e.getQuantity()+", Price:"+e.getPrice()));
      
      /*
       * Your solution
       */
      
	  
      /*
       * Use lambdas and streams to sort the Invoice objects by Price, 
       * then display the results.
       */
      System.out.printf("%nnInvoices sorted by price:%n");
      /*
       * Your solution
       */

      /*
       * Use lambdas and streams to map each Invoice to its PartDescription and Quantity,
       * sort the results by Quantity, then display the results.
       */
      System.out.printf("%nInvoices mapped to description and quantity:%n");
      /*
       * Your solution
       */

      /*
       * Use lambdas and streams to map each Invoice to its PartDescription and the value of
       * the Invoice (i.e., Quantity * Price). Order the results by Invoice value.
       */
      System.out.printf("%nInvoices mapped to description and invoice amount:%n");
      /*
       * Your solution
       */

      /*
       * Modify your previous solution to select the Invoice values in the range $200 to $500.
       */
      System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
      /*
       * Your solution
       */
   }
}
