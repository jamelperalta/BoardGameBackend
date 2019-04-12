package DomainLayer;

/**
 * Entity: UserBoardGame
 * @author jamelperaltacoss, jorgecruz
 * It has all the attributes of a board game owned by the user.
 *
 */
public class UserBoardGame {

	// Instance Variables
	private String title;
	private String description;
	private String photo_url;
	private String category_name;
	private String category_desc;
	private int quantity;	// This quantity is have much is owned.
	private String publisher;
	private float average_playtime;
	private int max_player;
	private String username;
	private String transaction_type;
	private String transaction_date;

	// Constructor
	public UserBoardGame(String title, String description, String photo_url, 
			String category_name, String category_desc, int quantity, 
			String publisher, float average_playtime, int max_player, String username,
			String transaction_type, String transaction_date) {
		this.title = title;
		this.description = description;
		this.photo_url = photo_url;
		this.category_name = category_name;
		this.category_desc = category_desc;
		this.quantity = quantity;
		this.publisher = publisher;
		this.average_playtime = average_playtime;
		this.max_player = max_player;
		this.username = username;
		this.transaction_type = transaction_type;
		this.transaction_date = transaction_date;
	}

	// Methods
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
	
	public String getBg_id() {
		return title;
	}

	public void setBg_id(String bg_id) {
		this.title = bg_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_desc() {
		return category_desc;
	}

	public void setCategory_desc(String category_desc) {
		this.category_desc = category_desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public float getAverage_playtime() {
		return average_playtime;
	}

	public void setAverage_playtime(float average_playtime) {
		this.average_playtime = average_playtime;
	}

	public int getMax_player() {
		return max_player;
	}

	public void setMax_player(int max_player) {
		this.max_player = max_player;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
