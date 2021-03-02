package com.lear.service.impl;

import com.lear.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("save");
//        int i=1/0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("update"+i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("delete");
        return 0;
    }
}
