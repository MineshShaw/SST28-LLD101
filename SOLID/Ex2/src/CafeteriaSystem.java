import java.util.*;

public class CafeteriaSystem {
    private final Menu menu;
    
    private final InvoiceService invoiceService;
    

    public CafeteriaSystem(Menu menu, FileStore store) {
         this.menu = menu;
         this.invoiceService = new InvoiceService(store);
    }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invoice = invoiceService.generateInvoice(menu, lines, customerType);

        System.out.print(invoice);        
    }
}
