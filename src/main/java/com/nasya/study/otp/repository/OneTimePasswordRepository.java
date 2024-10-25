package com.nasya.study.otp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nasya.study.otp.enitity.OneTimePassword;

@Repository
public interface OneTimePasswordRepository extends CrudRepository<OneTimePassword, Long> {

}
