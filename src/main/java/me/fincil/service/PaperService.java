package me.fincil.service;

import me.fincil.model.Paper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by HSWook on 2016. 6. 12..
 */
@Service
@Transactional
public class PaperService extends ModelService<Paper> {
}
