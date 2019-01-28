package com.sampleuserservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.sampleuserservice.entity.Device;
import com.sampleuserservice.entity.User;

public interface DeviceRepository extends CrudRepository<Device, Long> {

	Device findByUser(User user);

}
