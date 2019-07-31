

public interface dao<E> {
	void insert(E e);
	
    void select();
	
	void delete();
	
	void update();

	User getNamedUser(String name);

	User getUser(String username, String password);
}
