package com.tdls.job;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.scheduling.annotation.Scheduled;

public class AutoStartInit {
	/**
	 * 容器初始化的时候执行(项目启动时候)
	 */
	@PostConstruct
	public void init(){
		this.quartzInsert();
	}
	
	
	@PreDestroy 
    public void  dostory(){  
    }  
	/**
	 * 每天凌晨一点执行
	 */
	@Scheduled(cron = "0 0 1 * * *")
	public void  quartzInsert() {
		System.out.print("开始执行了");
	}
}
