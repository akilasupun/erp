package com.erp.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.erp.core.model.Dummy;
import com.erp.core.service.DummyService;

@Component
public class BasicApplicationRunner implements ApplicationRunner {
	@Autowired
	DummyService dumService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		dumService.save(new Dummy("Joran", "Schalanzki"));
	}

}
