package zwy.importdata.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Map;

@Service
public interface EquipmentService {

    public LinkedHashSet<Map<String, String >> lineRatio();

    public LinkedHashSet<Map<String, String >> afc();
}
