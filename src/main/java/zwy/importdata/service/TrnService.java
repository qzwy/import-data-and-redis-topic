package zwy.importdata.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TrnService {

    List<Map<Object, Object>> DelayMsg();
    List<Map<Object, Object>> operationMsg();
}
