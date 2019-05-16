package DomainLayer;

/**
 * Entity: Transaction
 * @author jamelperaltacoss, jorgecruz
 * It has the information of a sale or rent transaction with a particular board game.
 *
 */
public class Transaction {
	
	// Instance Variables 
	private int lib_id;
	private int u_id;
	private int bg_id;
	private String transaction_type;
	private String transaction_date;
	
	// Constructor 
	public Transaction(int lib_id, int u_id, int bg_id,
			String trans_type, String trans_date) {
		this.lib_id = lib_id;
		this.u_id = u_id;
		this.bg_id = bg_id;
		this.transaction_date = trans_date;
		this.transaction_type = trans_type;
	}

	// Setters and Getters 
	public int getLib_id() {
		return lib_id;
	}
	public void setLib_id(int lib_id) {
		this.lib_id = lib_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getBg_id() {
		return bg_id;
	}
	public void setBg_id(int bg_id) {
		this.bg_id = bg_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	
	
}
