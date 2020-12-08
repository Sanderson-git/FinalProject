package co.grandcircus.FinalProject.SQL;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Long>{
	
	//public List<Genres> findByWishlistId(Long wishid);

}
