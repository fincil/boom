package me.fincil.service;

import me.fincil.model.Room;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by HSWook on 2016. 6. 12..
 */
@Service
@Transactional
public class RoomService extends ModelService<Room> {
}
