package com.kishore.sekhar.dtoDesignPattern22;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	Optional<Post> findById(Long id);

}