package me.fincil.service;

import me.fincil.model.Book;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by HSWook on 2016. 6. 12..
 */
@Service
@Transactional
public class BookService extends ModelService<Book> {
}
