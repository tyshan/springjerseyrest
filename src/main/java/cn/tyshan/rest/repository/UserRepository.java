package cn.tyshan.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.tyshan.rest.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
