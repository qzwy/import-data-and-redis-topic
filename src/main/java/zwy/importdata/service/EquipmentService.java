package zwy.importdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface EquipmentService {

    public LinkedHashSet<Map<String, String >> lineRatio();

    public LinkedHashSet<Map<String, String >> afc();
}
