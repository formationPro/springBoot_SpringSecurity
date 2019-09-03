package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.inti.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

	@Query("Select ur.appRole.roleName from UserRole ur where ur.appUser.userId = :userId")
	public List<String> findAllByUserId(@Param("userId") Long id);
}
