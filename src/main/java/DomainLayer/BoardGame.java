package DomainLayer;

/**
 * Entity: BoardGames
 * @author jamelperaltacoss, jorgecruz
 * An object that has all the attribute of a particular board game.
 *
 */
public class BoardGame {

	// Instance Variables
	private String title;
	private String description;
	private String photo_url;
	private String category_name;
	private String category_desc;
	private int quantity;	// This quantity can be for renting or for sale.
	private String publisher;
	private float average_playtime;
	private int max_player;
	private int bg_id;
	
	// Constructor
	public BoardGame(String title, String description, String photo_url, 
			String category_name, String category_desc, int quantity, 
			String publisher, float average_playtime, int max_player, int bg_id) {
		this.title = title;
		this.description = description;
		this.photo_url = photo_url;
		this.category_name = category_name;
		this.category_desc = category_desc;
		this.quantity = quantity;
		this.publisher = publisher;
		this.average_playtime = average_playtime;
		this.max_player = max_player;
		this.bg_id = bg_id;
	}

	// Methods
	
	@Override
	public String toString() {
		return "BoardGame [title=" + title + ", description=" + description + ", photo_url=" + photo_url
				+ ", category_name=" + category_name + ", category_desc=" + category_desc + ", quantity=" + quantity
				+ ", publisher=" + publisher + ", average_playtime=" + average_playtime + ", max_player=" + max_player
				+ "]";
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
}
