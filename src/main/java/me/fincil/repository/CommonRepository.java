package me.fincil.repository;

import me.fincil.model.Model;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by HSWook on 2016. 6. 7..
 */
public interface CommonRepository<T extends Model>
    extends PagingAndSortingRepository<T, Long> {
}
