package co.grandcircus.FinalProject.SQL;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long>{

	public List<WishList> findByUserId(Long id);
	
	
}
