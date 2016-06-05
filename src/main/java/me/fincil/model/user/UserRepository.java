package me.fincil.model.user;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by HSWook on 2016. 5. 11..
 */
public interface UserRepository<T extends  User>
        extends PagingAndSortingRepository<T, Long> {

}
