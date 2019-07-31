package io.pivotal.k8s.user.repository;

import io.pivotal.k8s.user.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
}
