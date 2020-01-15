package zwy.importdata.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MongoRepo {
    List<String> findByType(String type, String collections, int page, int size);
    void addDataQuery(String DataQuery);
}
