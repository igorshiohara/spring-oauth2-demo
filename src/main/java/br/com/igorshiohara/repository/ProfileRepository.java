package br.com.igorshiohara.repository;

import br.com.igorshiohara.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
