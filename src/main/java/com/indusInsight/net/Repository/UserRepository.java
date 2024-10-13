package com.indusInsight.net.Repository;

import com.indusInsight.net.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {

}
