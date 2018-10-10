package com.jonas.service;

import com.jonas.domain.Girl;
import com.jonas.enums.ResultEnum;
import com.jonas.exception.GirlException;
import com.jonas.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author Jonas
 * 2018/9/3 9:57
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age < 10){
            //返回"你还在上小学吧" code: 100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回"你可能在上初中" code: 101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findById(Integer id) {
        return girlRepository.findById(id).get();
    }
}
