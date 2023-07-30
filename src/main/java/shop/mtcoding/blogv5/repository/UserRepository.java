package shop.mtcoding.blogv5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.mtcoding.blogv5.model.User;

//DAO date acess object
//자동으로 bean등록이 된다.
//@Repository 생략이 가능하다.
public interface UserRepository extends JpaRepository<User, Integer>{

}
