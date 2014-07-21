package core.model;

import lombok.Getter;
import lombok.Setter;

public class User extends Entry{
	
	private static final long serialVersionUID = 2157948016610174451L;

	@Getter @Setter private Integer userid;
	
	@Getter @Setter private String username;

	@Getter @Setter private String email;
	
	@Getter @Setter private String password;

	@Override
	public Integer getId() {
		return userid;
	}

	@Override
	public void setId(Integer id) {
		this.userid = id;
	}

}
