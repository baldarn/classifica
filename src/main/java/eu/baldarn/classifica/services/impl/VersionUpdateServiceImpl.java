package eu.baldarn.classifica.services.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.baldarn.classifica.repository.UserRepository;
import eu.baldarn.classifica.services.VersionUpdateService;

@Service
public class VersionUpdateServiceImpl implements VersionUpdateService {
	
	@Autowired
	private UserRepository userRepository;
	
//	private final Logger logger = LoggerFactory.getLogger(VersionUpdateServiceImpl.class);
	
	@PostConstruct
	@Override
	public void init(){
	}
	
}
