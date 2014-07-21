package core.service;

import core.model.EntryPage;
import core.model.User;

/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface UserService extends SupportService<User>{
	public boolean isRegisterByName(String userName);

	public EntryPage query(int i, int j);
}
