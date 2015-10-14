package cn.tyshan.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.tyshan.rest.model.User;

/**
 * user dao for crud and page,sort
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
