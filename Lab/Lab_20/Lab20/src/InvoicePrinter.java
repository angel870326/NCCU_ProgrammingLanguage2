import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class InvoicePrinter {

	public static void main(String[] args) throws FileNotFoundException, SQLException{
				
		String server = "jdbc:mysql://140.119.19.73:9306/";
		String database = "Lab";
		String config= "?useUnicode=true&characterEncoding=utf8";
		String url = server + database + config;
		String username = "TG06";
		String password = "i8p3q6";
		Connection conn = null;

		System.out.print("Invoice number: ");
		Scanner in = new Scanner(System.in);
		int invoiceNum = in.nextInt();
		double total = 0;
		PrintWriter out = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
//			String sql = String.format("SELECT P.Product_Code, P.Description, P.Price, L.Quantity, (P.Price*L.Quantity) AS Subtotal FROM Product AS P, LineItem AS L WHERE L.Invoice_Number = %d AND P.Product_Code = L.Product_Code", invoiceNum);
			String sql = "SELECT L.Invoice_Number, P.Product_Code, P.Description, P.Price, L.Quantity, (P.Price*L.Quantity) AS Subtotal FROM Product AS P, LineItem AS L WHERE L.Invoice_Number = ? AND P.Product_Code = L.Product_Code";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, invoiceNum);			
			ResultSet result = stat.executeQuery();
			String detail = String.format("%15s %-20s %8s %8s %8s\n", "Product_Code", "Description", "Price", "Quantity", "Subtotal");		
			while (result.next() &&  invoiceNum == result.getInt("Invoice_Number")){
				detail = detail + String.format("%15s %-20s %8.2f %8d %8.2f\n", result.getString("Product_Code"), result.getString("Description"), result.getDouble("Price"), result.getInt("Quantity"), result.getDouble("Subtotal"));
				total = total + result.getDouble("Subtotal");
			}
			System.out.print(detail);
			System.out.println("Total: " + total);
			
			out = new PrintWriter(String.format("%d.txt", invoiceNum)); 
			out.println("Invoice number: " + invoiceNum);
			out.print(detail);
			out.println("Total: " + total);

		}
		finally {
			in.close();
			conn.close();
			out.close();
		}
		
	}

}
