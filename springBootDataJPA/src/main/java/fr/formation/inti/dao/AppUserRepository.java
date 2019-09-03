package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	AppUser findByUserName(String userName);
}
